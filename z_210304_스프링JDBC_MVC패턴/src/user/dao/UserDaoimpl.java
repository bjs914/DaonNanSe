package user.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import user.dao.UserDaoimpl.UserMapper;
import user.vo.UserVO;

@Repository("userDao")
public class UserDaoimpl implements UserDao {
	
	private JdbcTemplate jdbcTemplate;	//스프링 - DB 접근방법 중 하나인 JdbcTemplate를 사용한다.
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
	//resources패키지 내의 context-users.xml 에 선언된 빈을 사용하기 위해 선언
	//위의 void setDataSource(DataSource dataSource)에서 넘어온 데이터를 받아서 새로운 jdbcTemplate를 만든다는 의미
		this.jdbcTemplate=new JdbcTemplate(dataSource);
	}
	
	class UserMapper implements RowMapper<UserVO>{
		public UserVO mapRow(ResultSet rs, int rownum) throws SQLException{
			UserVO user=new UserVO();
			user.setUserid(rs.getString("userid"));
			user.setName(rs.getString("name"));
			user.setGender(rs.getString("gender"));
			user.setCity(rs.getString("city"));
			return user;
		}
	}
	
	@Override
	public List<UserVO> readAll() {
		String sql="select * from users order by userid asc";
		List<UserVO> users = jdbcTemplate.query(sql, new UserMapper());
		return users;
	}

	@Override
	public UserVO read(String userid) {
	//특정한 아이디 하나만 가져오는 것
		String sql="select * from users where userid=?";
		try {
		UserVO user = jdbcTemplate.queryForObject(sql, new Object[] {userid}, new UserMapper());
								//userid 하나를 받기 때문에 queryForObject 사용, List를 받을 경우 queryForList사용
		return user;
		}catch(EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public void insert(UserVO user) {
		
		String sql="insert into users(userid,name,gender,city) values(?,?,?,?)";
		int succeed=jdbcTemplate.update(sql,user.getUserid(),user.getName(),user.getGender(),user.getCity());
		System.out.printf("[insert] %s,%s,%s,%s -> success\n",user.getUserid(),user.getName(),user.getGender(),user.getCity());
	}

	@Override
	public void update(UserVO user) {
		// 특정 아이디를 가진 유저의 전체 데이터를 수정
		String sql="update users set name=?, gender=?, city=? where userid=?";
		int succeed = jdbcTemplate.update(sql,user.getName(),user.getGender(),user.getCity(),user.getUserid());
		System.out.printf("[update] %s,%s,%s,%s ->success(%d)\n",user.getUserid(),user.getName(),user.getGender(),user.getCity(),succeed);	

	}

	@Override
	public void delete(String userid) {
		// 특정 아이디를 가진 유저의 전체 데이터를 삭제 하는 것
		String sql="delete from users where userid=?";
		int succeed = jdbcTemplate.update(sql,userid);
		System.out.printf("[delete] userid=%s ->success(%d)\n",userid,succeed);

	}

}
