package com.woqiyounai.luntan.config;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UploadFile {

    //AccessKey ID：
    //LTAI4GC3znL5YpJCTGnfYrz9
    //AccessKey Secret：
    //kBQHLmYwe60pz1Ovj77JycFMz1yulz
    //加入阿里云
    @Bean
    public OSS getOssClient(){
        String endpoint = "https://oss-cn-beijing.aliyuncs.com/";
        String accessKeyId = "";
        String accessKeySecret = "";
        OSS ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        System.out.println("--- 创建成功 ---");
        return ossClient;
    }
}
