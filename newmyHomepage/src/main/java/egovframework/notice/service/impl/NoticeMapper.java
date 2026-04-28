package egovframework.notice.service.impl;

import java.util.List;

import egovframework.notice.service.NoticeVO;
import egovframework.notice.service.NoticeDefaultVO;

import egovframework.rte.psl.dataaccess.mapper.Mapper;

/**
 * @Class Name : NoticeMapper.java
 * @Description : Notice Mapper Class
 * @Modification Information
 *
 * @author dried
 * @since 2022-12-07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Mapper("noticeMapper")
public interface NoticeMapper {

	/**
	 * notice을 등록한다.
	 * @param vo - 등록할 정보가 담긴 NoticeVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public void insertNotice(NoticeVO vo) throws Exception;

    /**
	 * notice을 수정한다.
	 * @param vo - 수정할 정보가 담긴 NoticeVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateNotice(NoticeVO vo) throws Exception;

    /**
	 * notice을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 NoticeVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteNotice(NoticeVO vo) throws Exception;

    /**
	 * notice을 조회한다.
	 * @param vo - 조회할 정보가 담긴 NoticeVO
	 * @return 조회한 notice
	 * @exception Exception
	 */
    public NoticeVO selectNotice(NoticeVO vo) throws Exception;

    /**
	 * notice 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return notice 목록
	 * @exception Exception
	 */
    public List<?> selectNoticeList(NoticeDefaultVO searchVO) throws Exception;

    /**
	 * notice 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return notice 총 갯수
	 * @exception
	 */
    public int selectNoticeListTotCnt(NoticeDefaultVO searchVO);

}
