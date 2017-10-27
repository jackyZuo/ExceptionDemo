package com.jackyzuo.wallet.exceptiondemo;

import android.app.Activity;
import android.os.Bundle;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class MainActivity extends Activity {

    public final String TAG = "jacky" ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        MyUtils utils = new MyUtils();
        HashMap<String, String> map = new HashMap<>();
        map.put("name","jacky左");
        map.put("work","Android");

        try {
            Map<String, String> params = utils.encryptParams(map);
            String toJson = utils.toJson(params);
            Logger.getLogger(TAG).info(toJson);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
