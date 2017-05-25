package cn.edu.ccnu.imd.study.demo.biz;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import cn.edu.ccnu.imd.study.demo.common.DBConnection;
import cn.edu.ccnu.imd.study.demo.dao.OrderDao;
import cn.edu.ccnu.imd.study.demo.vo.OrderVo;

public class OrderBiz {
	/**
	 * ���ߣ���
	 * ���ã�1.��Ӷ��Ͷ���
	 *      2.���Ͷ����б�
	 *      3.�޸Ķ��Ͷ���
	 *      4.ȷ�϶���
	 *      5.�����������
	 *      6.������ѯ
	 */
	//�����ݿ�����Ӷ���
		public void addOrder(OrderVo vo){
			DBConnection dbc=new DBConnection();
			if(dbc.getConnect()){
				Connection con =dbc.getConn();
				OrderDao dao = new OrderDao();
					dao.insert(con,vo);
					try{
						con.close();
					}catch(Exception ex){
						ex.printStackTrace();
					}		
			}else{
				System.out.println("���ݿ�����ʧ�ܣ�");
			}
		
		}
		//�޸Ķ���
		public void updateOrder(OrderVo vo){
			DBConnection dbc=new DBConnection();
			if(dbc.getConnect()){
				Connection con =dbc.getConn();
				OrderDao dao = new OrderDao();
					dao.update(con,vo);
					try{
						con.close();
					}catch(Exception ex){
						ex.printStackTrace();
					}		
			}else{
				System.out.println("���ݿ�����ʧ�ܣ�");
			}
		
		}
//		�޸Ķ���״̬
		public void changeOrder(OrderVo vo){
			DBConnection dbc=new DBConnection();
			if(dbc.getConnect()){
				Connection con =dbc.getConn();
				OrderDao dao = new OrderDao();
					dao.updateState(con,vo);
					try{
						con.close();
					}catch(Exception ex){
						ex.printStackTrace();
					}		
			}else{
				System.out.println("���ݿ�����ʧ�ܣ�");
			}
		
		}
		//��ȡ�����б�
		public List getAllOrder(String sql){
			List _l = new ArrayList();
			DBConnection dbc = new DBConnection();
			if(dbc.getConnect()){
				Connection conn = dbc.getConn();
				try{
					OrderDao dao = new OrderDao();
					_l=dao.findbyAll(conn,sql);
				}catch(Exception e){
					e.printStackTrace();
				}finally{
					try{
						conn.close();
					}catch(Exception ex){
						ex.printStackTrace();
					}
				}
			}else{
				System.out.println("���ݿ�����ʧ�ܣ�");
			}
			return _l;
			}
		//��ȡһ������
		public OrderVo getAOrder(OrderVo vo){
			DBConnection dbc = new DBConnection();
			if(dbc.getConnect()){
				Connection conn = dbc.getConn();
				try{
					OrderDao dao = new OrderDao();
				vo=dao.findbykey(conn,vo);
				}catch(Exception e){
					e.printStackTrace();
				}finally{
					try{
						conn.close();
					}catch(Exception ex){
						ex.printStackTrace();
					}
				}
			}else{
				System.out.println("���ݿ�����ʧ�ܣ�");
			}
			return vo;
			}
	 
		//ɾ������
		public OrderVo delOrder(OrderVo vo){
			DBConnection dbc = new DBConnection();
			if(dbc.getConnect()){
				Connection conn = dbc.getConn();
				try{
					OrderDao dao = new OrderDao();
					 dao.delete(conn,vo);
				}catch(Exception e){
					e.printStackTrace();
				}finally{
					try{
						conn.close();
					}catch(Exception ex){
						ex.printStackTrace();
					}
				}
			}else{
				System.out.println("���ݿ�����ʧ�ܣ�");
			}
			return vo;
			}
}
