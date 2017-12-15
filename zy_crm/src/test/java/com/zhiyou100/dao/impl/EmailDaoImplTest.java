package com.zhiyou100.dao.impl;

import java.sql.Timestamp;

import java.time.LocalDateTime;

import org.junit.Test;

import com.zhiyou100.dao.EmailDao;
import com.zhiyou100.entity.EmailDO;

public class EmailDaoImplTest {
private EmailDao dao=new EmailDaoImpl();
EmailDO  eDo =new EmailDO();
	@Test
	public void testSendEmail() {
		
		eDo.setTitle("邮件发送测试");
		eDo.setContent("这是er个测试");
		eDo.setSendUserId((long)2);
		eDo.setReceiveUserId((long)1);
		eDo.setSendTime(Timestamp.valueOf(LocalDateTime.now()));
		dao.sendEmail(eDo);
		
	}

	@Test
	public void testSaveEmail() {
		eDo.setTitle("邮件发送测试");
		eDo.setContent("这是er个测试");
		eDo.setSendUserId((long)2);
		eDo.setReceiveUserId((long)1);
		eDo.setSendLocation(1);
		dao.saveEmail(eDo);
	}

	@Test
	public void testSendSaveEmail() {
		
	}

	@Test
	public void testGetEmailById() {
		
	}

	@Test
	public void testListDarftBox() {
		
	}

	@Test
	public void testListSendBox() {
		
	}

	@Test
	public void testListReceiveBox() {
		
	}

	@Test
	public void testListRubbishBox() {
		
	}

	@Test
	public void testRemoveSendToRubbishBox() {
		
	}

	@Test
	public void testRemoveReceiveToRubbishBox() {
		
	}

	@Test
	public void testCleanRubbishBox() {
		
	}

	@Test
	public void testUndoRemove() {
		
	}

}
