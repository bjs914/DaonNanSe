package dto;

import java.time.LocalDateTime;

import exception.WrongIdPasswordException;

public class Member {//DTO 클래스 : 데이터를 오브젝트(객체)로 변환하는 클래스
	private Long id; //DB열 번호(여기서는 member의 아이디)를 자동으로 입력하기 위해 선언
	private String name;	//member 이름
	private String email;	//member 이메일
	private String password;	//member 비밀번호
	private LocalDateTime registerDateTime;	//입력시간을 담기위한 객체

	//Long id로 지정한 DB열 번호는 자동으로 입력되기 때문에 따로 객체화 하지않음
	public Member(String email, String password, 
			String name, LocalDateTime regDateTime) {
		this.email = email;
		this.password = password;
		this.name = name;
		this.registerDateTime = regDateTime;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getName() {
		return name;
	}

	public LocalDateTime getRegisterDateTime() {
		return registerDateTime;
	}

	public void changePassword(String oldPassword, String newPassword) {
		//변경할 비밀번호가 입력된 비밀번호와 같지 않을 시, 예외 클래스로 이동시키기 위해 선언
		if (!password.equals(oldPassword))
			throw new WrongIdPasswordException();
		this.password = newPassword;
	}

}
