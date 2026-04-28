package egovframework.notice.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

import egovframework.notice.service.NoticeService;
import egovframework.member.service.MemberDefaultVO;
import egovframework.notice.service.NoticeDefaultVO;
import egovframework.notice.service.NoticeVO;

/**
 * @Class Name : NoticeController.java
 * @Description : Notice Controller class
 * @Modification Information
 *
 * @author dried
 * @since 2022-12-07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Controller
@SessionAttributes(types=NoticeVO.class)
public class NoticeController {

    @Resource(name = "noticeService")
    private NoticeService noticeService;
    
    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
	
    /**
	 * notice 목록을 조회한다. (pageing)
	 * @param searchVO - 조회할 정보가 담긴 NoticeDefaultVO
	 * @return "/notice/NoticeList"
	 * @exception Exception
	 */
    @RequestMapping(value="/notice/NoticeListjson.do")
    public @ResponseBody ModelAndView  NoticeListJson()
            throws Exception {
       System.out.println("                NoticeListJson by /NoticeListJson.mdo"   );

       
       ModelAndView jsonView = new ModelAndView("jsonView");
       
       try {
    	  NoticeDefaultVO searchVO = new NoticeDefaultVO();
    	  searchVO.setPageUnit(propertiesService.getInt("pageUnit"));
    	  searchVO.setPageSize(propertiesService.getInt("pageSize"));
    	  searchVO.setFirstIndex(0);
    	  
          List<?> noticeList = noticeService.selectNoticeList(searchVO);
          jsonView.addObject("noticeList", noticeList);
      } catch (Exception e) {
         System.out.println(e.getMessage());
         jsonView.addObject("result","NOK");
      }
       return jsonView;
    }
    
    @RequestMapping(value="/notice/NoticeList.do")
    public String selectNoticeList(@ModelAttribute("searchVO") NoticeDefaultVO searchVO, 
    		ModelMap model)
            throws Exception {
    	
    	/** EgovPropertyService.sample */
    	searchVO.setPageUnit(propertiesService.getInt("pageUnit"));
    	searchVO.setPageSize(propertiesService.getInt("pageSize"));
    	
    	/** pageing */
    	PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(searchVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(searchVO.getPageUnit());
		paginationInfo.setPageSize(searchVO.getPageSize());
		
		searchVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		searchVO.setLastIndex(paginationInfo.getLastRecordIndex());
		searchVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		
        List<?> noticeList = noticeService.selectNoticeList(searchVO);
        model.addAttribute("resultList", noticeList);
        
        int totCnt = noticeService.selectNoticeListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
        model.addAttribute("paginationInfo", paginationInfo);
        
        return "/notice/NoticeList";
    } 
    
    @RequestMapping("/notice/addNoticeView.do")
    public String addNoticeView(
            @ModelAttribute("searchVO") NoticeDefaultVO searchVO, Model model)
            throws Exception {
        model.addAttribute("noticeVO", new NoticeVO());
        return "/notice/NoticeRegister";
    }
    
    @RequestMapping("/notice/addNotice.do")
    public String addNotice(
            NoticeVO noticeVO,
            @ModelAttribute("searchVO") NoticeDefaultVO searchVO, SessionStatus status)
            throws Exception {
        noticeService.insertNotice(noticeVO);
        status.setComplete();
        return "forward:/notice/NoticeList.do";
    }
    
    @RequestMapping("/notice/addNoticejson.do")
    public String addNoticeJson(
            NoticeVO noticeVO)
            throws Exception {
        noticeService.insertNotice(noticeVO);
        return "forward:/notice/NoticeListjson.do";
    }
    
    @RequestMapping("/notice/updateNoticeView.do")
    public String updateNoticeView(
            @RequestParam("name") java.lang.String name ,
            @ModelAttribute("searchVO") NoticeDefaultVO searchVO, Model model)
            throws Exception {
        NoticeVO noticeVO = new NoticeVO();
        noticeVO.setName(name);        
        // 변수명은 CoC 에 따라 noticeVO
        model.addAttribute(selectNotice(noticeVO, searchVO));
        return "/notice/NoticeRegister";
    }

    @RequestMapping("/notice/selectNotice.do")
    public @ModelAttribute("noticeVO")
    NoticeVO selectNotice(
            NoticeVO noticeVO,
            @ModelAttribute("searchVO") NoticeDefaultVO searchVO) throws Exception {
        return noticeService.selectNotice(noticeVO);
    }

    @RequestMapping("/notice/updateNotice.do")
    public String updateNotice(
            NoticeVO noticeVO,
            @ModelAttribute("searchVO") NoticeDefaultVO searchVO, SessionStatus status)
            throws Exception {
        noticeService.updateNotice(noticeVO);
        status.setComplete();
        return "forward:/notice/NoticeList.do";
    }
    
    @RequestMapping("/notice/updateNoticejson.do")
    public String updateNoticeJson(
            NoticeVO noticeVO)
            throws Exception {
        noticeService.updateNotice(noticeVO);
        return "forward:/notice/NoticeListjson.do";
    }
    
    @RequestMapping("/notice/deleteNotice.do")
    public String deleteNotice(
            NoticeVO noticeVO,
            @ModelAttribute("searchVO") NoticeDefaultVO searchVO, SessionStatus status)
            throws Exception {
        noticeService.deleteNotice(noticeVO);
        status.setComplete();
        return "forward:/notice/NoticeList.do";
    }
    
    @RequestMapping("/notice/deleteNoticejson.do")
    public String deleteNoticeJson(
            NoticeVO noticeVO)
            throws Exception {
        noticeService.deleteNotice(noticeVO);
        return "forward:/notice/NoticeListjson.do";
    }

}
