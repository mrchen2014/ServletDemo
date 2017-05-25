package cn.edu.ccnu.imd.study.demo.biz;

import java.util.ArrayList;
import java.util.List;

import cn.edu.ccnu.imd.study.demo.dao.OrderDao;
import cn.edu.ccnu.imd.study.demo.vo.OrderVo;

public class OrderBiz {
	/**
	 * 作者：神吹 作用：1.添加订餐订单 2.订餐定单列表 3.修改订餐定单 4.确认定单 5.定单处理完毕 6.定单查询
	 */
	// 往数据库中添加定单
	public void addOrder(OrderVo vo) {
		OrderDao dao = new OrderDao();
		dao.insert(vo);
	}

	// 修改定单
	public void updateOrder(OrderVo vo) {
		OrderDao dao = new OrderDao();
		dao.update(vo);
	}

	// 修改定单状态
	public void changeOrder(OrderVo vo) {
		OrderDao dao = new OrderDao();
		dao.updateState(vo);
	}

	// 获取定单列表
	public List getAllOrder(String sql) {
		List _l = new ArrayList();
		OrderDao dao = new OrderDao();
		return _l = dao.findbyAll(sql);
	}

	// 获取一条定单
	public OrderVo getAOrder(OrderVo vo) {
		OrderDao dao = new OrderDao();
		return vo = dao.findbykey(vo);
	}

	// 删除定单
	public void delOrder(OrderVo vo) {
		OrderDao dao = new OrderDao();
		dao.delete(vo);
	}
}
