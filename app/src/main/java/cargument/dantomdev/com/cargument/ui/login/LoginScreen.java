package cargument.dantomdev.com.cargument.ui.login;

import cargument.dantomdev.com.cargument.model.User;

public interface LoginScreen {
    void showMessage(String text);
    void navigateToMain(User user);
}
