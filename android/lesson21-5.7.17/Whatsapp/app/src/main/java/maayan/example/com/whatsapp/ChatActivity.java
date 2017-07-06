package maayan.example.com.whatsapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ChatActivity extends AppCompatActivity {

    private LinearLayout messagesLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        messagesLayout = (LinearLayout) findViewById(R.id.chat_activity_messages_layout);
        findViewById(R.id.chat_output_area_send_image_view).setOnClickListener(drawOutgoingMessage);
    }

    private View.OnClickListener drawOutgoingMessage = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            drawMessage("OUTGOING");
        }
    };

    public void drawIncomingMessage(View view) {
        drawMessage("INCOMING");
    }

    private void drawMessage(String content){
        TextView tv = new TextView(this);
        tv.setText(content);
        messagesLayout.addView(tv);
    }
}
