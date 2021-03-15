package service;

import exception.MemberNotFoundException;
import spring.Member;
import spring.MemberDao;

public class ChangePasswordService {
	private MemberDao memberDao;
	//DataSource 인터페이스에 저장한 MemberDao 클래스를 연결하기 위해 메소드 선언
	
	public void changePassword(String email, String oldPwd, String newPwd) {
		Member member = memberDao.selectByEmail(email);
		
		if(member == null)
			throw new MemberNotFoundException();
		
		member.changePassword(oldPwd, newPwd);
		
		memberDao.update(member);
	}
	
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
}
