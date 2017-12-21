package com.zhiyou100.service;

import java.util.List;

import com.zhiyou100.entity.NoticeDo;
import com.zhiyou100.util.NoticeSearchTypeName;

/**
 * @ClassName: NoticeService
 * @Description: TODO
 * @author: guoshuai
 * @date: 2017年12月7日 下午5:06:17
 */
public interface NoticeService {

	/**
	 * @Title: listNotice
	 * @Description: 分页显示全部
	 * @param pageIndex
	 * @return页码
	 * @return: List<NoticeDo>
	 */
	List<NoticeDo> listNotice(long pageIndex);

	/**
	 * @Title: countNotice
	 * @Description: 所有公告的数量
	 * @return
	 * @return: int
	 */
	long countNotice();

	/**
	 * @Title: listNotice
	 * @Description: 根据关键字,查询字段,页码 展示公告
	 * @param Keyword
	 * @param type
	 *            字段类型
	 * @param pageIndex
	 * @return
	 * @return: List<NoticeDo>
	 */
	List<NoticeDo> listNotice(String Keyword, NoticeSearchTypeName type, long pageIndex);

	/**
	 * @Title: countNotice
	 * @Description:计算查询结果条数
	 * @param keyword
	 * @param type
	 * @return
	 * @return: long
	 */
	long countNotice(String keyword, NoticeSearchTypeName type);

	NoticeDo getNoticeById(long id);

	/**
	 * @Title: addNotice
	 * @Description: 增加公告
	 * @param notice
	 *            字段封装到实体类中
	 * @return: void
	 */
	void addNotice(NoticeDo notice);

	/**
	 * @Title: updateNotice
	 * @Description: 更新公告
	 * @param notice
	 * @return: void
	 */
	void updateNotice(NoticeDo notice);

	/**
	 * @Title: deleteNotice
	 * @Description: 根据id删除
	 * @param id
	 * @return: void
	 */
	void deleteNotice(long id);
}
