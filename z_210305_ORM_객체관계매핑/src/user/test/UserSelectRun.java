package user.test;

import java.util.List;

import org.springframework.context.ApplicationContext;

import org.springframework.context.support.GenericXmlApplicationContext;

import user.service.UserService;
import user.vo.UserVO;

public class UserSelectRun {
	
	private ApplicationContext _context;

	public UserSelectRun() {
		//스프링빈 프레임워크를 활용한 DB연결
		_context = new GenericXmlApplicationContext("classpath:resources/context-users.xml");
		System.out.println("ApplicationContext : "+(_context !=null));
	}

	//실제로 실행시키는 구간
	public static void main(String[] args) {
		UserSelectRun userTest=new UserSelectRun();
		userTest.getUserTest();
		
	}
	//////////////////////////

	//특정아이디의 데이터를 출력
	public void getUserTest() {
		UserService userservice = (UserService)_context.getBean("userService");
		UserVO user=userservice.getUser("1000");	//1000의 아이디를 입력
		System.out.printf("[getUser] %s,%s,%s,%s -> success\n",user.getUserid(),user.getName(),user.getGender(),user.getCity());
	}	
}
