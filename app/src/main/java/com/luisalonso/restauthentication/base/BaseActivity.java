package com.luisalonso.restauthentication.base;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import com.luisalonso.restauthentication.R;

import butterknife.ButterKnife;

/**
 * Created by Luis Alonso Paulino Flores <alonsopf1@gmail.com>
 */
public abstract class BaseActivity extends AppCompatActivity implements BaseView {

    private ProgressDialog mProgressDialog;

    protected abstract boolean hasSecureModeEnable();
    protected abstract int getLayout();
    protected abstract void setupView(Bundle savedInstanceState);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (hasSecureModeEnable()) {
            getWindow().setFlags(
                    WindowManager.LayoutParams.FLAG_SECURE,
                    WindowManager.LayoutParams.FLAG_SECURE
            );
        }
        setContentView(getLayout());
        ButterKnife.bind(this);
        setupView(savedInstanceState);
    }

    @Override
    public void showMessage(String message) {
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle(getString(R.string.app_name))
                .setMessage(message)
                .setPositiveButton(getString(R.string.dialog_positive_button), null)
                .create();
        dialog.setCancelable(false);
        dialog.show();
    }

    @Override
    public void showMessage(int res) {
        showMessage(getString(res));
    }

    @Override
    public void startLoader() {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(this);
        }
        mProgressDialog.show();
    }

    @Override
    public void stopLoader() {
        if (mProgressDialog != null) {
            mProgressDialog.dismiss();
        }
    }

    protected void addFragment(@NonNull Fragment fragment, int fragmentId) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(fragmentId, fragment);
        transaction.commit();
    }
}