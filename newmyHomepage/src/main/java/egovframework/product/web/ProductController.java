package egovframework.product.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

import egovframework.product.service.ProductService;
import egovframework.product.service.ProductDefaultVO;
import egovframework.product.service.ProductVO;

/**
 * @Class Name : ProductController.java
 * @Description : Product Controller class
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
@SessionAttributes(types=ProductVO.class)
public class ProductController {

    @Resource(name = "productService")
    private ProductService productService;
    
    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
	
    /**
	 * product 목록을 조회한다. (pageing)
	 * @param searchVO - 조회할 정보가 담긴 ProductDefaultVO
	 * @return "/product/ProductList"
	 * @exception Exception
	 */
    @RequestMapping(value="/product/ProductList.do")
    public String selectProductList(@ModelAttribute("searchVO") ProductDefaultVO searchVO, 
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
		
        List<?> productList = productService.selectProductList(searchVO);
        model.addAttribute("resultList", productList);
        
        int totCnt = productService.selectProductListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
        model.addAttribute("paginationInfo", paginationInfo);
        
        return "/product/ProductList";
    } 
    
    @RequestMapping("/product/addProductView.do")
    public String addProductView(
            @ModelAttribute("searchVO") ProductDefaultVO searchVO, Model model)
            throws Exception {
        model.addAttribute("productVO", new ProductVO());
        return "/product/ProductRegister";
    }
    
    @RequestMapping("/product/addProduct.do")
    public String addProduct(
            ProductVO productVO,
            @ModelAttribute("searchVO") ProductDefaultVO searchVO, SessionStatus status)
            throws Exception {
        productService.insertProduct(productVO);
        status.setComplete();
        return "forward:/product/ProductList.do";
    }
    
    @RequestMapping("/product/updateProductView.do")
    public String updateProductView(
            @RequestParam("num") int num ,
            @ModelAttribute("searchVO") ProductDefaultVO searchVO, Model model)
            throws Exception {
        ProductVO productVO = new ProductVO();
        productVO.setNum(num);        
        // 변수명은 CoC 에 따라 productVO
        model.addAttribute(selectProduct(productVO, searchVO));
        return "/product/ProductRegister";
    }

    @RequestMapping("/product/selectProduct.do")
    public @ModelAttribute("productVO")
    ProductVO selectProduct(
            ProductVO productVO,
            @ModelAttribute("searchVO") ProductDefaultVO searchVO) throws Exception {
        return productService.selectProduct(productVO);
    }

    @RequestMapping("/product/updateProduct.do")
    public String updateProduct(
            ProductVO productVO,
            @ModelAttribute("searchVO") ProductDefaultVO searchVO, SessionStatus status)
            throws Exception {
        productService.updateProduct(productVO);
        status.setComplete();
        return "forward:/product/ProductList.do";
    }
    
    @RequestMapping("/product/deleteProduct.do")
    public String deleteProduct(
            ProductVO productVO,
            @ModelAttribute("searchVO") ProductDefaultVO searchVO, SessionStatus status)
            throws Exception {
        productService.deleteProduct(productVO);
        status.setComplete();
        return "forward:/product/ProductList.do";
    }

}
