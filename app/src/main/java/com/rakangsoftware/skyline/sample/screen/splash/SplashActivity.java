package com.rakangsoftware.skyline.sample.screen.splash;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.rakangsoftware.skyline.sample.R;
import com.rakangsoftware.skyline.sample.screen.demo.DemoActivity;

public class SplashActivity extends AppCompatActivity {

    private static final int SPLASH_DELAY = 3000;

    private final Handler  mHandler  = new Handler();
    private final Launcher mLauncher = new Launcher();

    @Override
    protected void onStart() {
        super.onStart();

        mHandler.postDelayed(mLauncher, SPLASH_DELAY);
    }

    @Override
    protected void onStop() {
        mHandler.removeCallbacks(mLauncher);

        super.onStop();
    }

    private void launch() {
        if (!isFinishing()) {
            startActivity(new Intent(SplashActivity.this, DemoActivity.class));
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            finish();
        }
    }

    private class Launcher implements Runnable {
        @Override
        public void run() {
            launch();
        }
    }
}