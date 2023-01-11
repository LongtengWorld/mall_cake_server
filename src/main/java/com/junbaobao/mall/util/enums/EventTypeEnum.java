package com.junbaobao.mall.util.enums;

/**
 * @Classname EventTypeEnum
 * @Description
 * @Date: Created in 2022/12/26 12:08
 * @Author Name:  junbaobao
 * @Version: 1.0
 */
public enum EventTypeEnum {
    // 单规格
    SINGLE(10, "单规格"),

    // 多规格
    MULTI(20, "多规格");

    Integer value;
    String name;


    //构造方法
    EventTypeEnum(Integer value, String name) {
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
