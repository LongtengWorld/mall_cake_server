package com.junbaobao.mall.store.file.entity.Do;

import cn.hutool.core.annotation.Alias;
import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author junbaobao
 * @date 2022-12-04 16:20:04
 * @description 文件库记录表(CakeUploadFile实体类)
 */
@Data
@TableName("cake_upload_file")
@ApiModel(value = "文件库记录表", description = "文件库记录表对象 cakeUploadFile")
public class CakeUploadFileDo {
    /**
     * 文件ID
     */
    @ApiModelProperty(value = "文件ID")
    @TableId(value = "file_Id", type = IdType.AUTO)
    private Integer fileId;
    /**
     * 文件分组ID
     */
    @ApiModelProperty(value = "文件分组ID")
    private Integer groupId;
    /**
     * 上传来源(10商户后台 20用户端)
     */
    @ApiModelProperty(value = "上传来源(10商户后台 20用户端)")
    private Integer channel;
    /**
     * 存储方式
     */
    @ApiModelProperty(value = "存储方式")
    private String storage;
    /**
     * 存储域名
     */
    @ApiModelProperty(value = "存储域名")
    private String domain;
    /**
     * 文件类型(10图片 20附件 30视频)
     */
    @ApiModelProperty(value = "文件类型(10图片 20附件 30视频)")
    private Integer fileType;
    /**
     * 文件名称(仅显示)
     */
    @ApiModelProperty(value = "文件名称(仅显示)")
    private String fileName;
    /**
     * 文件路径
     */
    @ApiModelProperty(value = "文件路径")
    private String filePath;
    /**
     * 文件大小(字节)
     */
    @ApiModelProperty(value = "文件大小(字节)")
    private Integer fileSize;
    /**
     * 文件扩展名
     */
    @ApiModelProperty(value = "文件扩展名")
    private String fileExt;
    /**
     * 文件封面
     */
    @ApiModelProperty(value = "文件封面")
    private String cover;
    /**
     * 上传者用户ID
     */
    @ApiModelProperty(value = "上传者用户ID")
    private Integer uploaderId;
    /**
     * 是否在回收站
     */
    @ApiModelProperty(value = "是否在回收站")
    private Integer isRecycle;
    /**
     * 是否删除
     */
    @TableLogic(value ="1",delval = "0")
    @ApiModelProperty(value = "是否删除")
    private Integer isDelete;
    /**
     * 商城ID
     */
    @ApiModelProperty(value = "商城ID")
    private Integer storeId;


    /**
     * 访问地址
     */
    @TableField(exist = false)
    private String externalUrl;

    /**
     * 封面地址
     */
    @TableField(exist = false)
    private String previewUrl;
}
