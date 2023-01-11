package com.junbaobao.mall.store.entity.Vo.defaultDataVo;

import lombok.Data;

/**
 * @Classname PageStyleVo
 * @Description
 * @Date: Created in 2022/9/18 15:06
 * @Author Name:  junbaobao
 * @Version: 1.0
 */
@Data
public class PageParamsVo {
    private String name;

    private String shareTitle;

    private String title;

    private String placeholder;

    private String link;

    private Boolean scrollable;

    private Boolean showIcon;

    private String text;

    private String source;

    private  PageItemsParamsAutoVo pageItemsParamsAutoVo;

    private  PageParamsAutoVo auto;


    private  String content;


    private  String image;

    private  String tel;


    private  String type;


    private  int autoplay;

    private  String poster;


    private  String videoUrl;

}
