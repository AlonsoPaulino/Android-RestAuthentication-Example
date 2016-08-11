package com.luisalonso.restauthentication.presentation.intro;

import com.luisalonso.restauthentication.store.PreferencesManager;

/**
 * Created by Luis Alonso Paulino Flores <alonsopf1@gmail.com>
 */
public class IntroPresenter implements IntroContract.Presenter {

    private IntroContract.View mView;

    public IntroPresenter(IntroContract.View view) {
        mView = view;
    }

    @Override
    public void start() {

    }

    @Override
    public void logout() {
        PreferencesManager.setSessionState(false);
        mView.sendToLoginActivity();
    }
}
