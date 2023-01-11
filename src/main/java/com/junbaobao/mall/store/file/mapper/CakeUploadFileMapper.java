package com.junbaobao.mall.store.file.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.junbaobao.mall.store.file.entity.Do.CakeUploadFileDo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Classname CakeUploadFileMapper
 * @Description
 * @Date: Created in 2022/12/7 23:05
 * @Author Name:  junbaobao
 * @Version: 1.0
 */
@Mapper
public interface CakeUploadFileMapper extends BaseMapper<CakeUploadFileDo> {


    IPage<CakeUploadFileDo> getFileList(Page page, @Param("fileType") int fileType, @Param("channel") int channel,
                                        @Param("fileName") String fileName, @Param("groupId") int groupId);




    CakeUploadFileDo  getByFileId(@Param("fileId") int fileId);



    List<CakeUploadFileDo> getByGoodsId(@Param("goods_id")int goodsId);

}
