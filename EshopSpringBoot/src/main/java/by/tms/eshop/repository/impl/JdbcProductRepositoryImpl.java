package by.tms.eshop.repository.impl;

import by.tms.eshop.dto.ProductDto;
import by.tms.eshop.mapper.ProductDtoMapper;
import by.tms.eshop.mapper.ProductTypeDtoMapper;
import by.tms.eshop.repository.JdbcProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import static by.tms.eshop.utils.RepositoryJdbcUtils.getQueryDependType;

@Slf4j
@Repository
@RequiredArgsConstructor
public class JdbcProductRepositoryImpl implements JdbcProductRepository {

    private final JdbcTemplate jdbcTemplate;

    private static final String GET_PRODUCTS_BY_TYPE = "select p.id, p.name, pt.type, p.info, p.price from products p join product_type pt on pt.id = p.product_type_id where pt.type=?";
    private static final String GET_PRODUCT_TYPE = "select pt.type from products p join product_type pt on pt.id = p.product_type_id where p.id=?";
    private static final String GET_PRODUCTS_BY_SEARCH_CONDITION_IN_NAME = "select p.id, p.name, pt.type, p.info, p.price from products p join product_type pt on pt.id = p.product_type_id where lower(name) like lower(?)";
    private static final String GET_PRODUCTS_BY_SEARCH_CONDITION_IN_INFO = "select p.id, p.name, pt.type, p.info, p.price from products p join product_type pt on pt.id = p.product_type_id where lower(info) like lower(?)";
    private static final String GET_PRODUCT = "select p.id, p.name, pt.type, p.info, p.price from products p join product_type pt on pt.id = p.product_type_id where p.id=?";
    private static final String SELECT_ALL_PRODUCTS_BY_FILTER = "select p.id, p.name, pt.type, p.info, p.price from products p join product_type pt on pt.id = p.product_type_id where p.price>=? and p.price<=?";

    @Override
    public List<ProductDto> getProductsByType(String type) {
        return jdbcTemplate.query(GET_PRODUCTS_BY_TYPE, new ProductDtoMapper(), type);
    }

    @Override
    public ProductDto getProduct(Long id) {
        return jdbcTemplate.query(GET_PRODUCT, new ProductDtoMapper(), id).stream()
                .findAny()
                .orElse(null);
    }

    @Override
    public String getProductTypeValue(Long id) {
        return jdbcTemplate.query(GET_PRODUCT_TYPE, new ProductTypeDtoMapper(), id).stream()
                .findAny()
                .map(ProductDto::getType)
                .orElse(null);
    }

    @Override
    public Set<ProductDto> getFoundProducts(String searchCondition) {
        String condition = "%" + searchCondition + "%";
        List<ProductDto> productNameSearch = jdbcTemplate.query(GET_PRODUCTS_BY_SEARCH_CONDITION_IN_NAME, new ProductDtoMapper(), condition);
        List<ProductDto> productInfoSearch = jdbcTemplate.query(GET_PRODUCTS_BY_SEARCH_CONDITION_IN_INFO, new ProductDtoMapper(), condition);
        Set<ProductDto> products = new LinkedHashSet<>(productNameSearch);
        products.addAll(productInfoSearch);
        return products;
    }

    @Override
    public Set<ProductDto> selectAllProductsByFilter(String type, BigDecimal minPrice, BigDecimal maxPrice) {
        String query = getQueryDependType(type, SELECT_ALL_PRODUCTS_BY_FILTER);
        List<ProductDto> searchProducts = jdbcTemplate.query(query, new ProductDtoMapper(), minPrice, maxPrice);
        return new LinkedHashSet<>(searchProducts);
    }
}