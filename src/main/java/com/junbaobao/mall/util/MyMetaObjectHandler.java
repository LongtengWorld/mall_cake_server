package com.junbaobao.mall.util;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.context.annotation.Configuration;

import java.util.Objects;

/**
 * @Classname MyMetaObjectHandler
 * @Description
 * @Date: Created in 2022/7/10 0:03
 * @Author Name:  junbaobao
 * @Version: 1.0
 */
@Slf4j
@Configuration
public class MyMetaObjectHandler implements MetaObjectHandler {
	@Override
	public void insertFill(MetaObject metaObject) {
		// 保存对象时候，获取createTime属性值；如果属性值为NULL，才进行填充
		//调用的这个方法会判断是否有这个参数，如果有就返回参数的值，都没有就返回null
		Object createTime = this.getFieldValByName("createTime", metaObject);
		if (Objects.isNull(createTime)) {
			// 填充
			this.setFieldValByName("createTime","2022-12-01 11:51:48",metaObject);
		}
	}

	@Override
	public void updateFill(MetaObject metaObject) {

		Object createTime = this.getFieldValByName("updateTime", metaObject);
		if (Objects.isNull(createTime)) {
			// 填充
			this.setFieldValByName("updateTime","2022-12-01 11:51:48",metaObject);
		}
	}



}
