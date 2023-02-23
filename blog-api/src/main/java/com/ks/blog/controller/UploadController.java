package com.ks.blog.controller;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.ks.blog.utils.ConstantPropertiesUtils;
import com.ks.blog.vo.params.Result.Result;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.UUID;

@RestController
@RequestMapping("/upload")
public class UploadController {



    @PostMapping
    public Result upload(@RequestParam("image")MultipartFile file){
        String endpoint = ConstantPropertiesUtils.END_POINT;
        String accessKeyId = ConstantPropertiesUtils.KEY_ID;
        String accessKeySecret = ConstantPropertiesUtils.KEY_SCRET;
        String bucketName = ConstantPropertiesUtils.BUCKET_NAME;
        // 原始文件名称
//        String originalFilename = file.getOriginalFilename();
//        // 在.之后的所有字符
//        // 唯一的文件名称
//        String fileName = UUID.randomUUID().toString() + "." + StringUtils.substringAfterLast(originalFilename,".");
        try {
            OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
            //获得输入流
            InputStream inputStream = file.getInputStream();
            //文件原始名称
            String filename = file.getOriginalFilename();

            //在文件名称里面添加随机唯一的值
            String uuid = UUID.randomUUID().toString().replaceAll("-","");
            filename = uuid + filename;
            //按照日期分类
            String datePath = new DateTime().toString("yyyy/MM/dd");
            filename = datePath+ "/" + filename;
            //1 bucket名称
            //2 文件名称
            //3 流
            ossClient.putObject(bucketName,filename,inputStream);
            ossClient.shutdown();
            //把上传之后文件的路径进行返回
            //上传阿里云路径拼接
            String url = "https://"+bucketName+"."+endpoint+"/"+filename;
            return Result.success(url);

        }catch (Exception e){
            e.printStackTrace();
            return Result.fail(20001,"上传失败");
        }
    }

}
