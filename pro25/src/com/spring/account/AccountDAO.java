package com.spring.account;

import org.apache.ibatis.session.SqlSession;
import org.springframework.dao.DataAccessException;

public class AccountDAO {
	private SqlSession sqlSession;

	// 속성 sqlSession에 빈을 주입하기 위해 setter를 구현합니다.
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	// 첫번째 update문을 실행해 홍길동 계좌에서 5000000원을 차감
	public void updateBalance1() throws DataAccessException {
		sqlSession.update("mapper.account.updateBalance1");
	}
	
	// 두번째 update문을 실행해 김유신 계좌에서 5000000원을 증액
	public void updateBalance2() throws DataAccessException {
		sqlSession.update("mapper.account.updateBalance2");
	}
	

}
