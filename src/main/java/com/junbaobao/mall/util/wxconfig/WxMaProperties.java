package com.junbaobao.mall.util.wxconfig;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Classname WxMaProperties
 * @Description
 * @Date: Created in 2022/7/8 22:33
 * @Author Name:  junbaobao
 * @Version: 1.0
 */
@ConfigurationProperties(prefix = "wx.miniapp")
@Data
public class WxMaProperties {

	/**
	 * 小程序appid
	 */
	private String appid;
	/**
	 * 小程序secret
	 */
	private String secret;
	/**
	 * 小程序返回消息格式
	 */
	private String msgDataFormat;

}
