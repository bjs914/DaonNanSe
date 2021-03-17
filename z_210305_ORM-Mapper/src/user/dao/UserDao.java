package user.dao;

import java.util.List;

import user.vo.UserVO;

public interface UserDao {	//서비스로부터 요청이 들어오면 데이터 처리를 담당
	public List<UserVO> readAll();	//DB속 데이터 전체를 받기 위함
	public UserVO read(String userid);	//DB속 특정아이디를 가진 데이터를 받기 위함
	public void insert(UserVO user);	//UserVO 클래스를 이용하여 DB에 입력하기 위함
	public void update(UserVO user);	//UserVO 클래스를 이용하여 DB에 입력된 데이터를 수정하기 위함
	public void delete(String userid);	//특정 아이디를 받아 해당 데이터를 삭제하기 위함
}
