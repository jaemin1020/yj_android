package egovframework.product.service;

import java.util.List;
import egovframework.product.service.ProductDefaultVO;
import egovframework.product.service.ProductVO;

/**
 * @Class Name : ProductService.java
 * @Description : Product Business class
 * @Modification Information
 *
 * @author dried
 * @since 2022-11-21
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface ProductService {
	
	/**
	 * product을 등록한다.
	 * @param vo - 등록할 정보가 담긴 ProductVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    String insertProduct(ProductVO vo) throws Exception;
    
    /**
	 * product을 수정한다.
	 * @param vo - 수정할 정보가 담긴 ProductVO
	 * @return void형
	 * @exception Exception
	 */
    void updateProduct(ProductVO vo) throws Exception;
    
    /**
	 * product을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 ProductVO
	 * @return void형 
	 * @exception Exception
	 */
    void deleteProduct(ProductVO vo) throws Exception;
    
    /**
	 * product을 조회한다.
	 * @param vo - 조회할 정보가 담긴 ProductVO
	 * @return 조회한 product
	 * @exception Exception
	 */
    ProductVO selectProduct(ProductVO vo) throws Exception;
    
    /**
	 * product 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return product 목록
	 * @exception Exception
	 */
    List selectProductList(ProductDefaultVO searchVO) throws Exception;
    
    /**
	 * product 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return product 총 갯수
	 * @exception
	 */
    int selectProductListTotCnt(ProductDefaultVO searchVO);
    
}
