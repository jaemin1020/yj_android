package egovframework.member.service;

import java.util.List;
import egovframework.member.service.MemberDefaultVO;
import egovframework.member.service.MemberVO;

/**
 * @Class Name : MemberService.java
 * @Description : Member Business class
 * @Modification Information
 *
 * @author dried
 * @since 2022-11-21
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface MemberService {
	
	/**
	 * member을 등록한다.
	 * @param vo - 등록할 정보가 담긴 MemberVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    String insertMember(MemberVO vo) throws Exception;
    
    /**
	 * member을 수정한다.
	 * @param vo - 수정할 정보가 담긴 MemberVO
	 * @return void형
	 * @exception Exception
	 */
    void updateMember(MemberVO vo) throws Exception;
    
    /**
	 * member을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 MemberVO
	 * @return void형 
	 * @exception Exception
	 */
    void deleteMember(MemberVO vo) throws Exception;
    
    /**
	 * member을 조회한다.
	 * @param vo - 조회할 정보가 담긴 MemberVO
	 * @return 조회한 member
	 * @exception Exception
	 */
    MemberVO selectMember(MemberVO vo) throws Exception;
    
    /**
	 * member 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return member 목록
	 * @exception Exception
	 */
    List selectMemberList(MemberDefaultVO searchVO) throws Exception;
    
    /**
	 * member 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return member 총 갯수
	 * @exception
	 */
    int selectMemberListTotCnt(MemberDefaultVO searchVO);

	MemberVO loginMemberCheck(MemberVO vo) throws Exception;
    
}
