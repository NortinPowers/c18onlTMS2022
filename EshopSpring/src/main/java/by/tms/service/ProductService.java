package by.tms.service;

import by.tms.dto.ProductDto;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.util.Set;

public interface ProductService {

    ModelAndView getProductsByType(String type);
//    List<ProductDto> getProductsByType(String type);

    //    ProductDto getProduct(Long id);
    ModelAndView getProduct(Long id);

    String getProductTypeValue(Long productId);

    Set<ProductDto> getFoundProducts(String searchCondition);

    Set<ProductDto> selectAllProductsByFilter(String type, BigDecimal minPrice, BigDecimal maxPrice);
}
