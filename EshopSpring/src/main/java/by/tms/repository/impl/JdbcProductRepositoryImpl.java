package by.tms.repository.impl;

import by.tms.dto.ProductDto;
import by.tms.mapper.ProductMapper;
import by.tms.repository.JdbcProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
//@AllArgsConstructor
@Repository
@RequiredArgsConstructor
public class JdbcProductRepositoryImpl extends BaseRep implements JdbcProductRepository {

    private final JdbcTemplate jdbcTemplate;

//    @Autowired
//    public JdbcProductRepositoryImpl(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }

    //    private static final String GET_ALL_PRODUCTS = "select * from products";
    private static final String GET_PRODUCTS_BY_TYPE = "select p.id, p.name, pt.type, p.info, p.price from products p join product_type pt on pt.id = p.product_type_id where pt.type=?";
    private static final String GET_PRODUCT_TYPE = "select pt.type from products p join product_type pt on pt.id = p.product_type_id where p.id=?";
    //    private static final String GET_PRODUCTS_BY_SEARCH_CONDITION_IN_NAME = "select * from products where lower(name) like lower(?)";
//    private static final String GET_PRODUCTS_BY_SEARCH_CONDITION_IN_INFO = "select * from products where lower(info) like lower(?)";
    private static final String GET_PRODUCT = "select p.id, p.name, pt.type, p.info, p.price from products p join product_type pt on pt.id = p.product_type_id where p.id=?";

//    private static final String SELECT_ALL_PRODUCTS_BY_FILTER = "select * from products p where p.price>=? and p.price<=?";

    @Override
    public List<ProductDto> getProductsByType(String type) {
//        return jdbcTemplate.query(GET_PRODUCTS_BY_TYPE, new PreparedStatementSetter() {
//            public void setValues(PreparedStatement preparedStatement) throws SQLException {
//                preparedStatement.setString(1, type);
//            }
//        }, new ProductMapper());
//        return jdbcTemplate.query(GET_PRODUCTS_BY_TYPE, new Object[]{type}, new ProductMapper());
        return jdbcTemplate.query(GET_PRODUCTS_BY_TYPE, new ProductMapper(), type);

    }

    @Override
    public ProductDto getProduct(Long id) {
        return jdbcTemplate.query(GET_PRODUCT, new ProductMapper(), id).stream()
                .findAny()
                .orElse(null);

    }

////        @Override
//    public ProductDto getProduct(Long id) {
//        ProductDto product = null;
//        try (ConnectionWrapper connectionWrapper = CONNECTION_POOL.getConnectionWrapper();
//                PreparedStatement statement = connectionWrapper.getConnection().prepareStatement(GET_PRODUCT)) {
//            statement.setLong(1, id);
//            ResultSet resultSet = statement.executeQuery();
//            while (resultSet.next()) {
//                Product productOne = RepositoryJdbcUtils.getProduct(resultSet);
//                product = makeProductModelTransfer(productOne);
//            }
//        } catch (Exception e) {
//            log.error("Exception (getOneProduct()): ", e);
//        }
//        return product;
//    }

//    @Override
//    public List<ProductDto> getProducts() {
//        List<ProductDto> products = new ArrayList<>();
//        try (ConnectionWrapper connectionWrapper = CONNECTION_POOL.getConnectionWrapper();
//                PreparedStatement statement = connectionWrapper.getConnection().prepareStatement(GET_ALL_PRODUCTS)) {
//            fillsCollectionValues(products, statement);
//        } catch (Exception e) {
//            log.error("Exception (getProducts()): ", e);
//        }
//        return products;
//    }

    //    @Override
//    public List<ProductDto> getProductsByType(String type) {
//        List<ProductDto> products = new ArrayList<>();
//        try (ConnectionWrapper connectionWrapper = CONNECTION_POOL.getConnectionWrapper();
//                PreparedStatement statement = connectionWrapper.getConnection().prepareStatement(GET_PRODUCTS_BY_TYPE)) {
//            statement.setString(1, type);
//            fillsCollectionValues(products, statement);
//        } catch (Exception e) {
//            log.error("Exception (getProductsByType()): ", e);
//        }
//        return products;
//    }
//
    @Override
    public String getProductTypeValue(Long id) {
        return jdbcTemplate.query(GET_PRODUCT_TYPE, new ProductMapper(), id).stream()
                .findAny()
                .map(ProductDto::getType)
                .orElse(null);
//        String type = "";
//        try (ConnectionWrapper connectionWrapper = CONNECTION_POOL.getConnectionWrapper();
//                PreparedStatement statement = connectionWrapper.getConnection().prepareStatement(GET_PRODUCT_TYPE)) {
//            statement.setLong(1, productId);
//            ResultSet resultSet = statement.executeQuery();
//            while (resultSet.next()) {
//                type = resultSet.getString("type");
//            }
//        } catch (Exception e) {
//            log.error("Exception (getProductTypeValue()): ", e);
//        }
//        return type;
    }
//
//    @Override
//    public Set<Product> getFoundProducts(String searchCondition) {
//        Set<Product> products = new LinkedHashSet<>();
//        try (ConnectionWrapper connectionWrapper = CONNECTION_POOL.getConnectionWrapper();
//                PreparedStatement statementByName = connectionWrapper.getConnection().prepareStatement(GET_PRODUCTS_BY_SEARCH_CONDITION_IN_NAME);
//                PreparedStatement statementByInfo = connectionWrapper.getConnection().prepareStatement(GET_PRODUCTS_BY_SEARCH_CONDITION_IN_INFO)) {
//            fillsSet(searchCondition, products, statementByName);
//            fillsSet(searchCondition, products, statementByInfo);
//        } catch (Exception e) {
//            log.error("Exception (getFoundProducts()): ", e);
//        }
//        return products;
//    }
//
//    @Override
//    public Product getOneProduct(Long id) {
//        Product product = Product.builder().build();
//        try (ConnectionWrapper connectionWrapper = CONNECTION_POOL.getConnectionWrapper();
//                PreparedStatement statement = connectionWrapper.getConnection().prepareStatement(GET_PRODUCT)) {
//            statement.setLong(1, id);
//            ResultSet resultSet = statement.executeQuery();
//            while (resultSet.next()) {
//                product = RepositoryJdbcUtils.getProduct(resultSet);
//            }
//        } catch (Exception e) {
//            log.error("Exception (getOneProduct()): ", e);
//        }
//        return product;
//    }
//
//    @Override
//    public Set<Product> selectAllProductsByFilter(String type, BigDecimal minPrice, BigDecimal maxPrice) {
//        Set<Product> products = new LinkedHashSet<>();
//        String query = getQueryDependType(type, SELECT_ALL_PRODUCTS_BY_FILTER);
//        try (ConnectionWrapper connectionWrapper = CONNECTION_POOL.getConnectionWrapper();
//                PreparedStatement statement = connectionWrapper.getConnection().prepareStatement(query)) {
//            statement.setBigDecimal(1, minPrice);
//            statement.setBigDecimal(2, maxPrice);
//            fillsCollectionValues(products, statement);
//        } catch (Exception e) {
//            log.error("Exception (selectAllProductsByFilter()): ", e);
//        }
//        return products;
//    }
}