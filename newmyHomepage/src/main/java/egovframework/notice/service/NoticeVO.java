package egovframework.notice.service;

/**
 * @Class Name : NoticeVO.java
 * @Description : Notice VO class
 * @Modification Information
 *
 * @author dried
 * @since 2022-12-07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class NoticeVO extends NoticeDefaultVO{
    private static final long serialVersionUID = 1L;
    
    /** name */
    private java.lang.String name;
    
    /** number */
    private int number;
    
    public java.lang.String getName() {
        return this.name;
    }
    
    public void setName(java.lang.String name) {
        this.name = name;
    }
    
    public int getNumber() {
        return this.number;
    }
    
    public void setNumber(int number) {
        this.number = number;
    }
    
}
