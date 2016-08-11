package com.luisalonso.restauthentication.presentation;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;

import com.luisalonso.restauthentication.R;
import com.luisalonso.restauthentication.base.BaseActivity;
import com.luisalonso.restauthentication.presentation.intro.IntroFragment;

public class MainActivity extends BaseActivity {

    @Override
    protected boolean hasSecureModeEnable() {
        return false;
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void setupView(Bundle savedInstanceState) {
        FragmentManager manager = getSupportFragmentManager();
        IntroFragment fragment = (IntroFragment) manager.findFragmentById(R.id.main_content);
        if (fragment == null) {
            fragment = IntroFragment.newInstance();
            addFragment(fragment, R.id.main_content);
        }
    }
}
