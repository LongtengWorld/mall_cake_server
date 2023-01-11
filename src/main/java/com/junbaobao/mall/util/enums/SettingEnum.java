package com.junbaobao.mall.util.enums;

/**
 * @Classname SettingEnum
 * @Description
 * @Date: Created in 2023/1/3 23:06
 * @Author Name:  junbaobao
 * @Version: 1.0
 */
public enum SettingEnum {

    DELIVERY("delivery", "配送设置"),

    TRADE("trade", "交易设置"),

    SMS("sms", "短信通知"),


    STORAGE("storage", "上传设置"),


    FULL_FREE("full_free", "满额包邮设置"),

    REGISTER("register", "账户注册设置"),

    RECHARGE("recharge", "充值设置"),

    POINTS("points", "积分设置"),

    PAGE_CATEGORY_TEMPLATE("page_category_template", "分类页模板");

    String code;
    String name;


    //构造方法
    SettingEnum(String code, String name) {
        this.code = code;
        this.name = name;

    }

    public static String getName(Integer value) {
        for (EventTypeEnum evenEnum : EventTypeEnum.values()) {
            if (evenEnum.getValue().equals(value)) {
                return evenEnum.getName();
            }
        }
        return null;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }
}
