package config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import oracle.jdbc.pool.OracleDataSource;
import service.ChangePasswordService;
import service.MemberListPrinter;
import service.MemberPrinter;
import service.MemberRegisterService;
import service.MemberUnRegisterService;
import spring.MemberDao;



@Configuration
public class OracleCtx {
	private static String driver="oracle.jdbc.OracleDriver";
	private static String url="jdbc:oracle:thin:@localhost:1521:xe";
	private static String username="soluser";
	private static String password="test";
	
	@Bean
	public DataSource dataSource() {
		try {
			OracleDataSource ds=new OracleDataSource();
			ds.setURL(url);
			ds.setUser(username);
			ds.setPassword(password);
			return ds;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Bean
	public MemberDao memberDao() {
		return new MemberDao(dataSource());
	}
	
	@Bean
	public MemberRegisterService memberRegSvc() {
		return new MemberRegisterService(memberDao());
	}
	
	@Bean MemberUnRegisterService memberUnRegSvc() {
		return new MemberUnRegisterService(memberDao());
	}
	
	@Bean
	public ChangePasswordService changePwdSvc() {
		ChangePasswordService pwdSvc = new ChangePasswordService();
		pwdSvc.setMemberDao(memberDao());
		return pwdSvc;
	}
	
	@Bean
	public MemberPrinter memberPrinter() {
		return new MemberPrinter();
	}
	
	@Bean
	public MemberListPrinter listPrinter() {
		return new MemberListPrinter(memberDao(), memberPrinter());
	}
	
}
