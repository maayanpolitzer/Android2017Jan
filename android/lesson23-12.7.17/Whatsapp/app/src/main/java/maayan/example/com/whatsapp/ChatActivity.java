package maayan.example.com.whatsapp;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class ChatActivity extends BaseActivity {

    private LinearLayout messagesLayout;
    private EditText messageET;
    private ScrollView scrollView;
    private Handler handler;
    private int recipientID;
    private int myID;

    private String content;
    private Thread getMessagesThread;

    private boolean running;
    private JSONObject obj;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        messagesLayout = (LinearLayout) findViewById(R.id.chat_activity_messages_layout);
        findViewById(R.id.chat_output_area_send_image_view).setOnClickListener(drawOutgoingMessage);
        messageET = (EditText) findViewById(R.id.chat_output_area_message_edit_text);
        scrollView = (ScrollView) findViewById(R.id.chat_activity_scroll_view);
        handler = new Handler();

        myID = settings.getInt(USER_ID, -1);
        String name = getIntent().getStringExtra(EMAIL);
        getSupportActionBar().setTitle("Chat with " + name);

        recipientID = getIntent().getIntExtra(USER_ID, -1);
        getHistory();



        obj = new JSONObject();
        try {
            obj.put(ACTION, "GET_MESSAGE");
            obj.put(USER_ID, myID);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        getMessagesThread = new Thread(new Runnable() {
            @Override
            public void run() {
                running = true;
                while(running){
                    new ConnectionThread(handler, ChatActivity.this, obj).start();
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        getMessagesThread.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        running = false;
    }

    private void getHistory(){
        DbOpenHelper helper = new DbOpenHelper(this);
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.query(
                DbOpenHelper.TABLE_MESSAGES,
                new String[]{DbOpenHelper.COL_TO, DbOpenHelper.COL_MESSAGE},
                DbOpenHelper.COL_FROM + "=" + recipientID + " OR " + DbOpenHelper.COL_TO + "=" + recipientID,
                null,
                null,
                null,
                null
        );
        if (cursor != null && cursor.moveToFirst()){
            do{
                String message = cursor.getString(cursor.getColumnIndex(DbOpenHelper.COL_MESSAGE));
                int receiver = cursor.getInt(cursor.getColumnIndex(DbOpenHelper.COL_TO));
                drawMessage(receiver == myID, message);
            }while(cursor.moveToNext());
        }
    }

    private View.OnClickListener drawOutgoingMessage = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            content = messageET.getText().toString().trim();
            if (!content.isEmpty()){
                JSONObject data = new JSONObject();
                try {
                    data.put(ACTION, SEND_MESSAGE);
                    data.put("from", myID);
                    data.put("to", recipientID);
                    data.put("message", content);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                new ConnectionThread(ChatActivity.this, data).start();
            }
        }
    };

    private void drawMessage(boolean incoming, String content){
        View view = getLayoutInflater().inflate(incoming ? R.layout.message_in : R.layout.message_out, null);
        TextView tv = (TextView) view.findViewById(R.id.message_text_view);
        tv.setText(content);
        messagesLayout.addView(view);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                scrollView.fullScroll(ScrollView.FOCUS_DOWN);
            }
        },200);
    }

    @Override
    public void onSuccess(JSONObject data) {
        try {
            if (data.getBoolean("response")) {
                // outgoing message...
                new InsertDataThread(this, myID, recipientID, content).start();
                messageET.setText("");
                drawMessage(false, content);
            }
        } catch (JSONException e) {
            // incoming message...
            try {
                JSONObject message = data.getJSONObject("message");
                if (message.toString().length() > 2){
                    int from = message.getInt("from");
                    String content = message.getString("message");
                    new InsertDataThread(this, from, myID, content).start();
                    if (from == recipientID){
                        drawMessage(true, content);
                    }
                }

            } catch (JSONException e1) {
                e1.printStackTrace();
            }
        }
    }

    @Override
    public void onFailure(String error) {

    }
}
