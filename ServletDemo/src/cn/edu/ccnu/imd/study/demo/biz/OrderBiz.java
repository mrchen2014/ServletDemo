package cn.edu.ccnu.imd.study.demo.biz;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import cn.edu.ccnu.imd.study.demo.common.DBConnection;
import cn.edu.ccnu.imd.study.demo.dao.OrderDao;
import cn.edu.ccnu.imd.study.demo.vo.OrderVo;

public class OrderBiz {
	/**
	 * 作者：神吹
	 * 作用：1.添加订餐订单
	 *      2.订餐定单列表
	 *      3.修改订餐定单
	 *      4.确认定单
	 *      5.定单处理完毕
	 *      6.定单查询
	 */
	//往数据库中添加定单
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
				System.out.println("数据库连接失败！");
			}
		
		}
		//修改定单
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
				System.out.println("数据库连接失败！");
			}
		
		}
//		修改定单状态
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
				System.out.println("数据库连接失败！");
			}
		
		}
		//获取定单列表
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
				System.out.println("数据库连接失败！");
			}
			return _l;
			}
		//获取一条定单
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
				System.out.println("数据库连接失败！");
			}
			return vo;
			}
	 
		//删除定单
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
				System.out.println("数据库连接失败！");
			}
			return vo;
			}
}
