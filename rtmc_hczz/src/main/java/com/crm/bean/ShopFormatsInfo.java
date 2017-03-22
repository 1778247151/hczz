package com.crm.bean;

import java.io.Serializable;

/**
 * 
 * ShopFormatsInfo:店铺和业态信息
 *
 * @author yumaochun
 * @date  2016年7月6日
 * @version  jdk1.8
 *
 */
public class ShopFormatsInfo implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = -7933169222936727341L;
    
    /**
     * 店铺编号
     */
    private String shopCode;
    
    /**
     * 店铺名称
     */
    private String shopName;
    
    /**
     * 业态编号
     */
    private String formatsCode;
    
    /**
     * 业态名称
     */
    private String formatsName;

    public String getShopCode() {
        return shopCode;
    }

    public void setShopCode(String shopCode) {
        this.shopCode = shopCode;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getFormatsCode() {
        return formatsCode;
    }

    public void setFormatsCode(String formatsCode) {
        this.formatsCode = formatsCode;
    }

    public String getFormatsName() {
        return formatsName;
    }

    public void setFormatsName(String formatsName) {
        this.formatsName = formatsName;
    }
    
    

}
