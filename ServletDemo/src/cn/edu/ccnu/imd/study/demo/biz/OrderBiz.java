package cn.edu.ccnu.imd.study.demo.biz;

import java.util.ArrayList;
import java.util.List;

import cn.edu.ccnu.imd.study.demo.dao.OrderDao;
import cn.edu.ccnu.imd.study.demo.vo.OrderVo;

public class OrderBiz {
	/**
	 * ���ߣ��� ���ã�1.��Ӷ��Ͷ��� 2.���Ͷ����б� 3.�޸Ķ��Ͷ��� 4.ȷ�϶��� 5.����������� 6.������ѯ
	 */
	// �����ݿ�����Ӷ���
	public void addOrder(OrderVo vo) {
		OrderDao dao = new OrderDao();
		dao.insert(vo);
	}

	// �޸Ķ���
	public void updateOrder(OrderVo vo) {
		OrderDao dao = new OrderDao();
		dao.update(vo);
	}

	// �޸Ķ���״̬
	public void changeOrder(OrderVo vo) {
		OrderDao dao = new OrderDao();
		dao.updateState(vo);
	}

	// ��ȡ�����б�
	public List getAllOrder(String sql) {
		List _l = new ArrayList();
		OrderDao dao = new OrderDao();
		return _l = dao.findbyAll(sql);
	}

	// ��ȡһ������
	public OrderVo getAOrder(OrderVo vo) {
		OrderDao dao = new OrderDao();
		return vo = dao.findbykey(vo);
	}

	// ɾ������
	public void delOrder(OrderVo vo) {
		OrderDao dao = new OrderDao();
		dao.delete(vo);
	}
}
