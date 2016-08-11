package com.luisalonso.restauthentication.presentation.login;

import com.luisalonso.restauthentication.base.BaseContractView;
import com.luisalonso.restauthentication.base.BasePresenter;

/**
 * Created by Luis Alonso Paulino Flores <alonsopf1@gmail.com>
 */
public class LoginContract {

    interface View extends BaseContractView<Presenter> {
        void sendToMainActivity();
    }

    interface Presenter extends BasePresenter {
        void login(String username, String password);
    }
}
