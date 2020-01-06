package com.spring.ex01;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MemberDAO {
	public static SqlSessionFactory sqlMapper = null;

	private static SqlSessionFactory getInstance() {
		if (sqlMapper == null) {
			try {
				// MemberDAO�� �� �޼��� ȣ�� �� src/mybatis/SqlMapConfig.xml����
				// ���� ������ ���� �� �����ͺ��̽����� ���� �غ� �մϴ�.
				String resource = "mybatis/SqlMapConfig.xml";
				Reader reader = Resources.getResourceAsReader(resource);
				// ���̹�Ƽ���� �̿��ϴ� sqlMapper ��ü�� �����ɴϴ�.
				sqlMapper = new SqlSessionFactoryBuilder().build(reader);
				reader.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sqlMapper;

	}

	public List<MemberVO> selectAllMemberList() {
		sqlMapper = getInstance();
		// ���� member.xml�� SQL���� ȣ���ϴ� �� ���Ǵ� SqlSession ��ü�� �����ɴϴ�.
		SqlSession session = sqlMapper.openSession();
		List<MemberVO> memlist = null;
		// ���� ���� ���ڵ带 ��ȸ�ϹǷ� selectList() �޼��忡 �����ϰ��� �ϴ� SQL���� id�� 
		// ���ڷ� �����մϴ�. / ��� ȸ�� ������ ��ȸ�մϴ�.
		memlist = session.selectList("mapper.member.selectAllMemberList");
		return memlist;
	}
	
//	 public List<HashMap<String, String>> selectAllMemberList() { 
//		sqlMapper = getInstance(); 
//     	SqlSession session = sqlMapper.openSession();
//		List<HashMap<String, String>> memlist = null; 
//   	memlist = session.selectList("mapper.member.selectAllMemberList"); 
//		return memlist; 
//	 }
	
}
