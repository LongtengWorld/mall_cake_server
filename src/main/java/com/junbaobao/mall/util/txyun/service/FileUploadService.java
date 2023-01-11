package com.junbaobao.mall.util.txyun.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * @author Farewell is well
 * @date 2019-11-20 16:17
 */
public interface FileUploadService {
    /**
     * 处理浏览器文件上传请求
     * @param multipartFile
     * @return
     */
    String uploadFilePublic(MultipartFile multipartFile,String bucketName,String baseUrl);


    /**
     * 处理浏览器文件上传请求
     * @param multipartFile
     * @return
     */
    String uploadFilePrivate(MultipartFile multipartFile,String bucketName,String baseUrl);

    /**
     * 处理浏览器文件上传请求
     * @param multipartFile
     * @return
     */
    String uploadFilePrivate(MultipartFile multipartFile,String bucketName,String baseUrl, String privacyType,String fileName);


    /**
     * 处理普通文件上传
     * @param file
     * @return
     */
    String uploadFile(File file);


    /**
     * 根据url上传
     * @param url
     * @return
     */
    String uploadFileByUrl(String url, String bucketName, String fileName);
}
