package com.luisalonso.restauthentication.base;

/**
 * Created by Luis Alonso Paulino Flores <alonsopf1@gmail.com>
 */
public interface BaseContractView<T extends BasePresenter> extends BaseView{
    T getPresenter();
}
