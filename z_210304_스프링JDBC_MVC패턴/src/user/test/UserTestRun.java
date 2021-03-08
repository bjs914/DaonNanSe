package user.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import user.service.UserService;
import user.vo.UserVO;

public class UserTestRun {
	
	private ApplicationContext _context;

	public UserTestRun() {
		//스프링빈 프레임워크를 활용한 DB연결
		_context = new GenericXmlApplicationContext("classpath:resources/context-users.xml");
		System.out.println("ApplicationContext : "+(_context !=null));
	}

	//실제로 실행시키는 구간
	public static void main(String[] args) {
		UserTestRun userTest=new UserTestRun();
		//userTest.insertUserTest();
		//userTest.getUserListTest();
		//userTest.getUserTest();
		//userTest.updateUserTest();
		userTest.deleteUserTest();
	}
	//////////////////////////
	
	public void insertUserTest() {
		//캐스팅을 하여 빈즈를 활용하는 경우
		
		UserService userservice = _context.getBean("userService",UserService.class);
		userservice.insertUser(new UserVO("8000","장비","남자","촉나라"));
		userservice.insertUser(new UserVO("9000","조조","남자","위나라"));
		
		List<UserVO> users = userservice.getUserList();
		System.out.println("[getUserList]");
		for(UserVO user : users) {
			System.out.printf("[getUser] %s,%s,%s,%s ->success\n",user.getUserid(),user.getName(),user.getGender(),user.getCity());
		}
				
	}
	
	//전체 페이지 출력
	public void getUserListTest() {
		UserService userservice = (UserService) _context.getBean("userService");
		List<UserVO> users=userservice.getUserList();
		System.out.println("[getUserList]");
		for (UserVO user : users) {
			System.out.printf("> %s,%s,%s,%s\n", user.getUserid(), user.getName(), user.getGender(),
					user.getCity());
		}
	}
	
	//특정아이디의 데이터를 출력
	public void getUserTest() {
		UserService userservice = (UserService)_context.getBean("userService");
		UserVO user=userservice.getUser("8000");	//8000의 아이디를 입력
		System.out.printf("[getUser] %s,%s,%s,%s -> success\n",user.getUserid(),user.getName(),user.getGender(),user.getCity());
	}
	
	//특정아이디의 내용을 수정하는 것
	public void updateUserTest() {
		UserService userservice = (UserService)_context.getBean("userService");
		userservice.updateUser(new UserVO("8000","유비","남자","촉나라"));
	}
	
	//특정아이디의 전체 데이터를 삭제하는 것
	public void deleteUserTest() {
		UserService userservice = (UserService)_context.getBean("userService");
		userservice.deleteUser("9000");
	}

}
