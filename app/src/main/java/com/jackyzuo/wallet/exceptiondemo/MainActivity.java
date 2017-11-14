package com.jackyzuo.wallet.exceptiondemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.jackyzuo.wallet.baselib.ZException;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class MainActivity extends Activity implements View.OnClickListener {

    private final String TAG = "jacky" ;
    private TextView mTv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_success).setOnClickListener(this);
        findViewById(R.id.btn_fail).setOnClickListener(this);
        mTv = findViewById(R.id.tv);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_success:
                success();
                break;
            case R.id.btn_fail:
                fail();
                break;
        }
    }

    private void fail() {
        encrypted(null);
    }

    private void success() {
        HashMap<String, String> map = new HashMap<>();
        map.put("name","jacky左");
        map.put("work","Android");
        encrypted(map);
    }

    private void encrypted(Map<String, String> params){
        MyUtils utils = new MyUtils();
        try {
            Map<String, String> encryparams = utils.encryptParams(params);
            String toJson = utils.toJson(encryparams);
            Logger.getLogger(TAG).info(toJson);
            mTv.setText(toJson);
        } catch (ZException e) {
            Logger.getLogger(TAG).info(e.toString());
            mTv.setText(e.toString());
        }
    }
}
