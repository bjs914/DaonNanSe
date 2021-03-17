package service;

import java.time.LocalDateTime;

import dao.MemberDao;
import dto.Member;
import dto.RegisterRequest;
import exception.DuplicateMemberException;

//메인 출력과 연결되는 서비스 클래스
public class MemberRegisterService {
	private MemberDao memberDao;	//서비스 연결을 위해 DAO와 연결

	//DataSource 인터페이스에 저장한 MemberDao 클래스를 연결하기 위해 메소드 선언
	public MemberRegisterService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	//임시저장소에서 필요한 데이터를 가져오기 위함
	public Long regist(RegisterRequest req) {
		//임시저장소에 저장된 email을 dao에 연결
		Member member = memberDao.selectByEmail(req.getEmail());
		if (member != null) {
			throw new DuplicateMemberException("dup email " + req.getEmail());
		}
		
		//DTO클래스의 데이터를 가져와 새로운 객체로 지정 → dao에 연결
		Member newMember = new Member(
				req.getEmail(), req.getPassword(), req.getName(), 
				LocalDateTime.now());
		memberDao.insert(newMember);
		return newMember.getId();
	}
}
