package com.zhiyou100.service.impl;

import java.util.List;

import com.zhiyou100.dao.NoticeDao;
import com.zhiyou100.dao.impl.NoticeDaoImpl;
import com.zhiyou100.entity.NoticeDo;
import com.zhiyou100.service.NoticeService;
import com.zhiyou100.util.NoticeSearchTypeName;

public class NoticeServiceImpl implements NoticeService {
private NoticeDao dao =new NoticeDaoImpl();
	@Override
	public List<NoticeDo> listNotice(long pageIndex) {
		
		return dao.listNotice(pageIndex) ;
	}

	@Override
	public long countNotice() {
		
		return dao.countNotice();
	}

	@Override
	public List<NoticeDo> listNotice(String Keyword, NoticeSearchTypeName type, long pageIndex) {
		
		return dao.listNotice(Keyword, type, pageIndex);
	}

	@Override
	public long countNotice(String keyword, NoticeSearchTypeName type) {
		
		return dao.countNotice(keyword, type);
	}

	@Override
	public NoticeDo getNoticeById(long id) {
		
		return dao.getNoticeById(id);
	}

	@Override
	public void addNotice(NoticeDo notice) {
		
		dao.addNotice(notice);
	}

	@Override
	public void updateNotice(NoticeDo notice) {
		
		dao.updateNotice(notice);
	}

	@Override
	public void deleteNotice(long id) {
		
		dao.deleteNotice(id);
	}

}
