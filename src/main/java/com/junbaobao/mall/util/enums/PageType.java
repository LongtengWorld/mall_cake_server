package com.junbaobao.mall.util.enums;

/**
 * @Classname PageType
 * @Description
 * @Date: Created in 2022/12/28 22:27
 * @Author Name:  junbaobao
 * @Version: 1.0
 */
public enum PageType {
    // 单规格
    HOME(10, "首页"),

    // 多规格
    CUSTOM(20, "自定义页");

    Integer value;
    String name;


    //构造方法
    PageType(Integer value, String name) {
        this.value = value;
        this.name = name;

    }

    public static String getName(Integer value){
        for(EventTypeEnum evenEnum : EventTypeEnum.values()){
            if(evenEnum.getValue().equals(value)){
                return evenEnum.getName();
            }
        }
        return null;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
