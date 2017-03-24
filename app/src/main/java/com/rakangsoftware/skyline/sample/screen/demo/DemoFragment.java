package com.rakangsoftware.skyline.sample.screen.demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rakangsoftware.skyline.mvpvm.SkylineFragment;
import com.rakangsoftware.skyline.sample.R;

public class DemoFragment extends SkylineFragment<DemoPresenter, DemoViewModel> {

    public DemoFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable final Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_demo, container, false);
    }

    @Override
    protected DemoPresenter createPresenter(final DemoViewModel viewModel) {
        return new DemoPresenter(viewModel);
    }

    @Override
    protected DemoViewModel createViewModel() {
        return new DemoViewModel();
    }

     /* Creation */

    public static Fragment newInstance() {
        return new DemoFragment();
    }
}
