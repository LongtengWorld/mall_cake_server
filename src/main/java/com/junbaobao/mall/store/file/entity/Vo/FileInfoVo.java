package com.junbaobao.mall.store.file.entity.Vo;

import cn.hutool.core.annotation.Alias;
import lombok.Data;

/**
 * @Classname StoreGoodsInfoVo
 * @Description
 * @Date: Created in 2022/9/24 10:54
 * @Author Name:  junbaobao
 * @Version: 1.0
 */
@Data
public class FileInfoVo {

    private int channel;

    private String cover;

    private String create_time;

    private String domain;

    @Alias("externalUrl")
    private String external_url;

    @Alias("fileExt")
    private String file_ext;

    @Alias("fileId")
    private int file_id;


    @Alias("fileName")
    private String file_name;

    @Alias("filePath")
    private String file_path;

    @Alias("fileSize")
    private int file_size;

    @Alias("fileType")
    private int file_type;

    private int group_id;

    private int is_delete;

    private int is_recycle;

    @Alias("previewUrl")
    private String preview_url;

    private String storage;

    @Alias("storeId")
    private int store_id;

    private String update_time;

    private int uploader_id;


}
