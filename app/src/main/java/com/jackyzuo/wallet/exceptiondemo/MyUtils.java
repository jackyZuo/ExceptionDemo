package com.jackyzuo.wallet.exceptiondemo;

import com.jackyzuo.wallet.baselib.BaseUtils;
import java.util.Map;

/**
 * 文件描述：test
 * @author Created by jackyZuo on 2017/10/27.
 */
public class MyUtils extends BaseUtils {

    /**
     * Error:(13, 32) 错误: MyUtils中的encryptParams(Map<String,String>)无法覆盖BaseUtils中的encryptParams(Map<String,String>)
     被覆盖的方法未抛出Exception
     * @param params
     * @return
     * @throws Exception
     */
    @Override
    public Map<String, String> encryptParams(Map<String, String> params) throws Exception {
        if (params==null || params.size()==0){
            return super.encryptParams(params);
        }

        String json = toJson(params);
        String key = getkey(0);
        params.clear();

        params.put(key,json);
        return params;
    }

    private String getkey(int num) throws Exception {
        switch (num){
            case 0:
                return "key0";
            case 1:
                return "key1";
            default:
                throw new Exception("error");
        }
    }

}
