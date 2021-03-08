package user.test;

import java.util.List;

import org.springframework.context.ApplicationContext;

import org.springframework.context.support.GenericXmlApplicationContext;

import user.service.UserService;
import user.vo.UserVO;

public class UserUpdateRun {
	
	private ApplicationContext _context;

	public UserUpdateRun() {
		//스프링빈 프레임워크를 활용한 DB연결
		_context = new GenericXmlApplicationContext("classpath:resources/context-users.xml");
		System.out.println("ApplicationContext : "+(_context !=null));
	}

	//실제로 실행시키는 구간
	public static void main(String[] args) {
		UserUpdateRun userTest=new UserUpdateRun();
		userTest.updateUserTest();
		userTest.getUserListTest();
	}
	//////////////////////////
	
	//특정아이디의 내용을 수정하는 것
	public void updateUserTest() {
		UserService userservice = (UserService)_context.getBean("userService");
		userservice.updateUser(new UserVO("5555","??","ORM-MAPPER","??"));
		
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


}
