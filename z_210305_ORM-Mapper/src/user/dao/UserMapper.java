package user.dao;

import java.util.List;

import user.vo.UserVO;

public interface UserMapper {

	public UserVO selectUserById(String userid);
	public List<UserVO> selectUserList();
	public void insertUser(UserVO user);
	public void updateUser(UserVO user);
	public void deleteUser(String userid);
}
