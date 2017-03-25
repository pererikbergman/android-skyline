package com.rakangsoftware.skyline.sample.screen.demo;

import com.rakangsoftware.skyline.view.SkylinePresenter;

public class DemoPresenter implements SkylinePresenter {

    private final DemoViewModel mViewModel;

    public DemoPresenter(final DemoViewModel viewModel) {
        mViewModel = viewModel;
    }

    /* Lifecycle */

    public void start() {

    }

    public void stop() {

    }
     
    /* User interaction input from view. */

    public void click() {
        mViewModel.setText("Hello World!");
    }

}
