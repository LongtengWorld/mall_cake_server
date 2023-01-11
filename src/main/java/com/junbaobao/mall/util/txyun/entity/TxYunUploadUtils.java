package com.junbaobao.mall.util.txyun.entity;

import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpUtil;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.exception.CosClientException;
import com.qcloud.cos.exception.CosServiceException;
import com.qcloud.cos.model.*;
import com.qcloud.cos.region.Region;
import lombok.Data;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @description: 腾讯对象存储服务
 * @author: Zhiwei Wang
 * @create: 2020/12/30
 */
@Data
@Component
@ConfigurationProperties(prefix = "txyun")
public class TxYunUploadUtils implements InitializingBean {

    /**
     * 腾讯云的SecretId
     */

    private String secretId;

    /**
     * 腾讯云的SecretKey
     */
    private String secretKey;

    /**
     * 腾讯云的bucket (存储桶)
     */
    private String bucket;

    /**
     * 腾讯云的region(bucket所在地区)
     */
    private String region;

    /**
     * 腾讯云的allowPrefix(允许上传的路径)
     */
    private String allowPrefix;

    /**
     * 腾讯云的临时密钥时长(单位秒)
     */
    private String durationSeconds;

    /**
     * 腾讯云的访问基础链接
     */
    private String baseUrl;

    @Override
    public void afterPropertiesSet() {
        System.out.println("=================" + secretId);
    }


    /**
     * 上传File类型的文件
     *
     * @param file
     * @return 上传文件在存储桶的链接
     */
    public String upload(File file) {
        //生成唯一文件名
        String newFileName = generateUniqueName(file.getName());
        //文件在存储桶中的key
        String key = newFileName;
        //声明客户端
        COSClient cosClient = getCosClient();
        try {
            //创建存储对象的请求
            PutObjectRequest putObjectRequest = new PutObjectRequest(bucket, key, file);
            //执行上传并返回结果信息
            cosClient.putObject(putObjectRequest);
//            Date expiration = new Date(new Date().getTime() + 5 * 60 * 10000);
//            URL url = cosClient.generatePresignedUrl(bucket, key, expiration);
            return baseUrl + "\\" + newFileName;
        } catch (CosClientException e) {
            e.printStackTrace();
        } finally {
            cosClient.shutdown();
        }
        return null;
    }

    /**
     * upload()重载方法
     *
     * @param multipartFile
     * @return 上传文件在存储桶的链接
     */
    public String publicUpload(MultipartFile multipartFile, String bucketName, String userBaseUrl) {
        //生成唯一文件名
        //String newFileName = generateUniqueName(multipartFile.getOriginalFilename());
        //文件在存储桶中的key
        String key = UUID.randomUUID() + ".jpg";
        //声明客户端
        COSClient cosClient = getCosClient();
        //准备将MultipartFile类型转为File类型
        File file = null;
        try {
            //生成临时文件
            file = File.createTempFile("temp", null);
            //将MultipartFile类型转为File类型
            multipartFile.transferTo(file);
            //创建存储对象的请求
            PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, file);
            PutObjectResult putObjectResult = cosClient.putObject(putObjectRequest);
//            Date expiration = new Date(new Date().getTime() + 5 * 10 * 10000);
//
//            URL url = cosClient.generatePresignedUrl(bucket, key, expiration);
            return userBaseUrl + key;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            cosClient.shutdown();
        }
        return null;
    }

    /**
     * upload()重载方法
     *
     * @param multipartFile
     * @return 上传文件在存储桶的链接
     */
    public String privateUpload(MultipartFile multipartFile, String bucketName, String userBaseUrl) {
        //生成唯一文件名
        //String newFileName = generateUniqueName(multipartFile.getOriginalFilename());
        //文件在存储桶中的key
        String key = UUID.randomUUID() + ".jpg";
        //声明客户端
        COSClient cosClient = getCosClient();
        //准备将MultipartFile类型转为File类型
        File file = null;
        try {
            //生成临时文件
            file = File.createTempFile("temp", null);
            //将MultipartFile类型转为File类型
            multipartFile.transferTo(file);
            //创建存储对象的请求
            PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, file);
            PutObjectResult putObjectResult = cosClient.putObject(putObjectRequest);
            Date expiration = new Date(new Date().getTime() + 10 * 10 * 10000);

            URL url = cosClient.generatePresignedUrl(bucketName, key, expiration);
            return url.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            cosClient.shutdown();
        }
        return null;
    }

    /**
     * upload()重载方法
     *
     * @param multipartFile
     * @return 上传文件在存储桶的链接
     */
    public String privateUpload(MultipartFile multipartFile, String bucketName, String userBaseUrl, String privacyType, String fileName) {
        //生成唯一文件名
        //文件在存储桶中的key
        //String key = UUID.randomUUID() +ext;
        //声明客户端
        COSClient cosClient = getCosClient();
        //准备将MultipartFile类型转为File类型
        File file = null;
        try {
            //生成临时文件
            file = File.createTempFile("temp", null);
            //将MultipartFile类型转为File类型
            multipartFile.transferTo(file);
            //创建存储对象的请求
            PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, fileName, file);
            PutObjectResult putObjectResult = cosClient.putObject(putObjectRequest);
            Date expiration = new Date(new Date().getTime() + 10 * 10 * 10000);


            if (StrUtil.equals(privacyType, "public")) {
                return userBaseUrl + fileName;
            } else if (StrUtil.equals(privacyType, "private")) {
                return cosClient.generatePresignedUrl(bucketName, fileName, expiration).toString();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            cosClient.shutdown();
        }
        return null;
    }

    public String   uploadFileByUrl(String url, String bucketName, String fileName) {

        try {
            //声明客户端
            COSClient cosClient = getCosClient();
            CloseableHttpClient httpClient = HttpClientBuilder.create().build();
            HttpGet request = new HttpGet(url);
            HttpResponse response = httpClient.execute(request);
            if (response.getStatusLine().getStatusCode() == 200) {
                System.out.println("response:: " + response.getEntity());
                InputStream inputStream = response.getEntity().getContent();
                File file = asFile(inputStream);
                PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, fileName, file);
                PutObjectResult putObjectResult = cosClient.putObject(putObjectRequest);
                return "";
            }
        } catch (Exception e) {

        }
        return null;
    }

    public static File asFile(InputStream inputStream) throws IOException {
        File tmp = File.createTempFile("temp", null);
        OutputStream os = new FileOutputStream(tmp);
        int bytesRead = 0;
        byte[] buffer = new byte[8192];
        while ((bytesRead = inputStream.read(buffer, 0, 8192)) != -1) {
            os.write(buffer, 0, bytesRead);
        }
        inputStream.close();
        return tmp;
    }


    public String getUrl(String privacyType, String bucketName, String key, Date expiration, String userBaseUrl, COSClient cosClient) {
        if (StrUtil.equals(privacyType, "public")) {
            return userBaseUrl + key;
        } else if (StrUtil.equals(privacyType, "private")) {
            return cosClient.generatePresignedUrl(bucketName, key, expiration).toString();
        }


        return "";
    }

    /**
     * 根据UUID生成唯一文件名
     *
     * @param originalName
     * @return
     */
    public String generateUniqueName(String originalName) {
        return UUID.randomUUID() + originalName.substring(originalName.lastIndexOf("."));
    }


    /**
     * 初始化CosClient相关配置， appid、accessKey、secretKey、region
     *
     * @return
     */
    public COSClient getCosClient() {
        // 1 初始化用户身份信息（secretId, secretKey）。
        COSCredentials cred = new BasicCOSCredentials(secretId, secretKey);
        // 2 设置 bucket 的区域, COS 地域的简称请参照 https://cloud.tencent.com/document/product/436/6224
        // clientConfig 中包含了设置 region, https(默认 http), 超时, 代理等 set 方法, 使用可参见源码或者常见问题 Java SDK 部分。
        Region regiona = new Region(region);
        ClientConfig clientConfig = new ClientConfig(regiona);
        // 3 生成 cos 客户端。
        COSClient cosClient = new COSClient(cred, clientConfig);
        return cosClient;
    }

    /**
     * 上传文件
     *
     * @return
     */
    public String uploadFile(String fullFileName, File file) {
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucket, fullFileName, file);

        // 设置存储类型, 默认是标准(Standard), 低频(standard_ia)
        putObjectRequest.setStorageClass(StorageClass.Standard_IA);
        COSClient cc = getCosClient();
        String etag = "";
        String resutl;
        try {
            PutObjectResult putObjectResult = cc.putObject(putObjectRequest);
            // putobjectResult会返回文件的etag
            etag = putObjectResult.getETag();
            resutl = baseUrl + fullFileName;
        } catch (CosServiceException e) {
            e.printStackTrace();

            resutl = e.getMessage();
        } catch (CosClientException e) {
            e.printStackTrace();
            resutl = e.getMessage();
        } finally {
            // 关闭客户端
            cc.shutdown();
        }
        return resutl;
    }

    /**
     * 下载文件
     *
     * @param bucketName
     * @param path
     * @return
     */
    public String downLoadFile(String bucketName, String path, String fullFileName) {
        File downFile = new File(fullFileName);
        COSClient cc = getCosClient();
        GetObjectRequest getObjectRequest = new GetObjectRequest(bucketName, path);

        ObjectMetadata downObjectMeta = cc.getObject(getObjectRequest, downFile);
        cc.shutdown();
        String etag = downObjectMeta.getETag();
        return etag;
    }

    /**
     * 删除文件
     *
     * @param bucketName
     * @param path
     */
    public void deleteFile(String bucketName, String path) {
        COSClient cc = getCosClient();
        try {
            cc.deleteObject(bucketName, path);
        } catch (CosClientException e) {
            e.printStackTrace();
        } finally {
            cc.shutdown();
        }

    }

    /**
     * 创建桶
     *
     * @param bucketName
     * @return
     * @throws CosClientException
     * @throws CosServiceException
     */
    public Bucket createBucket(String bucketName) throws CosClientException, CosServiceException {
        COSClient cc = getCosClient();
        Bucket bucket = null;
        try {
            bucket = cc.createBucket(bucketName);
        } catch (CosClientException e) {
            e.printStackTrace();
        } finally {
        }
        return bucket;
    }

    ;

    /**
     * 删除桶
     *
     * @param bucketName
     * @throws CosClientException
     * @throws CosServiceException
     */
    public void deleteBucket(String bucketName) throws CosClientException, CosServiceException {
        COSClient cc = getCosClient();
        try {
            cc.deleteBucket(bucketName);
        } catch (CosClientException e) {
            e.printStackTrace();
        } finally {
        }
    }

    ;

    /**
     * 判断桶是否存在
     *
     * @param bucketName
     * @return
     * @throws CosClientException
     * @throws CosServiceException
     */
    public boolean doesBucketExist(String bucketName) throws CosClientException, CosServiceException {
        COSClient cc = getCosClient();
        boolean bucketExistFlag = cc.doesBucketExist(bucketName);
        return bucketExistFlag;
    }

    ;

    /**
     * 查看桶文件
     *
     * @param bucketName
     * @return
     * @throws CosClientException
     * @throws CosServiceException
     */
    public ObjectListing listObjects(String bucketName) throws CosClientException, CosServiceException {
        COSClient cc = getCosClient();

        // 获取 bucket 下成员（设置 delimiter）
        ListObjectsRequest listObjectsRequest = new ListObjectsRequest();
        listObjectsRequest.setBucketName(bucketName);
        // 设置 list 的 prefix, 表示 list 出来的文件 key 都是以这个 prefix 开始
        listObjectsRequest.setPrefix("");
        // 设置 delimiter 为/, 即获取的是直接成员，不包含目录下的递归子成员
        listObjectsRequest.setDelimiter("/");
        // 设置 marker, (marker 由上一次 list 获取到, 或者第一次 list marker 为空)
        listObjectsRequest.setMarker("");
        // 设置最多 list 100 个成员,（如果不设置, 默认为 1000 个，最大允许一次 list 1000 个 key）
        listObjectsRequest.setMaxKeys(100);

        ObjectListing objectListing = cc.listObjects(listObjectsRequest);
        // 获取下次 list 的 marker
        String nextMarker = objectListing.getNextMarker();
        // 判断是否已经 list 完, 如果 list 结束, 则 isTruncated 为 false, 否则为 true
        boolean isTruncated = objectListing.isTruncated();
        List<COSObjectSummary> objectSummaries = objectListing.getObjectSummaries();
        for (COSObjectSummary cosObjectSummary : objectSummaries) {
            // get file path
            String key = cosObjectSummary.getKey();
            // get file length
            long fileSize = cosObjectSummary.getSize();
            // get file etag
            String eTag = cosObjectSummary.getETag();
            // get last modify time
            Date lastModified = cosObjectSummary.getLastModified();
            // get file save type
            String StorageClassStr = cosObjectSummary.getStorageClass();
        }
        return objectListing;
    }

    public void main(String[] args) {
        //uploadFile();
        //downLoadFile();
        //deleteFile();
        //createBucket();
        //deleteBucket();
        //doesBucketExist();
        //listObjects();
    }

}
