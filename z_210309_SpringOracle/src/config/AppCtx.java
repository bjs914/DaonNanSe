package config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import dao.MemberDao;
import service.ChangePasswordService;
import service.MemberRegisterService;
import service.MemberUnRegisterService;
import spring.MemberListPrinter;
import spring.MemberPrinter;




//db연결 및 DataSource 인터페이스 내에 각 구현 클래스 연결
@Configuration
public class AppCtx {
	//DB연결을 위해 경로,driver 등 지정
	private static String driver="oracle.jdbc.OracleDriver";
	private static String url="jdbc:oracle:thin:@localhost:1521:xe";
	private static String username="soluser";
	private static String password="test";
		
	//DB연결을 위해 객체화 한 것을 실제로 연결하는 빈
	//입력한 것을 DataSource라는 인터페이스 안에 저장하기 위해 인터페이스 지정
	@Bean	
	public DataSource dataSource() {
		SimpleDriverDataSource ds=new SimpleDriverDataSource();
		ds.setDriver(new oracle.jdbc.OracleDriver());
		ds.setUrl(url);
		ds.setUsername(username);
		ds.setPassword(password);
		return ds;	
	}//연결 종료
	
	//Dao에 dataSource 연결
	@Bean
	public MemberDao memberDao() {
		return new MemberDao(dataSource());	//Dao에 dataSource를 연결
	}//연결종료
	
	//위에서 연결한 memberDao 메소드를 각 서비스에 연결 (DB연결을 위한 객체 저장되어있음)
	@Bean	//DB내 데이터 입력 서비스 연결
	public MemberRegisterService memberRegSvc() {
		return new MemberRegisterService(memberDao());
	}//종료
	
	@Bean	//DB 내 데이터 삭제 서비스 연결 (DB연결을 위한 객체 저장되어있음)
	public MemberUnRegisterService memberUnRegSvc() {
		return new MemberUnRegisterService(memberDao());
	}//종료
	
	@Bean	//DB 내 데이터 수정(비밀번호) 서비스 연결 (DB연결을 위한 객체 저장되어있음)
	public ChangePasswordService changePwdSvc() {
		ChangePasswordService pwdSvc = new ChangePasswordService();
		pwdSvc.setMemberDao(memberDao());
		return pwdSvc;
	}//종료
	
	@Bean	//DB 내 특정 데이터 출력 서비스 연결
	public MemberPrinter memberPrinter() {
		return new MemberPrinter();
	}//종료
	
	@Bean	//DB 내 전체 데이터 출력 서비스 연결
	public MemberListPrinter listPrinter() {
		return new MemberListPrinter(memberDao(), memberPrinter());
	}//종료
	
}
