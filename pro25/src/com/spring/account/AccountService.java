package com.spring.account;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

//@Transactional�� �̿��� AccountServiceŬ������ ��� �޼��忡 Ʈ������� �����մϴ�.
@Transactional(propagation=Propagation.REQUIRED)
public class AccountService {
	private AccountDAO accDAO;

	// �Ӽ� accDAO�� ���� �����ϱ� ���� setter�� �����մϴ�.
	public void setAccDAO(AccountDAO accDAO) {
		this.accDAO = accDAO;
	}

	// sendMoney()�޼��� ȣ�� �� accDAO�� �� ���� SQL���� �����մϴ�.
	public void sendMoney() throws Exception {
		accDAO.updateBalance1();
		accDAO.updateBalance2();
	}
}


