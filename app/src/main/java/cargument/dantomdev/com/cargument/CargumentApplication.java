package cargument.dantomdev.com.cargument;

import android.app.Application;

import cargument.dantomdev.com.cargument.ui.UIModule;

public class CargumentApplication extends Application {

    public static CargumentApplicationComponent injector;

    @Override
    public void onCreate() {
        super.onCreate();

        injector =
                DaggerCargumentApplicationComponent.builder().
                        uIModule(
                                new UIModule(this)
                        ).build();
    }
}