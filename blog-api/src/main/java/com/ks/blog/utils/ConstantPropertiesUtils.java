package com.ks.blog.utils;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//当项目启动 spring接口 spring加载之后 执行接口中的一个方法
@Component
public class ConstantPropertiesUtils implements InitializingBean {

    //读取配置文件

    @Value("${aliyun.oss.file.endpoint}")
    private String endpoint;

    @Value("${aliyun.oss.file.keyid}")
    private String keyId;

    @Value("${aliyun.oss.file.keysecret}")
    private String keyScret;

    @Value("${aliyun.oss.file.bucketname}")
    private String bucketName;

    //定义类
    public static String END_POINT;
    public static String KEY_ID;
    public static String KEY_SCRET;
    public static String BUCKET_NAME;
    @Override
    public void afterPropertiesSet() throws Exception {
        END_POINT = endpoint;
        KEY_ID = keyId;
        KEY_SCRET = keyScret;
        BUCKET_NAME = bucketName;
    }
}
