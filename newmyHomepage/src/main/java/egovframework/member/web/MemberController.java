package egovframework.member.web;

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

import egovframework.member.service.MemberService;
import egovframework.member.service.MemberDefaultVO;
import egovframework.member.service.MemberVO;

/**
 * @Class Name : MemberController.java
 * @Description : Member Controller class
 * @Modification Information
 *
 * @author dried
 * @since 2022-11-21
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Controller
@SessionAttributes(types=MemberVO.class)
public class MemberController {

    @Resource(name = "memberService")
    private MemberService memberService;
    
    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
	
    /**
	 * member 목록을 조회한다. (pageing)
	 * @param searchVO - 조회할 정보가 담긴 MemberDefaultVO
	 * @return "/member/MemberList"
	 * @exception Exception
	 */
    @RequestMapping(value="/member/MemberListjson.do")
    public @ResponseBody ModelAndView  MemberListJson()
            throws Exception {
       System.out.println("                MemberListJson by /MemberListJson.mdo"   );

       
       ModelAndView jsonView = new ModelAndView("jsonView");
       
       try {
    	  MemberDefaultVO searchVO = new MemberDefaultVO();
    	  searchVO.setPageUnit(propertiesService.getInt("pageUnit"));
    	  searchVO.setPageSize(propertiesService.getInt("pageSize"));
    	  searchVO.setFirstIndex(0);
    	  
          List<?> memberList = memberService.selectMemberList(searchVO);
          jsonView.addObject("memberList", memberList);
//          jsonView.addObject("facultyList",new ArrayList<MemberVO>());
//          jsonView.addObject("result","OK");
      } catch (Exception e) {
         System.out.println(e.getMessage());
         jsonView.addObject("result","NOK");
      }
       return jsonView;
    } 
    
    @RequestMapping(value="/member/MemberList.do")
    public String selectMemberList(@ModelAttribute("searchVO") MemberDefaultVO searchVO, 
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
		
        List<?> memberList = memberService.selectMemberList(searchVO);
        model.addAttribute("resultList", memberList);
        
        int totCnt = memberService.selectMemberListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
        model.addAttribute("paginationInfo", paginationInfo);
        
        return "/member/MemberList";
    } 
    
    @RequestMapping("/member/addMemberView.do")
    public String addMemberView(
            @ModelAttribute("searchVO") MemberDefaultVO searchVO, Model model)
            throws Exception {
        model.addAttribute("memberVO", new MemberVO());
        return "/member/MemberRegister";
    }
    
    @RequestMapping("/member/addMember.do")
    public String addMember(
            MemberVO memberVO,
            @ModelAttribute("searchVO") MemberDefaultVO searchVO, SessionStatus status)
            throws Exception {
        memberService.insertMember(memberVO);
        status.setComplete();
        return "forward:/member/MemberList.do";
    }
    
    @RequestMapping("/member/addMemberjson.do")
    public String addMemberJson(
            MemberVO memberVO)
            throws Exception {
        memberService.insertMember(memberVO);
        return "forward:/member/MemberListjson.do";
    }
    
    @RequestMapping("/member/updateMemberView.do")
    public String updateMemberView(
            @RequestParam("id") int id ,
            @ModelAttribute("searchVO") MemberDefaultVO searchVO, Model model)
            throws Exception {
        MemberVO memberVO = new MemberVO();
        memberVO.setId(id);        
        // 변수명은 CoC 에 따라 memberVO
        model.addAttribute(selectMember(memberVO, searchVO));
        return "/member/MemberRegister";
    }

    @RequestMapping("/member/selectMember.do")
    public @ModelAttribute("memberVO")
    MemberVO selectMember(
            MemberVO memberVO,
            @ModelAttribute("searchVO") MemberDefaultVO searchVO) throws Exception {
        return memberService.selectMember(memberVO);
    }
    
  //127.0.0.1/member/loginMemberCheck.do?name=abc&tel=1234
    @RequestMapping("/member/loginMemberCheck.do")
    public String loginMemberCheck(
            MemberVO memberVO, Model model) throws Exception {
    	memberVO = memberService.loginMemberCheck(memberVO);
    	model.addAttribute(memberVO);
        return "/member/loginMemberCheck";
    }

    @RequestMapping("/member/updateMember.do")
    public String updateMember(
            MemberVO memberVO,
            @ModelAttribute("searchVO") MemberDefaultVO searchVO, SessionStatus status)
            throws Exception {
        memberService.updateMember(memberVO);
        status.setComplete();
        return "forward:/member/MemberList.do";
    }
    
    @RequestMapping("/member/deleteMember.do")
    public String deleteMember(
            MemberVO memberVO,
            @ModelAttribute("searchVO") MemberDefaultVO searchVO, SessionStatus status)
            throws Exception {
        memberService.deleteMember(memberVO);
        status.setComplete();
        return "forward:/member/MemberList.do";
    }
    
    @RequestMapping("/member/deleteMemberjson.do")
    public String deleteMemberJson(
            MemberVO memberVO)
            throws Exception {
        memberService.deleteMember(memberVO);
        return "forward:/member/MemberListjson.do";
    }

}
