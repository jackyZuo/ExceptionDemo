package com.jackyzuo.wallet.baselib;

/**
 * Created by zuoxiangyu on 2017/11/14.
 */
public class ZException extends RuntimeException {

    private static final long serialVersionUID = -2912559384646531479L;

    public ZException(String detailMessage) {
        super(detailMessage);
    }

    public ZException(Throwable throwable) {
        super(throwable);
    }

    public ZException(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
    }

}
