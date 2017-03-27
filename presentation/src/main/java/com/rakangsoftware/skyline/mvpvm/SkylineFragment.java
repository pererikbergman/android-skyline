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
