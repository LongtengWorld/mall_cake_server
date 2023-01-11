package com.junbaobao.mall.store.file.controller;

import cn.hutool.core.util.ObjectUtil;
import com.junbaobao.mall.store.file.entity.Do.CakeUploadFileDo;
import com.junbaobao.mall.store.file.service.CakeFileService;
import com.junbaobao.mall.util.DateUtil;
import com.junbaobao.mall.util.Result;
import com.junbaobao.mall.util.ResultCode;
import com.junbaobao.mall.util.StoreJsonResult;
import com.junbaobao.mall.util.txyun.service.FileUploadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @Classname UpoloadController
 * @Description
 * @Date: Created in 2022/12/26 20:51
 * @Author Name:  junbaobao
 * @Version: 1.0
 */
@RestController
@RequestMapping("/store/upload/")
@Slf4j
public class UploadFileController {

    @Resource
    private FileUploadService fileUploadService;

    @Value("${myapplication.storage.txyun.bucket}")
    private String BlogBucketName;

    @Value("${myapplication.storage.txyun.baseUrl}")
    private String baseUrl;

    @Resource
    private CakeFileService cakeFileService;

    @PostMapping("/image")
    @Transactional
    public StoreJsonResult<Map<String, Object>> uploadImage(int groupId, @RequestParam("iFile") MultipartFile iFile) {
        int storeId = 10001;

        String allowFileType = ".pjp,.jpg,.jpeg,.png";
        if (ObjectUtil.isEmpty(iFile) || ObjectUtil.isEmpty(iFile.getOriginalFilename())) {
            throw new RuntimeException("请添加上传文件！");
        }
        String suffix = iFile.getOriginalFilename().substring(iFile.getOriginalFilename().lastIndexOf("."));

        if (!checkFile(suffix, allowFileType.split(","))) {
            log.info("文件类型不合法{},{}", suffix, allowFileType);
            return Result.storeFailedAndMsg(500, "图片上传失败：图片文件扩展名有误");
        }
        //文件上传时文件
        String originalFilename = iFile.getOriginalFilename();
        //文件大小
        long size = iFile.getSize();
        //文件扩展名
        String ext = iFile.getOriginalFilename().substring(iFile.getOriginalFilename().lastIndexOf("."));
        String filePath = storeId + "/" + DateUtil.getDate() + "/" + UUID.randomUUID() + ext;
        fileUploadService.uploadFilePrivate(iFile, BlogBucketName, baseUrl, "public", filePath);

        CakeUploadFileDo cakeUploadFileDo = new CakeUploadFileDo();
        cakeUploadFileDo.setGroupId(groupId);
        cakeUploadFileDo.setChannel(10);
        cakeUploadFileDo.setStorage("qcloud");
        cakeUploadFileDo.setDomain(baseUrl);
        cakeUploadFileDo.setFileType(10);
        cakeUploadFileDo.setFileName(originalFilename);
        cakeUploadFileDo.setFilePath(filePath);
        cakeUploadFileDo.setFileSize((int) size);
        cakeUploadFileDo.setFileExt(ext);

//        cakeUploadFileDo.setCover("");
//        cakeUploadFileDo.setUploaderId(0);

        cakeUploadFileDo.setIsRecycle(1);
        cakeUploadFileDo.setStoreId(storeId);
        cakeFileService.addFileDo(cakeUploadFileDo);


        return Result.storeSuccess(null, ResultCode.STORE_UPLOAD_IMAGE);
    }


    @PostMapping("/video")
    public StoreJsonResult<Map<String, Object>> video(int groupId, @RequestParam("iFile") MultipartFile iFile) {
        int storeId = 10001;
        String allowFileType = ".mp4";
        if (ObjectUtil.isEmpty(iFile) || ObjectUtil.isEmpty(iFile.getOriginalFilename())) {
            throw new RuntimeException("请添加上传文件！");
        }
        String suffix = iFile.getOriginalFilename().substring(iFile.getOriginalFilename().lastIndexOf("."));

        if (!checkFile(suffix, allowFileType.split(","))) {
            log.info("文件类型不合法{},{}", suffix, allowFileType);
            return Result.storeFailedAndMsg(500, "视频上传失败：视频文件扩展名有误");
        }

        //文件上传时文件
        String originalFilename = iFile.getOriginalFilename();
        //文件大小
        long size = iFile.getSize();
        //文件扩展名
        String ext = iFile.getOriginalFilename().substring(iFile.getOriginalFilename().lastIndexOf("."));
        String filePath = storeId + "/" + DateUtil.getDate() + "/" + UUID.randomUUID() + ext;
        fileUploadService.uploadFilePrivate(iFile, BlogBucketName, baseUrl, "public", filePath);

        CakeUploadFileDo cakeUploadFileDo = new CakeUploadFileDo();
        cakeUploadFileDo.setGroupId(groupId);
        cakeUploadFileDo.setChannel(10);
        cakeUploadFileDo.setStorage("qcloud");
        cakeUploadFileDo.setDomain(baseUrl);
        cakeUploadFileDo.setFileType(30);
        cakeUploadFileDo.setFileName(originalFilename);
        cakeUploadFileDo.setFilePath(filePath);
        cakeUploadFileDo.setFileSize((int) size);
        cakeUploadFileDo.setFileExt(ext);

        cakeUploadFileDo.setIsRecycle(1);
        cakeUploadFileDo.setStoreId(storeId);
        cakeFileService.addFileDo(cakeUploadFileDo);


        return Result.storeSuccess(null, ResultCode.STORE_UPLOAD_IMAGE);
    }


    /**
     * 判断是否为允许的上传文件类型,true表示允许
     *
     * @author King Xu
     * @date 2019/10/17
     */
    public static boolean checkFile(String suffix, String[] suffixLists) {
        if (Arrays.asList(suffixLists).contains(suffix.trim().toLowerCase())) {
            return true;
        }
        return false;
    }
}
