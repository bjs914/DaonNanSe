package user.service;

import java.util.List;

import user.vo.UserVO;

public interface UserService {
	public List<UserVO> getUserList();	//출력물을 List형식으로 받기 위함
	public UserVO getUser(String userid);	//특정 아이디를 가진 사람만 출력하기 위함
	public void insertUser(UserVO user);	//UserVO 클래스를 통해 입력하기 위함
	public void deleteUser(String userid);	//유저 id에 해당하는 값만 받아서 해당 정보를 삭제하기 위함
	public void updateUser(UserVO user);	//UserVO 클래스를 통해 데이터를 수정하기 위함
}
