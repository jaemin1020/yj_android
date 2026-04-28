package egovframework.member.service.impl;

import java.util.List;

import egovframework.member.service.MemberVO;
import egovframework.member.service.MemberDefaultVO;

import egovframework.rte.psl.dataaccess.mapper.Mapper;

/**
 * @Class Name : MemberMapper.java
 * @Description : Member Mapper Class
 * @Modification Information
 *
 * @author dried
 * @since 2022-11-21
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Mapper("memberMapper")
public interface MemberMapper {

	/**
	 * member을 등록한다.
	 * @param vo - 등록할 정보가 담긴 MemberVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public void insertMember(MemberVO vo) throws Exception;

    /**
	 * member을 수정한다.
	 * @param vo - 수정할 정보가 담긴 MemberVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateMember(MemberVO vo) throws Exception;

    /**
	 * member을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 MemberVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteMember(MemberVO vo) throws Exception;

    /**
	 * member을 조회한다.
	 * @param vo - 조회할 정보가 담긴 MemberVO
	 * @return 조회한 member
	 * @exception Exception
	 */
    public MemberVO selectMember(MemberVO vo) throws Exception;

    /**
	 * member 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return member 목록
	 * @exception Exception
	 */
    public List<?> selectMemberList(MemberDefaultVO searchVO) throws Exception;

    /**
	 * member 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return member 총 갯수
	 * @exception
	 */
    public int selectMemberListTotCnt(MemberDefaultVO searchVO);

	public MemberVO loginMemberCheck(MemberVO vo) throws Exception;

}
