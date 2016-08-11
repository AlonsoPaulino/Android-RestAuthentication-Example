package com.luisalonso.restauthentication.presentation.intro;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.luisalonso.restauthentication.R;
import com.luisalonso.restauthentication.base.BaseActivity;
import com.luisalonso.restauthentication.base.BaseFragment;
import com.luisalonso.restauthentication.presentation.login.LoginActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Luis Alonso Paulino Flores <alonsopf1@gmail.com>
 */
public class IntroFragment extends BaseFragment implements IntroContract.View {

    @BindView(R.id.logout_button) Button mLogoutButton;

    private IntroPresenter mPresenter;

    public static IntroFragment newInstance() {
        return new IntroFragment();
    }

    @Override
    public IntroContract.Presenter getPresenter() {
        if (mPresenter == null) {
            mPresenter = new IntroPresenter(this);
        }
        return mPresenter;
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_intro;
    }

    @Override
    protected void setupView(Bundle savedInstanceState) {

    }

    @OnClick(value = R.id.logout_button)
    void logout() {
        getPresenter().logout();
    }

    public void sendToLoginActivity() {
        mContext.startActivity(new Intent(mContext, LoginActivity.class));
        ((BaseActivity) mContext).finish();
    }
}
