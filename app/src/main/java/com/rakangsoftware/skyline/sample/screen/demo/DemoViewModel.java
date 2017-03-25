package com.rakangsoftware.skyline.sample.screen.demo;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.os.Bundle;

import com.rakangsoftware.skyline.view.SkylineViewModel;
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
