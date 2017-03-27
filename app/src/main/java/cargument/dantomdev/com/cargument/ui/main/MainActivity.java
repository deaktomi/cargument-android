package cargument.dantomdev.com.cargument.ui.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import javax.inject.Inject;

import cargument.dantomdev.com.cargument.CargumentApplication;
import cargument.dantomdev.com.cargument.R;

public class MainActivity extends AppCompatActivity implements MainScreen {

    @Inject
    MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CargumentApplication.injector.inject(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mainPresenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mainPresenter.detachScreen();
    }

    @Override
    public void showMessages() {

    }

    @Override
    public void openMessage(int id) {

    }

    @Override
    public void newMessage() {

    }
}
