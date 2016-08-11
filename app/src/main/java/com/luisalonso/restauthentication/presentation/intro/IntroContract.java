package com.luisalonso.restauthentication.presentation.intro;

import com.luisalonso.restauthentication.base.BaseContractView;
import com.luisalonso.restauthentication.base.BasePresenter;

/**
 * Created by Luis Alonso Paulino Flores <alonsopf1@gmail.com>
 */
public class IntroContract {

    interface View extends BaseContractView<Presenter> {
        void sendToLoginActivity();
    }

    interface Presenter extends BasePresenter {
        void logout();
    }
}
