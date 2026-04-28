package egovframework.product.service;

/**
 * @Class Name : ProductVO.java
 * @Description : Product VO class
 * @Modification Information
 *
 * @author dried
 * @since 2022-11-21
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class ProductVO extends ProductDefaultVO{
    private static final long serialVersionUID = 1L;
    
    /** num */
    private int num;
    
    /** name */
    private java.lang.String name;
    
    /** unit */
    private java.lang.String unit;
    
    /** price */
    private java.lang.String price;
    
    public int getNum() {
        return this.num;
    }
    
    public void setNum(int num) {
        this.num = num;
    }
    
    public java.lang.String getName() {
        return this.name;
    }
    
    public void setName(java.lang.String name) {
        this.name = name;
    }
    
    public java.lang.String getUnit() {
        return this.unit;
    }
    
    public void setUnit(java.lang.String unit) {
        this.unit = unit;
    }
    
    public java.lang.String getPrice() {
        return this.price;
    }
    
    public void setPrice(java.lang.String price) {
        this.price = price;
    }
    
}
