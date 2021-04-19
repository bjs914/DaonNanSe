package user.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import user.service.UserService;
import user.vo.UserVO;

public class UserInsertRun {
	
	private ApplicationContext _context;

	public UserInsertRun() {
		//스프링빈 프레임워크를 활용한 DB연결
		_context = new GenericXmlApplicationContext("classpath:resources/context-users.xml");
		System.out.println("ApplicationContext : "+(_context !=null));
	}

	//실제로 실행시키는 구간
	public static void main(String[] args) {
		UserInsertRun userTest=new UserInsertRun();
		userTest.insertUserTest();
	}
	//////////////////////////
	
	public void insertUserTest() {
		//캐스팅을 하여 빈즈를 활용하는 경우
		
		UserService userservice = _context.getBean("userService",UserService.class);
		userservice.insertUser(new UserVO("5555","ORM-MAPPER","??","??"));
		
		
		List<UserVO> users = userservice.getUserList();
		System.out.println("[getUserList]");
		for(UserVO user : users) {
			System.out.printf("[getUser] %s,%s,%s,%s ->success\n",user.getUserid(),user.getName(),user.getGender(),user.getCity());
		}
				
	}
}
