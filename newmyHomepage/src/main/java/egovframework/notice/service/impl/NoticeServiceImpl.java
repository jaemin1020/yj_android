package egovframework.notice.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import egovframework.notice.service.NoticeService;
import egovframework.notice.service.NoticeDefaultVO;
import egovframework.notice.service.NoticeVO;
import egovframework.notice.service.impl.NoticeMapper;
/**
 * @Class Name : NoticeServiceImpl.java
 * @Description : Notice Business Implement class
 * @Modification Information
 *
 * @author dried
 * @since 2022-12-07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("noticeService")
public class NoticeServiceImpl extends EgovAbstractServiceImpl implements
        NoticeService {
        
    private static final Logger LOGGER = LoggerFactory.getLogger(NoticeServiceImpl.class);

    @Resource(name="noticeMapper")
    private NoticeMapper noticeDAO;
    
    //@Resource(name="noticeDAO")
    //private NoticeDAO noticeDAO;
    
    /** ID Generation */
    //@Resource(name="{egovNoticeIdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

	/**
	 * notice을 등록한다.
	 * @param vo - 등록할 정보가 담긴 NoticeVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertNotice(NoticeVO vo) throws Exception {
    	LOGGER.debug(vo.toString());
    	
    	/** ID Generation Service */
    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
    	LOGGER.debug(vo.toString());
    	
    	noticeDAO.insertNotice(vo);
    	//TODO 해당 테이블 정보에 맞게 수정    	
        return null;
    }

    /**
	 * notice을 수정한다.
	 * @param vo - 수정할 정보가 담긴 NoticeVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateNotice(NoticeVO vo) throws Exception {
        noticeDAO.updateNotice(vo);
    }

    /**
	 * notice을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 NoticeVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteNotice(NoticeVO vo) throws Exception {
        noticeDAO.deleteNotice(vo);
    }

    /**
	 * notice을 조회한다.
	 * @param vo - 조회할 정보가 담긴 NoticeVO
	 * @return 조회한 notice
	 * @exception Exception
	 */
    public NoticeVO selectNotice(NoticeVO vo) throws Exception {
        NoticeVO resultVO = noticeDAO.selectNotice(vo);
        if (resultVO == null)
            throw processException("info.nodata.msg");
        return resultVO;
    }

    /**
	 * notice 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return notice 목록
	 * @exception Exception
	 */
    public List<?> selectNoticeList(NoticeDefaultVO searchVO) throws Exception {
        return noticeDAO.selectNoticeList(searchVO);
    }

    /**
	 * notice 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return notice 총 갯수
	 * @exception
	 */
    public int selectNoticeListTotCnt(NoticeDefaultVO searchVO) {
		return noticeDAO.selectNoticeListTotCnt(searchVO);
	}
    
}
