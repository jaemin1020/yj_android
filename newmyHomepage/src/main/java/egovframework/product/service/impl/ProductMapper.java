package egovframework.product.service.impl;

import java.util.List;

import egovframework.product.service.ProductVO;
import egovframework.product.service.ProductDefaultVO;

import egovframework.rte.psl.dataaccess.mapper.Mapper;

/**
 * @Class Name : ProductMapper.java
 * @Description : Product Mapper Class
 * @Modification Information
 *
 * @author dried
 * @since 2022-11-21
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Mapper("productMapper")
public interface ProductMapper {

	/**
	 * product을 등록한다.
	 * @param vo - 등록할 정보가 담긴 ProductVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public void insertProduct(ProductVO vo) throws Exception;

    /**
	 * product을 수정한다.
	 * @param vo - 수정할 정보가 담긴 ProductVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateProduct(ProductVO vo) throws Exception;

    /**
	 * product을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 ProductVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteProduct(ProductVO vo) throws Exception;

    /**
	 * product을 조회한다.
	 * @param vo - 조회할 정보가 담긴 ProductVO
	 * @return 조회한 product
	 * @exception Exception
	 */
    public ProductVO selectProduct(ProductVO vo) throws Exception;

    /**
	 * product 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return product 목록
	 * @exception Exception
	 */
    public List<?> selectProductList(ProductDefaultVO searchVO) throws Exception;

    /**
	 * product 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return product 총 갯수
	 * @exception
	 */
    public int selectProductListTotCnt(ProductDefaultVO searchVO);

}
