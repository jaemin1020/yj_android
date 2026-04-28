package egovframework.notice.service;

import java.util.List;
import egovframework.notice.service.NoticeDefaultVO;
import egovframework.notice.service.NoticeVO;

/**
 * @Class Name : NoticeService.java
 * @Description : Notice Business class
 * @Modification Information
 *
 * @author dried
 * @since 2022-12-07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface NoticeService {
	
	/**
	 * notice을 등록한다.
	 * @param vo - 등록할 정보가 담긴 NoticeVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    String insertNotice(NoticeVO vo) throws Exception;
    
    /**
	 * notice을 수정한다.
	 * @param vo - 수정할 정보가 담긴 NoticeVO
	 * @return void형
	 * @exception Exception
	 */
    void updateNotice(NoticeVO vo) throws Exception;
    
    /**
	 * notice을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 NoticeVO
	 * @return void형 
	 * @exception Exception
	 */
    void deleteNotice(NoticeVO vo) throws Exception;
    
    /**
	 * notice을 조회한다.
	 * @param vo - 조회할 정보가 담긴 NoticeVO
	 * @return 조회한 notice
	 * @exception Exception
	 */
    NoticeVO selectNotice(NoticeVO vo) throws Exception;
    
    /**
	 * notice 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return notice 목록
	 * @exception Exception
	 */
    List selectNoticeList(NoticeDefaultVO searchVO) throws Exception;
    
    /**
	 * notice 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return notice 총 갯수
	 * @exception
	 */
    int selectNoticeListTotCnt(NoticeDefaultVO searchVO);
    
}
