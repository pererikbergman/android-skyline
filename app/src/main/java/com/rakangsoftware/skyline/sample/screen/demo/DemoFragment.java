/*
 * Copyright 2017 Per-Erik Bergman (info@rakangsoftware.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
