package com.myspring.pro29.ex01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test/*")
public class TestContorller {
	static Logger logger = LoggerFactory.getLogger(TestContorller.class);
	

	// hello ��û �� �������� ���ڿ��� �����մϴ�.
	@RequestMapping("/hello")
	public String hello() {
		return "Hello REST!!";
	}
	
	// MemberVO ��ü�� �Ӽ� ���� ������ �� JSON���� �����մϴ�.
	@RequestMapping("/member")
	public MemberVO member() {
		MemberVO vo = new MemberVO();
		vo.setId("hong");
		vo.setPwd("1234");
		vo.setName("ȫ�浿");
		vo.setEmail("hong@test.com");
		return vo;
	}
	
	@RequestMapping("/memberList")
	public List<MemberVO> listMembers(){
		// MemberVO ��ü�� ������ ArrayList ��ü�� �����մϴ�.
		List<MemberVO> list = new ArrayList<MemberVO>();
		
		// MemberVO ��ü�� 10�� ������ ArrayList�� �����մϴ�.
		for (int i = 0; i < 10; i++) {
			MemberVO vo = new MemberVO();
			vo.setId("hong"+i);
			vo.setPwd("123"+i);
			vo.setName("ȫ�浿"+i);
			vo.setEmail("hong"+i+"@test.com");
			list.add(vo);
		}
		// ArrayList�� JSON���� �������� �����մϴ�.
		return list;
	}
	
	@RequestMapping("/membersMap")
	public Map<Integer, MemberVO> membersMap(){
		
		// MemberVO ��ü�� ������ HashMap ��ü�� �����մϴ�.
		Map<Integer, MemberVO> map = new HashMap<Integer, MemberVO>();
		
		// MemberVO ��ü�� HashMap�� �����մϴ�.
		for(int i = 0; i < 10; i++) {
			MemberVO vo = new MemberVO();
			vo.setId("hong" + i);
			vo.setPwd("123"+ i );
			vo.setName("ȫ�浿" + i);
			vo.setEmail("hong" + i + "@test.com");
			// HashMap ��ü�� �������� �����մϴ�.
			map.put(i, vo);
		}
		return map;
	}
	
	// ���������� ��û �� {num}�κ��� ���� @PathVariable�� �����˴ϴ�.
	@RequestMapping(value = "/notice/{num}", method = RequestMethod.GET)
	// ��û URL���� ������ ���� num�� �ڵ����� �Ҵ�˴ϴ�.
	public int notice(@PathVariable("num") int num) throws Exception{
		return num;
	}
	
	@RequestMapping(value = "/info", method = RequestMethod.POST)
	// JSON���� ���۵� �����͸� MemberVO ��ü�� �Ӽ��� �ڵ����� ������ �ݴϴ�.
	public void modify(@RequestBody MemberVO vo) {
		logger.info(vo.toString());
	}
	
	@RequestMapping("/memberList2")
	// ResponseEntity�� �����մϴ�.
	public ResponseEntity<List<MemberVO>> listMember2(){
		
		List<MemberVO> list = new ArrayList<MemberVO>();
		for (int i = 0; i < 10; i++) {
			MemberVO vo = new MemberVO();
			vo.setId("lee" + i);
			vo.setPwd("123" + i);
			vo.setName("�̼���" + i);
			vo.setEmail("lee" + i + "@test.com");
			list.add(vo);
		}
		
		// ���� �ڵ� 500���� �����մϴ�.
		return new ResponseEntity(list, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@RequestMapping(value = "/res3")
	public ResponseEntity res3() {
		HttpHeaders responseHeaders = new HttpHeaders();
		// ������ �������� ������ ���ڵ��� �����մϴ�.
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		
		// ������ �ڹٽ�ũ��Ʈ �ڵ带 ���ڿ��� �ۼ��մϴ�.
		String message = "<script>";
		message += " alert('�� ȸ���� ����մϴ�.');";
		message += " location.href='/pro29/test/memberList2';";
		message += " </script>";
		
		// ResponseEntity�� �̿���  HTML �������� �����մϴ�.
		return new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
	}
}
