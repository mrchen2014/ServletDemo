package cn.edu.ccnu.imd.study.demo.dao;
import java.sql.*;
import java.util.*;

import cn.edu.ccnu.imd.study.demo.vo.OrderVo;

public class OrderDao {
	
	public OrderVo findbykey(Connection _conn, OrderVo vo)
	{
		//定义 存放SQL语句的 StringBuffer
		StringBuffer sbSQL = null;
		//定义 PreparedStatement
		PreparedStatement ps = null;
		//定义数据库链接
		Connection conn = null;
		ResultSet rs=null;
		try
		{
			conn = _conn;
			//拼写sql
			sbSQL = new StringBuffer();
			sbSQL.append(" select * from  Orderx  where ");
			sbSQL.append(" id = ?");
			//获得 数据库 prepareStatement
			ps = conn.prepareStatement(sbSQL.toString());
			int nIndex = 1;
			ps.setLong(nIndex++, vo.getId());

			
			
			//执行SQL
			rs = ps.executeQuery();
			while(rs.next()){
				OrderVo  vo1= new OrderVo();
				
				vo1.setUserid(rs.getString("userid"));
				vo1.setState(rs.getShort("state"));
				vo1.setTotal(rs.getFloat("total"));
				vo1.setNumbers(rs.getInt("numbers"));
				vo1.setPrice(rs.getFloat("price"));
				vo1.setName(rs.getString("name"));
				vo1.setId(rs.getInt("id"));

				vo=vo1;
				
			}
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			try
			{
				//关闭 ps
				if (ps != null)
				{
					ps.close();
					ps = null;
				}
			}
			catch (Exception ex)
			{
				ex.printStackTrace();
			}
		}
		return vo;
	}

 
public List findbyAll(Connection _conn, String strSql)
	{
		Vector v = new Vector();
		//定义 存放SQL语句的 StringBuffer
		StringBuffer sbSQL = null;
		//定义 PreparedStatement
		PreparedStatement ps = null;
		//定义数据库链接
		Connection conn = null;
		ResultSet rs=null;
		try
		{
			conn = _conn;
			sbSQL = new StringBuffer();
			sbSQL.append("select * from  Orderx  where  "); 
			sbSQL.append(strSql); 
			ps = conn.prepareStatement(sbSQL.toString());
			//执行SQL
			rs = ps.executeQuery();
			while(rs.next()){
				OrderVo vo1= new OrderVo();

				vo1.setUserid(rs.getString("userid"));
				vo1.setState(rs.getShort("state"));
				vo1.setTotal(rs.getFloat("total"));
				vo1.setNumbers(rs.getInt("numbers"));
				vo1.setPrice(rs.getFloat("price"));
				vo1.setName(rs.getString("name"));
				vo1.setId(rs.getInt("id"));

				v.addElement(vo1);
			}
			 
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			try
			{
				//关闭 ps
				if (ps != null)
				{
					ps.close();
					ps = null;
				}
			}
			catch (Exception ex)
			{
				ex.printStackTrace();
			}
		}
		return v;
	}

public void delete(Connection _conn, OrderVo vo)
	{
		//定义 存放SQL语句的 StringBuffer
		StringBuffer sbSQL = null;
		//定义 PreparedStatement
		PreparedStatement ps = null;
		//定义数据库链接
		Connection conn = null;
		try
		{
			//将obj强制转换为con
			conn = _conn;
			//拼写sql
			sbSQL = new StringBuffer();
			sbSQL.append(" delete from  Orderx  where ");
			sbSQL.append("id=?");
			//获得 数据库 prepareStatement
			ps = conn.prepareStatement(sbSQL.toString());
			int nIndex = 1;
			ps.setLong(nIndex++, vo.getId());

			//执行SQL
			ps.executeUpdate();
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			try
			{
				//关闭 ps
				if (ps != null)
				{
					ps.close();
					ps = null;
				}
			}
			catch (Exception ex)
			{
				ex.printStackTrace();
			}
		}
	}

public void insert(Connection _conn, OrderVo vo) {
	 
		// 定义 存放SQL语句的 StringBuffer
		StringBuffer sbSQL = null;
		// 定义 PreparedStatement
		PreparedStatement ps = null;
		// 定义数据库链接
		Connection conn = null;
		try {
			// 将obj强制转换为con
			conn = _conn;
			// 拼写sql
			sbSQL = new StringBuffer();
			sbSQL.append("insert into   Orderx   ( userid  ,state ,total ,numbers ,price ,name ) ");
			sbSQL.append(" values (?,?,?,?,?,?)  ");
			// 定义新增代码的 ID
			// 获得 数据库 prepareStatement
			ps = conn.prepareStatement(sbSQL.toString());
			//System.out.println(sbSQL.toString());
			/*
			if(vo.get()==0){
				String _sql = "select max() from Order";
				Statement _st=_conn.createStatement();
				ResultSet rs = _st.executeQuery(_sql);
				while(rs.next()){
					vo.set(rs.getInt(1)+1);
				}
			}*/
			// 定义参数递增变量
			int nIndex = 1;
			
			ps.setString(nIndex++, vo.getUserid());
			
			ps.setShort(nIndex++, vo.getState());
			ps.setFloat(nIndex++, vo.getTotal());
			ps.setInt(nIndex++, vo.getNumbers());
			ps.setFloat(nIndex++, vo.getPrice());
			ps.setString(nIndex++, vo.getName());
		 

			// 执行SQL
			ps.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
					ps = null;
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		 
	}
 
	

public void update(Connection _conn, OrderVo vo)
	{
		//定义 存放SQL语句的 StringBuffer
		StringBuffer sbSQL = null;
		//定义 PreparedStatement
		PreparedStatement ps = null;
		//定义数据库链接
		Connection conn = null;
		try
		{
			//将obj强制转换为con
			conn = _conn;
			//拼写sql
			sbSQL = new StringBuffer();
			sbSQL.append(
				"update   Orderx   set userid=? ,state=?,total=?,numbers=?,price=?,name=? where id=?");
			//sbSQL.append(" ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ");
			//获得 数据库 prepareStatement
			ps = conn.prepareStatement(sbSQL.toString());
			//定义参数递增变量			
			int nIndex = 1;
			ps.setString(nIndex++, vo.getUserid());
			ps.setShort(nIndex++, vo.getState());
			ps.setFloat(nIndex++, vo.getTotal());
			ps.setInt(nIndex++, vo.getNumbers());
			ps.setFloat(nIndex++, vo.getPrice());
			ps.setString(nIndex++, vo.getName());
			ps.setInt(nIndex++, vo.getId());
			//给SQL语句赋值
			//#sql=#
			//执行SQL
			ps.executeUpdate();
		}
		catch (Exception ex)
		{
			//在dao中发生异常默认为系统级异常,将其抛出
			ex.printStackTrace();
		}
		finally
		{
			try
			{
				//关闭 ps
				if (ps != null)
				{
					ps.close();
					ps = null;
				}
			}
			catch (Exception ex)
			{
				//在dao中发生异常默认为系统级异常,将其抛出
				ex.printStackTrace();
			}
		}
	}
//
public void updateState(Connection _conn, OrderVo vo)
{
	//定义 存放SQL语句的 StringBuffer
	StringBuffer sbSQL = null;
	//定义 PreparedStatement
	PreparedStatement ps = null;
	//定义数据库链接
	Connection conn = null;
	try
	{
		//将obj强制转换为con
		conn = _conn;
		//拼写sql
		sbSQL = new StringBuffer();
		sbSQL.append(
			"update  Orderx   set state=? where id=?");
		//sbSQL.append(" ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ");
		//获得 数据库 prepareStatement
		ps = conn.prepareStatement(sbSQL.toString());
		//定义参数递增变量			
		int nIndex = 1;
	    ps.setInt(nIndex++, vo.getState());
	    ps.setLong(nIndex++, vo.getId());
		//给SQL语句赋值
		//#sql=#
		//执行SQL
		ps.executeUpdate();
	}
	catch (Exception ex)
	{
		//在dao中发生异常默认为系统级异常,将其抛出
		ex.printStackTrace();
	}
	finally
	{
		try
		{
			//关闭 ps
			if (ps != null)
			{
				ps.close();
				ps = null;
			}
		}
		catch (Exception ex)
		{
			//在dao中发生异常默认为系统级异常,将其抛出
			ex.printStackTrace();
		}
	}
}
}
