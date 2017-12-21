package com.zhiyou100.dao;

import java.util.List;

import com.zhiyou100.entity.EmailDO;

public interface EmailDao {
	/**
	 * 发送邮件
	 * @param email
	 */
	void sendEmail(EmailDO email);
	
	/**
	 * 保存邮件到草稿箱
	 * @param email
	 */
	void saveEmail(EmailDO email);
	
	/**
	 * 发送保存的草稿,只需要 更改发送的位置  1-->2
	 * @param email
	 */
	void sendSaveEmail(EmailDO email);
	
	/**
	 * 根据 id 获取邮件
	 * @param id
	 * @return
	 */
	EmailDO getEmailById(long id);
	
	/**
	 * 展示草稿箱
	 * @return
	 */
	List<EmailDO> listDarftBox(long userId);
	
	/**
	 * 展示发件箱
	 * @return
	 */
	List<EmailDO> listSendBox(long userId);
	
	/**
	 * 展示收件箱
	 * @return
	 */
	List<EmailDO> listReceiveBox(long userId);
	
	/**
	 * 展示垃圾箱
	 * @return
	 */
	List<EmailDO> listRubbishBox(long userId);
	
	/**
	 * 删除发送邮件到垃圾箱
	 */
	void removeSendToRubbishBox(long id);
	
	/**
	 * 删除接收邮件到垃圾箱
	 * @param email
	 */
	void removeReceiveToRubbishBox(long id);
	
	/**
	 * 从垃圾箱彻底删除邮件
	 * @param email
	 */
	void cleanRubbishBox(EmailDO email);
	
	/**
	 * 从垃圾箱恢复邮件
	 * @param email
	 */
	void undoRemove(EmailDO email);
}
