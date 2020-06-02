package com.woqiyounai.luntan.components;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClient;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class UploadFile {

    //加入阿里云
    @Bean
    public OSS getOssClient(){
        String endpoint = "https://oss-cn-beijing.aliyuncs.com/";
        // 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
        String accessKeyId = "LTAI4G34ektf5bBdWauJC8ou";
        String accessKeySecret = "G4n35gPI1iEbU2j8jT5gDkh5v6ohdA";
        // 创建OSSClient实例。
        OSS ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        System.out.println("--- 创建成功 ---");
        return ossClient;
    }
}
