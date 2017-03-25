package com.rakangsoftware.skyline.sample.screen.demo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.rakangsoftware.skyline.sample.R;

public class DemoActivity extends AppCompatActivity {

    public static void start(Context context) {
        context.startActivity(new Intent(context, DemoActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_demo);

        if (savedInstanceState == null) {
            loadFragment(DemoFragment.newInstance());
        }
    }

    private void loadFragment(final Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
    }
}
