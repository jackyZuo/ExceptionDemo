package com.jackyzuo.wallet.baselib;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;

/**
 * 文件描述：
 * @author ：Created by jackyZuo on 2017/10/27.
 */
public class BaseUtils {

    //混淆后 gradle 1.5.0
//    public Map encryptParams(Map var1) {
//        return var1;
//    }

    //混淆后 gradle 2.3.3
//    public Map<String, String> encryptParams(Map<String, String> var1) {
//        return var1;
//    }

    //混淆前
    public Map<String, String> encryptParams(Map<String, String> params) throws Exception {
        return params;
    }

    public String toJson(Map<String, String> map) {
        if (map == null || map.size() == 0) {
            return null;
        }

        try {
            JSONObject json = new JSONObject();
            for (String key : map.keySet()) {
                json.put(key, map.get(key));
            }
            return json.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

}
