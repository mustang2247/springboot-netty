package com.mustang.netty.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Created by wangqiyun on 2017/12/8.
 */
@Component
public class ApplicationContextTool implements ApplicationContextAware {

    private static volatile ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ApplicationContextTool.applicationContext = applicationContext;
    }

    public static <T> T getBean(Class<T> c) {
        return applicationContext.getBean(c);
    }

    // 获取当前环境
    public static String getActiveProfile() {
        //return applicationContext.getEnvironment().getDefaultProfiles()[0];
        return applicationContext.getEnvironment().getActiveProfiles()[0];
    }

    // 获取参数
    public static String getProperty(String var1) {
        return applicationContext.getEnvironment().getProperty(var1);
    }

}
