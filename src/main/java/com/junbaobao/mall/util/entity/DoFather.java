package com.junbaobao.mall.util.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @Classname DoFather
 * @Description 当前类为DO层的父类
 * @Date: Created in 2022/6/18 15:22
 * @Author Name:  junbaobao
 * @Version: 1.0
 */
@Data
public class DoFather {

	/**
	 * 主键ID
	 */
	@TableId(value="id",type= IdType.AUTO)
	private Integer id;

	/**
	 * 1正在使用，-1删除
	 */
	@TableLogic(value ="1",delval = "-1")
	private Integer isDelete;
	/**
	 * 创建时间
	 */
	@ApiModelProperty(value = "创建时间")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	@TableField(fill = FieldFill.INSERT)
	private String createTime;
	/**
	 * 创建者id
	 */
	private Integer createUserId;
	/**
	 * 修改时间
	 */
	@ApiModelProperty(value = "修改时间")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String updateTime;
	/**
	 * 修改者id
	 */
	private Integer updateUserId;


}
