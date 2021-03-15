package exception;

public class DuplicateMemberException extends RuntimeException{

	//에러메시지를 출력하기 위한 메소드 선언
	public DuplicateMemberException(String message) {
		super(message);
	}
}
