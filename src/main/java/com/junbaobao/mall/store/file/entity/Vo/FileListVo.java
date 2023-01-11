package com.junbaobao.mall.store.file.entity.Vo;

import lombok.Data;

import java.util.List;

/**
 * @Classname StoreFileListVo
 * @Description
 * @Date: Created in 2022/10/22 15:29
 * @Author Name:  junbaobao
 * @Version: 1.0
 */
@Data
public class FileListVo {

    private int current_page;

    private List<FileInfoVo> data;


    private int last_page;


    private int per_page;


    private int total;

}
