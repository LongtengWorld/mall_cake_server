package com.junbaobao.mall.util.wxconfig;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.api.impl.WxMaServiceImpl;
import cn.binarywang.wx.miniapp.config.impl.WxMaDefaultConfigImpl;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Classname WxMaConfiguration
 * @Description
 * @Date: Created in 2022/7/8 22:37
 * @Author Name:  junbaobao
 * @Version: 1.0
 */
@Configuration
@EnableConfigurationProperties(WxMaProperties.class)
public class WxMaConfiguration {

	/**
	 * 配置wx信息
	 * @param wxMaProperties
	 * @return
	 */
	@Bean
	public WxMaService wxMaService(WxMaProperties wxMaProperties) {
		WxMaDefaultConfigImpl config = new WxMaDefaultConfigImpl();
		config.setAppid(wxMaProperties.getAppid());
		config.setSecret(wxMaProperties.getSecret());
		config.setMsgDataFormat(wxMaProperties.getMsgDataFormat());
		WxMaService wxMaService = new WxMaServiceImpl();
		wxMaService.setWxMaConfig(config);
		return wxMaService;
	}
}
