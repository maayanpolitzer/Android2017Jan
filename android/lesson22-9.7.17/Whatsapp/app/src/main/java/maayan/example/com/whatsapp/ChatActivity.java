package maayan.example.com.whatsapp;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import org.json.JSONObject;

public class ChatActivity extends BaseActivity {

    private LinearLayout messagesLayout;
    private EditText messageET;
    private ScrollView scrollView;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        messagesLayout = (LinearLayout) findViewById(R.id.chat_activity_messages_layout);
        findViewById(R.id.chat_output_area_send_image_view).setOnClickListener(drawOutgoingMessage);
        messageET = (EditText) findViewById(R.id.chat_output_area_message_edit_text);
        scrollView = (ScrollView) findViewById(R.id.chat_activity_scroll_view);
        handler = new Handler();

        String name = getIntent().getStringExtra(EMAIL);
        getSupportActionBar().setTitle("Chat with " + name);

    }

    private View.OnClickListener drawOutgoingMessage = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String content = messageET.getText().toString().trim();
            if (!content.isEmpty()){
                drawMessage(false, content);
            }

        }
    };

    public void drawIncomingMessage(View view) {
        drawMessage(true, "INCOMING");
    }

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

    }

    @Override
    public void onFailure(String error) {

    }
}
