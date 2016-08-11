package com.luisalonso.restauthentication.base;

/**
 * Created by Luis Alonso Paulino Flores <alonsopf1@gmail.com>
 */
public interface BaseView {
    void showMessage(String message);
    void showMessage(int res);
    void startLoader();
    void stopLoader();
}
