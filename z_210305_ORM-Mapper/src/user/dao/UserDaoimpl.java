package user.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import user.vo.UserVO;

@Repository("userDao")
public class UserDaoimpl implements UserDao {
	
	@Autowired
	private UserMapper userMapper;	//context-users.xml 에서 ORM방식을 다시 Mapper interface로 연결하여 생성한 새로운 빈을 @Autowired로 연결합니다.

	
	@Override
	public List<UserVO> readAll() {
	//DB 데이터 전체 출력
		List<UserVO> users = userMapper.selectUserList();
		return users;
	}

	@Override
	public UserVO read(String userid) {
	//특정한 아이디 하나만 가져오는 것
		UserVO user = userMapper.selectUserById(userid);
		return user;
	}

	@Override
	public void insert(UserVO user) {
	//DB 데이터 입력문
		userMapper.insertUser(user);
	}

	@Override
	public void update(UserVO user) {
	// 특정 아이디를 가진 유저의 전체 데이터를 수정
		userMapper.updateUser(user);
	}

	@Override
	public void delete(String userid) {
	// 특정 아이디를 가진 유저의 전체 데이터를 삭제 하는 것
		userMapper.deleteUser(userid);
	}

}
