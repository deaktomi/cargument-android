package cargument.dantomdev.com.cargument.ui.conversation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import javax.inject.Inject;

import cargument.dantomdev.com.cargument.CargumentApplication;
import cargument.dantomdev.com.cargument.R;
import cargument.dantomdev.com.cargument.model.Conversation;
import cargument.dantomdev.com.cargument.model.Message;
import cargument.dantomdev.com.cargument.ui.login.LoginPresenter;

public class ConversationActivity extends AppCompatActivity implements ConversationScreen {
    @Inject
    ConversationPresenter conversationPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversation);

        CargumentApplication.injector.inject(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        conversationPresenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        conversationPresenter.detachScreen();
    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public void showMessages(Conversation conversation) {

    }

    @Override
    public void sendMessage(Message message) {

    }
}
