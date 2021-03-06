package com.webstore.shop.domain.repositoryimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.webstore.shop.domain.Product;
import com.webstore.shop.domain.repository.ProductRepository;
import com.webstore.shop.exception.ProductNotFoundException;

@Repository
public class MariaProductRepository implements ProductRepository{

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	//RootApplicationContextConfig 클래스에서 MariaDB와 연결한 메소드를 Autowired로 연결
	
	public List<Product> getAllProducts() {	
		Map<String, Object> params = new HashMap<String, Object>();
		List<Product> result=jdbcTemplate.query(
				"SELECT * FROM products",params,new ProductMapper());
		return result;
	}
	
	private static final class ProductMapper implements RowMapper<Product> {
		//사용되는 SQL문에 공통으로 사용됨
		public Product mapRow(ResultSet rs, int rowNum) throws SQLException{
			Product product = new Product();
			product.setProductId(rs.getString("ID"));
			product.setName(rs.getString("PROD_NAME"));
			product.setDescription(rs.getString("DESCRIPTION"));
			product.setUnitPrice(rs.getBigDecimal("UNIT_PRICE"));
			product.setManufacturer(rs.getString("MANUFACTURER"));
			product.setCategory(rs.getString("CATEGORY"));
			product.setCondition(rs.getString("PROD_CONDITION"));
			product.setUnitsInStock(rs.getLong("UNITS_IN_STOCK"));
			product.setUnitsInOrder(rs.getLong("UNITS_IN_ORDER"));
			product.setDiscontinued(rs.getBoolean("DISCONTINUED"));
			return product;
		}
	}

	public void updateStock(String productId, long noOfUnits) {
		String SQL = "UPDATE PRODUCTS SET UNITS_IN_STOCK = :unitsInStock "
				+ "WHERE ID= :id";
		// : 의 의미 : 바인드변수, PreparedStatement와 유사한 성격을 가지고있음..
		// ":변수"로 설정된 변수를 한번 실행한 후, 다시 parse하는 과정을 거치지않고 지정한 변수라는 이름으로 결과값을
		// 돌려줌 즉, HardParsing을 줄이기 위해 SQL문에서 주로 사용됨
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("unitsInStock", noOfUnits);
		params.put("id", productId);	
		jdbcTemplate.update(SQL, params);
	}

	public List<Product> getProductByCategory(String category) {
		String SQL = "SELECT * FROM products WHERE LCASE(CATEGORY) = :category";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("category", category.toLowerCase());	//여기서 SQL문의 category라는 이름이 "category" 변수명에 저장됨
		return jdbcTemplate.query(SQL, params, new ProductMapper());
		//LCASE와 toLowerCase에 의해 DB자료 및 URL의 범주 이름 문자열의 대소문자에 무관하게 처리할 수 있음
		//즉, 이 프로젝트에서 Tablet과 tablet이 같은 의미가 된다.
	}

	public List<Product> getProductsByFilter(Map<String, List<String>> filterParams) {
		//제조사별 제품군(카테고리)을 출력하기 위한 조건 설정
		String SQL = "SELECT * FROM products WHERE CATEGORY"
				+" IN(:categories) AND MANUFACTURER IN (:brands)";
		return jdbcTemplate.query(SQL, filterParams, new ProductMapper());
		//SELECT일때 query 사용
	}

	public Product getProductById(String productID) {//제품상세페이지 구현
		String SQL = "SELECT * FROM products WHERE ID= :id";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", productID);
		try {
		return jdbcTemplate.queryForObject(SQL, params, new ProductMapper());
		}catch(DataAccessException e) {
			throw new ProductNotFoundException(productID);//예외처리를 위한 리턴값 추가
		}
	}

	public void addProduct(Product product) {//제품 추가페이지 구현
		String SQL = "INSERT INTO PRODUCTS (ID, PROD_NAME, DESCRIPTION, UNIT_PRICE, MANUFACTURER,"
				+ "CATEGORY, PROD_CONDITION, UNITS_IN_STOCK, UNITS_IN_ORDER, DISCONTINUED)"
				+ "VALUES (:id, :name, :desc, :price, :manufacturer, :category, :condition,"
				+ ":inStock, :inOrder, :discontinued)";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", product.getProductId());
		params.put("name", product.getName());
		params.put("desc", product.getDescription());
		params.put("price", product.getUnitPrice());
		params.put("manufacturer", product.getManufacturer());
		params.put("category", product.getCategory());
		params.put("condition", product.getCondition());
		params.put("inStock", product.getUnitsInStock());
		params.put("inOrder", product.getUnitsInOrder());
		params.put("discontinued", product.isDiscontinued());
		jdbcTemplate.update(SQL, params);
	}
}
