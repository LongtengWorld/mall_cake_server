package com.junbaobao.mall.store.file.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.junbaobao.mall.store.file.entity.Do.CakeUploadFileDo;
import com.junbaobao.mall.store.file.mapper.CakeUploadFileMapper;
import com.junbaobao.mall.store.file.service.CakeFileService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Classname CakeUploadFileServiceImpl
 * @Description
 * @Date: Created in 2022/12/7 23:04
 * @Author Name:  junbaobao
 * @Version: 1.0
 */
@Service
public class CakeFileServiceImpl extends ServiceImpl<CakeUploadFileMapper, CakeUploadFileDo> implements CakeFileService {

    @Resource
    private CakeUploadFileMapper cakeUploadFileMapper;

    @Override
    public CakeUploadFileDo getByFileIdUploadFileDo(int fileId) {

        return cakeUploadFileMapper.getByFileId(fileId);
    }

    @Override
    public IPage<CakeUploadFileDo> getFileList(int fileType, int channel, int page, String fileName, int groupId) {
        Page<CakeUploadFileDo> cakeUploadFileDoPage = new Page<>(page, 10);

        return cakeUploadFileMapper.getFileList(cakeUploadFileDoPage,fileType, channel, fileName, groupId);
    }

    @Override
    public int addFileDo(CakeUploadFileDo cakeUploadFileDo) {

        return cakeUploadFileMapper.insert(cakeUploadFileDo);
    }
}
