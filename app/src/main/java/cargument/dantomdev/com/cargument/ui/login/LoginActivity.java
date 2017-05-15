package cargument.dantomdev.com.cargument.ui.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

import javax.inject.Inject;

import cargument.dantomdev.com.cargument.CargumentApplication;
import cargument.dantomdev.com.cargument.R;
import cargument.dantomdev.com.cargument.model.User;
import cargument.dantomdev.com.cargument.ui.main.MainActivity;
import cargument.dantomdev.com.cargument.ui.main.MainPresenter;

public class LoginActivity extends AppCompatActivity implements LoginScreen {

    @Inject
    LoginPresenter loginPresenter;

    Button btnLogin;
    EditText etRegNumber;

    Tracker mTracker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        CargumentApplication.injector.inject(this);

        btnLogin = (Button)findViewById(R.id.btnLogin);
        etRegNumber = (EditText)findViewById(R.id.etRegNumber);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginPresenter.login(etRegNumber.getText().toString());
            }
        });

        // Obtain the shared Tracker instance.
        CargumentApplication application = (CargumentApplication) getApplication();
        mTracker = application.getDefaultTracker();
    }



    @Override
    protected void onStart() {
        super.onStart();
        loginPresenter.attachScreen(this);

        Log.i("TAG", "Setting screen name: Login");
        mTracker.setScreenName("Image~Login");
        mTracker.send(new HitBuilders.ScreenViewBuilder().build());

        mTracker.send(new HitBuilders.EventBuilder()
                .setCategory("Action")
                .setAction("Share")
                .build());
    }

    @Override
    protected void onStop() {
        super.onStop();
        loginPresenter.detachScreen();
    }

    @Override
    public void showMessage(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void navigateToMain(User user) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("userId", user.getId());
        startActivity(intent);
    }

    public void forceCrash(View view) {
        throw new RuntimeException("This is a crash");
    }

}
