package egovframework.member.service;

/**
 * @Class Name : MemberVO.java
 * @Description : Member VO class
 * @Modification Information
 *
 * @author dried
 * @since 2022-11-21
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class MemberVO extends MemberDefaultVO{
    private static final long serialVersionUID = 1L;
    
    /** id */
    private int id;
    
    /** name */
    private java.lang.String name;
    
    /** tel */
    private java.lang.String tel;
    
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public java.lang.String getName() {
        return this.name;
    }
    
    public void setName(java.lang.String name) {
        this.name = name;
    }
    
    public java.lang.String getTel() {
        return this.tel;
    }
    
    public void setTel(java.lang.String tel) {
        this.tel = tel;
    }

	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", name=" + name + ", tel=" + tel + "]";
	}
    
}
