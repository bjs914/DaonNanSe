package service;

import dao.MemberDao;
import dto.Member;
import exception.MemberNotFoundException;

public class ChangePasswordService {

	private MemberDao memberDao;
	//DataSource 인터페이스에 저장한 MemberDao 클래스를 연결하기 위해 메소드 선언
	
	public void changePassword(String email, String oldPwd, String newPwd) {
		
		Member member = memberDao.selectByEmail(email);
		//memberDao안에 있는 selectByEmail이라는 메소드를 가져와서 member 클래스에 넣는 것
		
		if (member == null)
			throw new MemberNotFoundException();

		member.changePassword(oldPwd, newPwd);

		memberDao.update(member);
	}

	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

}
