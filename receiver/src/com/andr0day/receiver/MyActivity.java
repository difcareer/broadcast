package com.andr0day.receiver;

import android.app.Activity;
import android.content.IntentFilter;
import android.os.Bundle;

public class MyActivity extends Activity {
    private MyReceiver myReceiver = new MyReceiver();

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        IntentFilter intentFilter = new IntentFilter("com.andr0day.broadcast");
//        MyActivity.this.registerReceiver(myReceiver, intentFilter);
        MyActivity.this.registerReceiver(new MyReceiver(), intentFilter, "com.andr0day.permission.sender", null);
    }

    public void onDestroy() {
        super.onDestroy();
        MyActivity.this.unregisterReceiver(myReceiver);
    }
}
