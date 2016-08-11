package com.luisalonso.restauthentication.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Created by Luis Alonso Paulino Flores <alonsopf1@gmail.com>
 */
public abstract class BaseFragment extends Fragment implements BaseView {

    protected Context mContext;

    protected abstract int getLayout();
    protected abstract void setupView(Bundle savedInstanceState);

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayout(), container, false);
        if (view != null) {
            return view;
        }
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        setupView(savedInstanceState);
    }

    @Override
    public void showMessage(String message) {
        ((BaseActivity) mContext).showMessage(message);
    }

    @Override
    public void showMessage(int res) {
        ((BaseActivity) mContext).showMessage(res);
    }

    @Override
    public void startLoader() {
        ((BaseActivity) mContext).startLoader();
    }

    @Override
    public void stopLoader() {
        ((BaseActivity) mContext).stopLoader();
    }
}
