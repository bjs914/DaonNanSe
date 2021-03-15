package spring;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;

public class MemberDao {
	//orcle DB연결을 위한 단계, DAO(Data Access Object)는 DB를 사용해 데이터를 조화하거나 조작하는 기능을 전담하도록 만든 오브젝트
	JdbcTemplate jdbcTemplate;	//Spring JDBC 접근방법 중 하나
	
	//DataSource 인터페이스 활용, DB연결을 위한 단계
	public MemberDao(DataSource dataSource) {
		this.jdbcTemplate=new JdbcTemplate(dataSource);
	//Spring JDBC 접근방법 중 하나로 객체화 한 jdcbTemplate에 DataSource를 주입.
	//JDBC 접근 connection들을 모아두는 장소를 connection pool이라 하며, 
	//Datasource는 java 에서 connection pool을 지원하기 위한 인터페이스이다.
	}
	
	//DB 데이터 입력 시작
	public void insert(Member member) {
		//GeneratedKeyHolder : 자동으로 생성된 컬럼의 키(id)값을 알고 싶으면 사용함
		GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();	
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement stmt = con.prepareStatement(
				"INSERT INTO members(id,email,password,name,regdate) VALUES(members_seq.nextval,?,?,?,?)",new String[] {"id"});
				stmt.setString(1, member.getEmail());
				stmt.setString(2, member.getPassword());
				stmt.setString(3, member.getName());
				stmt.setTimestamp(4, Timestamp.valueOf(member.getRegisterDateTime()));
								
				return stmt;
			}
			//keyHolder : SQL Driver에서 생성한 시퀀스값(members_seq.nextval)을 받는 것을 의미함
		}, keyHolder);
		
		Number keyValue=keyHolder.getKey();
		member.setId(keyValue.longValue());
		
		System.out.printf("[insert] keyHolder id(%d)\n",keyHolder.getKey().longValue());
	}
	
		//이메일을 입력받아 해당되는 DB 데이터를 호출
		public Member selectByEmail(String email) {
			List<Member> results = jdbcTemplate.query(
					"SELECT * FROM members WHERE email = ?",new RowMapper<Member>() {
						
			@Override
			public Member mapRow(ResultSet rs, int rownum) throws SQLException{
				Member member = new Member(
					rs.getString("email"),rs.getString("password"),
					rs.getString("name"),rs.getTimestamp("regdate").toLocalDateTime());
			
				member.setId(rs.getLong("id"));//자동으로 생성되는 id값을 주입
				return member;
				}
			}, email);
			
			//resutls가 비어있으면 null을 반환, 아니라면 0을 반환
			return results.isEmpty() ? null : results.get(0);
		}//데이터 입력 종료

	//DB전체 리스트 추가 시작
	public List<Member> selectAll(){
		List<Member> results = jdbcTemplate.query(
				"SELECT * FROM members ORDER BY id",new RowMapper<Member>() {
			
			@Override
			public Member mapRow(ResultSet rs, int rownum) throws SQLException{
				Member member = new Member(
					rs.getString("email"),rs.getString("password"),
					rs.getString("name"),rs.getTimestamp("regdate").toLocalDateTime());
			
				member.setId(rs.getLong("id"));	//자동으로 생성되는 DB id를 가져옴
				return member;
				}});
			return results;
		}//DB전체 리스트 추가 종료
	
	//특정 이메일을 받아서 DB내부 데이터 수정
	public void update(Member member) {
		jdbcTemplate.update("UPDATE members SET name=?, password=? WHERE email=?",
				member.getName(), member.getPassword(), member.getEmail());
	}//데이터 수정 종료
	
	//특정 이메일을 받아 DB내부 데이터 삭제
	public void delete(Member member) {
		jdbcTemplate.update("DELETE FROM members WHERE email=?",member.getEmail());
	}//삭제 완료
	
	//DB내에 있는 데이터의 갯수를 확인하는 Query문
	public int count() {
		Integer count = jdbcTemplate.queryForObject("SELECT COUNT (*) FROM members",Integer.class, null);
		return count;
	}
}

