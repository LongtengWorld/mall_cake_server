package com.junbaobao.mall.store.file.controller;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.junbaobao.mall.store.file.entity.Do.CakeUploadFileDo;
import com.junbaobao.mall.store.file.entity.Vo.FileInfoVo;
import com.junbaobao.mall.store.file.entity.Vo.FileListVo;
import com.junbaobao.mall.store.file.service.CakeFileService;
import com.junbaobao.mall.util.Result;
import com.junbaobao.mall.util.ResultCode;
import com.junbaobao.mall.util.StoreJsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @Classname StoreFilesController
 * @Description
 * @Date: Created in 2022/10/22 15:21
 * @Author Name:  junbaobao
 * @Version: 1.0
 */
@RestController
@RequestMapping("/store/files")
@Slf4j
public class FilesController {

    @Resource
    private CakeFileService cakeFileService;

    @GetMapping("/list")
    public StoreJsonResult<Map<String, Object>> storeFileList(int fileType, int channel, int page, String fileName, int groupId) {
        log.info("fileName{}", fileName);
        Map<String, Object> map = new HashMap<>();

        FileListVo storeFileListVo = new FileListVo();
        IPage<CakeUploadFileDo>  fileList = cakeFileService.getFileList(fileType, channel, page, fileName, groupId);
        List<CakeUploadFileDo> CakeUploadFileList = fileList.getRecords();
        List<FileInfoVo> storeImagesInfoVoList = BeanUtil.copyToList(CakeUploadFileList, FileInfoVo.class);




        storeFileListVo.setData(storeImagesInfoVoList);
        storeFileListVo.setTotal((int) fileList.getTotal());
        storeFileListVo.setCurrent_page((int) fileList.getCurrent());
        storeFileListVo.setLast_page(1);
        storeFileListVo.setPer_page(15);
        map.put("list", storeFileListVo);

        return Result.storeSuccess(map, ResultCode.STORE_ACCESS);
    }


}
