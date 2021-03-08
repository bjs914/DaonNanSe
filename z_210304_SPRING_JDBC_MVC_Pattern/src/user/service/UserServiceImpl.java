package user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import user.dao.UserDao;
import user.vo.UserVO;

@Service("userService")
public class UserServiceImpl implements UserService {

	
	@Autowired
	UserDao userdao;	//userdao 인터페이스를 연결시켜서 활용하기 위해 선언
	
	@Override
	public List<UserVO> getUserList() {
		
		return userdao.readAll();
	}

	@Override
	public UserVO getUser(String userid) {
		// TODO Auto-generated method stub
		return userdao.read(userid);
	}

	@Override
	public void insertUser(UserVO user) {
		userdao.insert(user);	//UserDao 인터페이스에서 public void로 선언했기 때문에 return값이 필요없음

	}

	@Override
	public void deleteUser(String userid) {
		userdao.delete(userid);

	}

	@Override
	public void updateUser(UserVO user) {
		userdao.update(user);

	}

}
