package com.zhiyou100.service.impl;

import java.util.List;

import com.zhiyou100.dao.EmailDao;
import com.zhiyou100.dao.impl.EmailDaoImpl;
import com.zhiyou100.entity.EmailDO;
import com.zhiyou100.service.EmailService;

public class EmailServiceImpl implements EmailService {
	private EmailDao dao = new EmailDaoImpl();

	@Override
	public void sendEmail(EmailDO email) {
		dao.sendEmail(email);
	}

	@Override
	public void saveEmail(EmailDO email) {
		dao.saveEmail(email);
	}

	@Override
	public void sendSaveEmail(EmailDO email) {
		dao.sendSaveEmail(email);
		
	}

	@Override
	public EmailDO getEmailById(long id) {

		return dao.getEmailById(id);
	}

	@Override
	public List<EmailDO> listDarftBox(long userId) {

		return dao.listDarftBox(userId);
	}

	@Override
	public List<EmailDO> listSendBox(long userId) {

		return dao.listSendBox(userId);
	}

	@Override
	public List<EmailDO> listReceiveBox(long userId) {

		return dao.listReceiveBox(userId);
	}

	@Override
	public List<EmailDO> listRubbishBox(long userId) {

		return dao.listRubbishBox(userId);
	}

	@Override
	public void removeSendToRubbishBox(long id) {
		dao.removeSendToRubbishBox(id);
	}

	@Override
	public void removeReceiveToRubbishBox(long id) {
		dao.removeReceiveToRubbishBox(id);
	}

	@Override
	public void cleanRubbishBox(EmailDO email) {
		dao.cleanRubbishBox(email);
	}

	@Override
	public void undoRemove(EmailDO email) {
		dao.undoRemove(email);
	}

}
