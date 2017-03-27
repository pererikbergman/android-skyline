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

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.os.Bundle;

import com.rakangsoftware.skyline.mvpvm.SkylineViewModel;
import com.rakangsoftware.skyline.sample.BR;

public class DemoViewModel extends BaseObservable implements SkylineViewModel {

    private static final String STATE_TEXT = "text";

    private String text;

    @Bindable
    public String getText() {
        return text;
    }

    public void setText(final String text) {
        this.text = text;
        notifyPropertyChanged(BR.text);
    }
    
    /* Lifecycle */

    public Bundle getState() {
        Bundle bundle = new Bundle();
        bundle.putString(STATE_TEXT, text);

        return bundle;
    }

    public void setState(Bundle bundle) {
        if (bundle != null) {
            text = bundle.getString(STATE_TEXT, "");
        }
    }

}
