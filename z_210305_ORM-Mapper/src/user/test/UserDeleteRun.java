package user.test;

import java.util.List;

import org.springframework.context.ApplicationContext;

import org.springframework.context.support.GenericXmlApplicationContext;

import user.service.UserService;
import user.vo.UserVO;

public class UserDeleteRun {
	
	private ApplicationContext _context;

	public UserDeleteRun() {
		//스프링빈 프레임워크를 활용한 DB연결
		_context = new GenericXmlApplicationContext("classpath:resources/context-users.xml");
		System.out.println("ApplicationContext : "+(_context !=null));
	}

	//실제로 실행시키는 구간
	public static void main(String[] args) {
		UserDeleteRun userTest=new UserDeleteRun();
		userTest.deleteUserTest();
		userTest.getUserListTest();
	}
	//////////////////////////
	
	//특정아이디의 전체 데이터를 삭제하는 것
		public void deleteUserTest() {
			UserService userservice = (UserService)_context.getBean("userService");
			userservice.deleteUser("5555");
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
