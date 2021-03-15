package service;


import java.util.Collection;

import spring.Member;
import spring.MemberDao;

public class MemberListPrinter {
	
	private MemberDao memberDao;
	private MemberPrinter printer;

	public MemberListPrinter(MemberDao memberDao, MemberPrinter printer) {
		this.memberDao = memberDao;
		this.printer = printer;
	}

	public void printAll() {
		System.out.printf("Member count = %d\n",memberDao.count());
		Collection<Member> members = memberDao.selectAll();
		members.forEach(m -> printer.print(m));
	}

}
