package service;


import exception.MemberNotFoundException;
import spring.Member;
import spring.MemberDao;
import spring.RegisterRequest;

public class MemberUnRegisterService {
	private MemberDao memberDao;
	
	//DataSource 인터페이스에 저장한 MemberDao 클래스를 연결하기 위해 메소드 선언
	public MemberUnRegisterService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	public Long unregist(RegisterRequest req) {
		Member member = memberDao.selectByEmail(req.getEmail());
		if (member == null) {
			throw new MemberNotFoundException();
			//DataSource 인터페이스에 있는 email을 가져와 dao에 연결 → member(dto)에 다시 입력
			//에러 발생을 위한 클래스 호출
		}
		
		memberDao.delete(member);
		return member.getId();
	}
}
