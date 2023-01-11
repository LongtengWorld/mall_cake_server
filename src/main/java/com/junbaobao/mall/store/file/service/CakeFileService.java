package com.junbaobao.mall.store.file.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.junbaobao.mall.store.file.entity.Do.CakeUploadFileDo;

/**
 * @Classname CakeUploadFileService
 * @Description
 * @Date: Created in 2022/12/7 23:04
 * @Author Name:  junbaobao
 * @Version: 1.0
 */
public interface CakeFileService {


    /**
     * 根据主键查询数据
     * @param fileId
     * @return
     */
    CakeUploadFileDo getByFileIdUploadFileDo(int fileId);


    /**
     * 根据条件获取fileList
     * @param fileType
     * @param channel
     * @param page
     * @param fileName
     * @param groupId
     * @return
     */
    IPage<CakeUploadFileDo> getFileList(int fileType, int channel , int page, String fileName, int groupId);


    /**
     * 新增文件信息
     * @param cakeUploadFileDo
     * @return
     */
    int addFileDo(CakeUploadFileDo cakeUploadFileDo );
}
