package egovframework.product.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import egovframework.product.service.ProductService;
import egovframework.product.service.ProductDefaultVO;
import egovframework.product.service.ProductVO;

import egovframework.product.service.impl.ProductMapper;
/**
 * @Class Name : ProductServiceImpl.java
 * @Description : Product Business Implement class
 * @Modification Information
 *
 * @author dried
 * @since 2022-11-21
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("productService")
public class ProductServiceImpl extends EgovAbstractServiceImpl implements
        ProductService {
        
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Resource(name="productMapper")
    private ProductMapper productDAO;
    
    //@Resource(name="productDAO")
    //private ProductDAO productDAO;
    
    /** ID Generation */
    //@Resource(name="{egovProductIdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

	/**
	 * product을 등록한다.
	 * @param vo - 등록할 정보가 담긴 ProductVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertProduct(ProductVO vo) throws Exception {
    	LOGGER.debug(vo.toString());
    	
    	/** ID Generation Service */
    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
    	LOGGER.debug(vo.toString());
    	
    	productDAO.insertProduct(vo);
    	//TODO 해당 테이블 정보에 맞게 수정    	
        return null;
    }

    /**
	 * product을 수정한다.
	 * @param vo - 수정할 정보가 담긴 ProductVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateProduct(ProductVO vo) throws Exception {
        productDAO.updateProduct(vo);
    }

    /**
	 * product을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 ProductVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteProduct(ProductVO vo) throws Exception {
        productDAO.deleteProduct(vo);
    }

    /**
	 * product을 조회한다.
	 * @param vo - 조회할 정보가 담긴 ProductVO
	 * @return 조회한 product
	 * @exception Exception
	 */
    public ProductVO selectProduct(ProductVO vo) throws Exception {
        ProductVO resultVO = productDAO.selectProduct(vo);
        if (resultVO == null)
            throw processException("info.nodata.msg");
        return resultVO;
    }

    /**
	 * product 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return product 목록
	 * @exception Exception
	 */
    public List<?> selectProductList(ProductDefaultVO searchVO) throws Exception {
        return productDAO.selectProductList(searchVO);
    }

    /**
	 * product 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return product 총 갯수
	 * @exception
	 */
    public int selectProductListTotCnt(ProductDefaultVO searchVO) {
		return productDAO.selectProductListTotCnt(searchVO);
	}
    
}
