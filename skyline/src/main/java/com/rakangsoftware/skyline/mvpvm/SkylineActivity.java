package com.rakangsoftware.skyline.mvpvm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public abstract class SkylineActivity<P extends SkylinePresenter, M extends SkylineViewModel> extends AppCompatActivity {

    private P mPresenter;
    private M mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mViewModel = createViewModel();
        mPresenter = createPresenter(mViewModel);
    }

    @Override
    protected void onRestoreInstanceState(final Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        if (mViewModel != null) {
            mViewModel.setState(savedInstanceState);
        }
    }

    @Override
    public void onResume() {
        super.onResume();

        if (mPresenter != null) {
            mPresenter.start();
        }
    }

    @Override
    public void onPause() {
        if (mPresenter != null) {
            mPresenter.stop();
        }

        super.onPause();
    }

    @Override
    public void onSaveInstanceState(final Bundle outState) {
        if (mViewModel != null) {
            outState.putAll(mViewModel.getState());
        }

        super.onSaveInstanceState(outState);
    }

    protected abstract P createPresenter(final M viewModel);

    protected abstract M createViewModel();
}
