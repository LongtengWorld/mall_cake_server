package com.junbaobao.mall.util.txyun.impl;

import com.junbaobao.mall.util.txyun.entity.TxYunUploadUtils;
import com.junbaobao.mall.util.txyun.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Service
public class FileUploadServiceImpl implements FileUploadService {

    @Autowired
    private TxYunUploadUtils txYunUploadUtils;




    @Override
    public String uploadFilePublic(MultipartFile multipartFile,String bucketName,String baseUrl) {
        return txYunUploadUtils.publicUpload(multipartFile,bucketName,baseUrl);
    }

    @Override
    public String uploadFilePrivate(MultipartFile multipartFile,String bucketName,String baseUrl) {
        return txYunUploadUtils.privateUpload(multipartFile,bucketName,baseUrl);
    }

    @Override
    public String uploadFilePrivate(MultipartFile multipartFile, String bucketName, String baseUrl, String privacyType,String fileName) {
        return txYunUploadUtils.privateUpload(multipartFile,bucketName,baseUrl,privacyType,fileName);
    }

    @Override
    public String uploadFile(File file) {
        return txYunUploadUtils.upload(file);
    }

    @Override
    public String uploadFileByUrl(String url, String bucketName, String fileName) {
        return txYunUploadUtils.uploadFileByUrl(url,bucketName,fileName);
    }

}
