package com.zzy.ecom.activity;

import android.app.ActionBar;
import android.os.Bundle;
import android.app.Activity;

import com.zzy.ecom.R;

public class UserSetting extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_setting);

        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

}
