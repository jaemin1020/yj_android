package egovframework.member.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import egovframework.member.service.MemberService;
import egovframework.member.service.MemberDefaultVO;
import egovframework.member.service.MemberVO;

import egovframework.member.service.impl.MemberMapper;
/**
 * @Class Name : MemberServiceImpl.java
 * @Description : Member Business Implement class
 * @Modification Information
 *
 * @author dried
 * @since 2022-11-21
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("memberService")
public class MemberServiceImpl extends EgovAbstractServiceImpl implements
        MemberService {
        
    private static final Logger LOGGER = LoggerFactory.getLogger(MemberServiceImpl.class);

    @Resource(name="memberMapper")
    private MemberMapper memberDAO;
    
    //@Resource(name="memberDAO")
    //private MemberDAO memberDAO;
    
    /** ID Generation */
    //@Resource(name="{egovMemberIdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

	/**
	 * member을 등록한다.
	 * @param vo - 등록할 정보가 담긴 MemberVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertMember(MemberVO vo) throws Exception {
    	LOGGER.debug(vo.toString());
    	
    	/** ID Generation Service */
    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
    	LOGGER.debug(vo.toString());
    	
    	memberDAO.insertMember(vo);
    	//TODO 해당 테이블 정보에 맞게 수정    	
        return null;
    }

    /**
	 * member을 수정한다.
	 * @param vo - 수정할 정보가 담긴 MemberVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateMember(MemberVO vo) throws Exception {
        memberDAO.updateMember(vo);
    }

    /**
	 * member을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 MemberVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteMember(MemberVO vo) throws Exception {
        memberDAO.deleteMember(vo);
    }

    /**
	 * member을 조회한다.
	 * @param vo - 조회할 정보가 담긴 MemberVO
	 * @return 조회한 member
	 * @exception Exception
	 */
    public MemberVO selectMember(MemberVO vo) throws Exception {
        MemberVO resultVO = memberDAO.selectMember(vo);
        if (resultVO == null)
            throw processException("info.nodata.msg");
        return resultVO;
    }
    public MemberVO loginMemberCheck(MemberVO vo) throws Exception {
        MemberVO resultVO = memberDAO.loginMemberCheck(vo);
        if (resultVO == null)
            throw processException("info.nodata.msg");
        return resultVO;
    }
    /**
	 * member 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return member 목록
	 * @exception Exception
	 */
    public List<?> selectMemberList(MemberDefaultVO searchVO) throws Exception {
        return memberDAO.selectMemberList(searchVO);
    }

    /**
	 * member 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return member 총 갯수
	 * @exception
	 */
    public int selectMemberListTotCnt(MemberDefaultVO searchVO) {
		return memberDAO.selectMemberListTotCnt(searchVO);
	}
    
}
