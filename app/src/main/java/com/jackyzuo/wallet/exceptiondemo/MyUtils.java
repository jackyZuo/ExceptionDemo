package com.jackyzuo.wallet.exceptiondemo;

import com.jackyzuo.wallet.baselib.BaseUtils;
import com.jackyzuo.wallet.baselib.ZException;

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
    public Map<String, String> encryptParams(Map<String, String> params) throws ZException {
        if (params==null ){
            throw new ZException("params 不能为null ");
        }

        return params;
    }

}
