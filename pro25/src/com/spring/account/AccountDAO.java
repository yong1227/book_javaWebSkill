package com.spring.account;

import org.apache.ibatis.session.SqlSession;
import org.springframework.dao.DataAccessException;

public class AccountDAO {
	private SqlSession sqlSession;

	// �Ӽ� sqlSession�� ���� �����ϱ� ���� setter�� �����մϴ�.
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	// ù��° update���� ������ ȫ�浿 ���¿��� 5000000���� ����
	public void updateBalance1() throws DataAccessException {
		sqlSession.update("mapper.account.updateBalance1");
	}
	
	// �ι�° update���� ������ ������ ���¿��� 5000000���� ����
	public void updateBalance2() throws DataAccessException {
		sqlSession.update("mapper.account.updateBalance2");
	}
	

}
