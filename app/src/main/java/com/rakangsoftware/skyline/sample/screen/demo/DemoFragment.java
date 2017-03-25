package com.rakangsoftware.skyline.sample.screen.demo;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rakangsoftware.skyline.mvpvm.SkylineFragment;
import com.rakangsoftware.skyline.sample.BR;
import com.rakangsoftware.skyline.sample.R;
import com.rakangsoftware.skyline.sample.databinding.FragmentDemoBinding;

public class DemoFragment extends SkylineFragment<DemoPresenter, DemoViewModel> {

    private FragmentDemoBinding mBinding;

    public DemoFragment() {

    }

    public static Fragment newInstance() {
        return new DemoFragment();
    }

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable final Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_demo,
                container,
                false
        );

        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(final View view, @Nullable final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mBinding.setVariable(BR.viewModel, getViewModel());
        mBinding.setVariable(BR.presenter, getPresenter());
    }

    @Override
    protected DemoPresenter createPresenter(final DemoViewModel viewModel) {
        return new DemoPresenter(viewModel);
    }
    
    /* Creation */

    @Override
    protected DemoViewModel createViewModel() {
        return new DemoViewModel();
    }

}
