package com.chnMicro.MFExchange;

/**
 * Created by Enel on 2015/1/26.
 */
public interface Constants {
//    String HOST = "https://interface.weijinsuo.com:8999/";
//    String HOST_TEST = "http://test.weijinsuo.com:8336/";
//	String HOST_TEST_LOCAL = "http://192.168.1.22:8336/";

    String HOST = "http://192.168.1.22:8336/";
//    String HOST = "https://interface.weijinsuo.com:8999/";

    /**
     * 请求接口的参数“auth”中相关字段
     */
    interface Auth {
        int SOURCE = 5;      //auth中的source字段，平台：iOS-4，android-5
        int VENDOR = 100000;    //auth中的vendor字段，来源
    }

}
