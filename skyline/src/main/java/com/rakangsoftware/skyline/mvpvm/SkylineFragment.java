package com.rakangsoftware.skyline.mvpvm;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

public abstract class SkylineFragment<P extends SkylinePresenter, M extends SkylineViewModel> extends Fragment {

    private P mPresenter;
    private M mViewModel;

    public SkylineFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mViewModel = createViewModel();
        mPresenter = createPresenter(mViewModel);
    }

    @Override
    public void onViewStateRestored(@Nullable final Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);

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

    public P getPresenter() {
        return mPresenter;
    }

    public M getViewModel() {
        return mViewModel;
    }
}
