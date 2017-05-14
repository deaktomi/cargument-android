package cargument.dantomdev.com.cargument.ui.conversation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import javax.inject.Inject;

import cargument.dantomdev.com.cargument.CargumentApplication;
import cargument.dantomdev.com.cargument.R;
import cargument.dantomdev.com.cargument.model.Conversation;
import cargument.dantomdev.com.cargument.model.Message;
import cargument.dantomdev.com.cargument.ui.login.LoginPresenter;

public class ConversationActivity extends AppCompatActivity implements ConversationScreen {
    @Inject
    ConversationPresenter conversationPresenter;

    TextView etPartner;
    LinearLayout llMessages;
    EditText etNewMessage;
    Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversation);

        etPartner = (TextView) findViewById(R.id.etPartner);
        llMessages = (LinearLayout) findViewById(R.id.llMessages);
        btnSend = (Button) findViewById(R.id.btnSend);
        etNewMessage = (EditText) findViewById(R.id.etNewMessage) ;


        CargumentApplication.injector.inject(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        conversationPresenter.attachScreen(this);

        conversationPresenter.getConversationDetail(1);
    }

    @Override
    protected void onStop() {
        super.onStop();
        conversationPresenter.detachScreen();
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showMessages(final Conversation conversation) {
        etPartner.setText(conversation.getUser2().getName() + " - " + conversation.getUser2().getRegNumber());
        for (Message m : conversation.getMessages()) {
            TextView tv = new TextView(this);
            tv.setText(m.getBody());
            llMessages.addView(tv);
        }

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Message message = new Message(Long.valueOf(conversation.getConversationId()), "1", etNewMessage.getText().toString(), 1);
                conversationPresenter.addNewMessage(conversation.getConversationId(), message);
            }
        });
    }

    @Override
    public void sendMessage(Message message) {

    }
}
