package com.rakangsoftware.skyline.mvpvm;

import android.os.Bundle;

public interface SkylineViewModel {
    void setState(Bundle savedInstanceState);

    Bundle getState();
}
