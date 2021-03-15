package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.invoke.WrongMethodTypeException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.AppCtx;
import exception.DuplicateMemberException;
import exception.MemberNotFoundException;
import service.ChangePasswordService;
import service.MemberListPrinter;
import service.MemberRegisterService;
import service.MemberUnRegisterService;
import spring.RegisterRequest;

//연결한 DAO, DTO, Service, Service를 저장한 임시저장소 등을 출력하는 클래스
public class MainForSpring {
	
	private static ApplicationContext ctx = null;
	
	public static void main(String[] args) throws IOException {
		ctx = new AnnotationConfigApplicationContext(AppCtx.class);

	//사용자가 입력한 값을 받아오기 위해 선언		
		BufferedReader reader = 
				new BufferedReader(new InputStreamReader(System.in));
		
	//실제 출력을 위한 코드
		while(true) {
			System.out.println("명령어를 입력하세요 : ");
			String command = reader.readLine();	//입력한 값을 저장하기 위한 객체
										
				if (command.equalsIgnoreCase("exit")) {
					System.out.println("종료합니다.");
					break;
				}
				if (command.startsWith("new ")) {
					processNewCommand(command.split(" "));
					continue;
				} 
				else if (command.startsWith("change ")) {
					processChangeCommand(command.split(" "));
					continue;
				}
				else if (command.startsWith("delete ")) {
					processDeleteCommand(command.split(" "));
					continue;
				} 
				else if (command.equals("list")) {
					processListCommand();
					continue;
				} 
			printHelp();
		}
	}
	
	//명령어 입력을 설명하기 위한 메소드
	private static void printHelp() {
		System.out.println();
		System.out.println("잘못된 명령입니다. 아래 명령어 사용법을 확인하세요.");
		System.out.println("명령어 사용법:");
		System.out.println("list + Enter key : DB 저장된 데이터 출력");
		System.out.println("new 이메일 이름 암호 암호확인");
		System.out.println("change 이메일 현재비번 변경비번");
		System.out.println("delete 이메일");

		System.out.println();		
	}

	//새로 등록 및 출력
	private static void processNewCommand(String[] arg) {
		if (arg.length != 5) {
			printHelp();
			return;
		}
		
		//AppCtx 클래스에서 선언한 메소드 이름을 사용하여 클래스에 연결
		MemberRegisterService regSvc = 
				ctx.getBean("memberRegSvc", MemberRegisterService.class);
		
		RegisterRequest req = new RegisterRequest();
		req.setEmail(arg[1]);
		req.setName(arg[2]);
		req.setPassword(arg[3]);
		req.setConfirmPassword(arg[4]);
		
		if (!req.isPasswordEqualToConfirmPassword()) {
			System.out.println("암호와 확인이 일치하지 않습니다.\n");
			return;
		}
		try {
			regSvc.regist(req);
			System.out.println("등록했습니다.\n");
		} catch (DuplicateMemberException e) {
			System.out.println("이미 존재하는 이메일입니다.\n");
		}
	}
	
	//특정 이메일을 받아 DB데이터 수정
	private static void processChangeCommand(String[] arg) {
		if(arg.length != 4) {
			printHelp();
			return;
		}
		
		//AppCtx 클래스에서 선언한 메소드 이름을 사용하여 클래스에 연결
		ChangePasswordService changePwdSvc =
				ctx.getBean("changePwdSvc",ChangePasswordService.class);
		
		try {
			//입력받은 이메일을 1에 주입, 현재비밀번호는 2, 바꿀 비밀번호는 3에 주입
			changePwdSvc.changePassword(arg[1], arg[2], arg[3]);
			System.out.println("암호를 변경했습니다.\n");
		}catch(MemberNotFoundException e) {
			System.out.println("존재하지 않는 이메일입니다.\n");
		}catch(WrongMethodTypeException e) {
			System.out.println("이메일과 암호가 일치하지 않습니다.\n");
		}
		
	}
	
	//삭제
	private static void processDeleteCommand(String[] arg) {
		if (arg.length != 2) {
			printHelp();
			return;
		}
		
		//AppCtx 클래스에서 선언한 메소드 이름을 사용하여 클래스에 연결
		MemberUnRegisterService unregSvc = 
				ctx.getBean("memberUnRegSvc", MemberUnRegisterService.class);
		
		RegisterRequest req = new RegisterRequest();
		req.setEmail(arg[1]);

		try {
			unregSvc.unregist(req);
			System.out.println("삭제했습니다.\n");
		} catch (MemberNotFoundException e) {
			System.out.println("존재하지 않는 이메일입니다.\n");
		}
	}
	
	//DB리스트 출력
	private static void processListCommand() {
		MemberListPrinter listPrinter = 
				ctx.getBean("listPrinter", MemberListPrinter.class);
		listPrinter.printAll();
	}	
}
