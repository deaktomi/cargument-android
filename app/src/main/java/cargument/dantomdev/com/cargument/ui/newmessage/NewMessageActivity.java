package cargument.dantomdev.com.cargument.ui.newmessage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import javax.inject.Inject;

import cargument.dantomdev.com.cargument.CargumentApplication;
import cargument.dantomdev.com.cargument.R;
import cargument.dantomdev.com.cargument.model.Conversation;

public class NewMessageActivity extends AppCompatActivity implements NewMessageScreen {
    @Inject
    NewMessagePresenter newMessagePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_message);

        CargumentApplication.injector.inject(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        newMessagePresenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        newMessagePresenter.detachScreen();
    }

    @Override
    public void sendMessage(Conversation conversation) {

    }

    @Override
    public void showMessage(String message) {

    }
}
