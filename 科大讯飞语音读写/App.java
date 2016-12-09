package com.bw.hhzmy.lication;

import android.app.Application;

import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechUtility;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;

import cn.jpush.android.api.JPushInterface;

/**
 * autour: 徐仕奇
 * action：类的作用:第三方登陆，配置三方平台的appkey
 * date: 2016/12/8 0008 下午 12:58
 * update: 2016/12/8 0008
 */
public class App extends Application {
    //在application文件中配置三方平台的appkey：
    {
        PlatformConfig.setWeixin("wx967daebe835fbeac", "5bb696d9ccd75a38c8a0bfe0675559b3");
        PlatformConfig.setSinaWeibo("3921700954", "04b48b094faeb16683c32669824ebdad");
        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");
    }
    //在application中初始化sdk，这个初始化最好放在application的程序入口中，防止意外发生：
    @Override
    public void onCreate() {
        //科大讯飞语音
        SpeechUtility.createUtility(getApplicationContext(), SpeechConstant.APPID+"=584a9aaa ");
        super.onCreate();
        //第三方登陆
        UMShareAPI.get(this);
        //极光推送
        JPushInterface.setDebugMode(true);
        JPushInterface.init(this);

    }

}
