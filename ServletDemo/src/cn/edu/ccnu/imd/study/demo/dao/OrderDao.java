package cn.edu.ccnu.imd.study.demo.dao;

import java.sql.*;
import java.util.*;

import cn.edu.ccnu.imd.study.demo.common.DBConnection;
import cn.edu.ccnu.imd.study.demo.vo.OrderVo;

public class OrderDao {

	public OrderVo findbykey(OrderVo vo) {
		// ���� PreparedStatement
		PreparedStatement ps = null;
		// �������ݿ�����
		Connection conn = null;
		ResultSet rs = null;
		try {
			// �����ݿ�����
			DBConnection dbc = new DBConnection();
			if (dbc.getConnect()) {
				conn = dbc.getConn();
			}
			// ƴдsql
			StringBuffer sbSQL = new StringBuffer();
			sbSQL.append(" select * from  Orderx  where ");
			sbSQL.append(" id = ?");
			// ��� ���ݿ� prepareStatement
			ps = conn.prepareStatement(sbSQL.toString());
			int nIndex = 1;
			ps.setLong(nIndex++, vo.getId());

			// ִ��SQL
			rs = ps.executeQuery();
			while (rs.next()) {
				OrderVo vo1 = new OrderVo();

				vo1.setUserid(rs.getString("userid"));
				vo1.setState(rs.getShort("state"));
				vo1.setTotal(rs.getFloat("total"));
				vo1.setNumbers(rs.getInt("numbers"));
				vo1.setPrice(rs.getFloat("price"));
				vo1.setName(rs.getString("name"));
				vo1.setId(rs.getInt("id"));

				vo = vo1;

			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				// �ر� ps
				if (ps != null) {
					ps.close();
					ps = null;
					conn.close();
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return vo;
	}

	public List findbyAll(String strSql) {
		Vector v = new Vector();
		// ���� PreparedStatement
		PreparedStatement ps = null;
		// �������ݿ�����
		Connection conn = null;
		ResultSet rs = null;
		try {
			// �����ݿ�����
			DBConnection dbc = new DBConnection();
			if (dbc.getConnect()) {
				conn = dbc.getConn();
			}
			StringBuffer sbSQL = new StringBuffer();
			sbSQL.append("select * from  Orderx  where  ");
			sbSQL.append(strSql);
			ps = conn.prepareStatement(sbSQL.toString());
			// ִ��SQL
			rs = ps.executeQuery();
			while (rs.next()) {
				OrderVo vo1 = new OrderVo();

				vo1.setUserid(rs.getString("userid"));
				vo1.setState(rs.getShort("state"));
				vo1.setTotal(rs.getFloat("total"));
				vo1.setNumbers(rs.getInt("numbers"));
				vo1.setPrice(rs.getFloat("price"));
				vo1.setName(rs.getString("name"));
				vo1.setId(rs.getInt("id"));

				v.addElement(vo1);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				// �ر� ps
				if (ps != null) {
					ps.close();
					ps = null;
					conn.close();
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return v;
	}

	public void delete(OrderVo vo) {
		// ���� PreparedStatement
		PreparedStatement ps = null;
		// �������ݿ�����
		Connection conn = null;
		try {
			// �����ݿ�����
			DBConnection dbc = new DBConnection();
			if (dbc.getConnect()) {
				conn = dbc.getConn();
			}
			// ƴдsql
			StringBuffer sbSQL = new StringBuffer();
			sbSQL.append(" delete from  Orderx  where ");
			sbSQL.append("id=?");
			// ��� ���ݿ� prepareStatement
			ps = conn.prepareStatement(sbSQL.toString());
			int nIndex = 1;
			ps.setLong(nIndex++, vo.getId());

			// ִ��SQL
			ps.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				// �ر� ps
				if (ps != null) {
					ps.close();
					ps = null;
					conn.close();
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	public void insert(OrderVo vo) {
		// ���� PreparedStatement
		PreparedStatement ps = null;
		// �������ݿ�����
		Connection conn = null;
		try {
			// �����ݿ�����
			DBConnection dbc = new DBConnection();
			if (dbc.getConnect()) {
				conn = dbc.getConn();
			}
			// ƴдsql
			StringBuffer sbSQL = new StringBuffer();
			sbSQL.append("insert into   Orderx   ( userid  ,state ,total ,numbers ,price ,name ) ");
			sbSQL.append(" values (?,?,?,?,?,?)  ");
			// ������������� ID
			// ��� ���ݿ� prepareStatement
			ps = conn.prepareStatement(sbSQL.toString());
			// ���������������
			int nIndex = 1;

			ps.setString(nIndex++, vo.getUserid());
			ps.setShort(nIndex++, vo.getState());
			ps.setFloat(nIndex++, vo.getTotal());
			ps.setInt(nIndex++, vo.getNumbers());
			ps.setFloat(nIndex++, vo.getPrice());
			ps.setString(nIndex++, vo.getName());

			// ִ��SQL
			ps.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
					ps = null;
					conn.close();
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

	}

	public void update(OrderVo vo) {
		// ���� PreparedStatement
		PreparedStatement ps = null;
		// �������ݿ�����
		Connection conn = null;
		try {
			// �����ݿ�����
			DBConnection dbc = new DBConnection();
			if (dbc.getConnect()) {
				conn = dbc.getConn();
			}
			// ƴдsql
			StringBuffer sbSQL = new StringBuffer();
			sbSQL.append("update   Orderx   set userid=? ,state=?,total=?,numbers=?,price=?,name=? where id=?");
			// ��� ���ݿ� prepareStatement
			ps = conn.prepareStatement(sbSQL.toString());
			// ���������������
			int nIndex = 1;
			ps.setString(nIndex++, vo.getUserid());
			ps.setShort(nIndex++, vo.getState());
			ps.setFloat(nIndex++, vo.getTotal());
			ps.setInt(nIndex++, vo.getNumbers());
			ps.setFloat(nIndex++, vo.getPrice());
			ps.setString(nIndex++, vo.getName());
			ps.setInt(nIndex++, vo.getId());
			// ��SQL��丳ֵ
			// #sql=#
			// ִ��SQL
			ps.executeUpdate();
		} catch (Exception ex) {
			// ��dao�з����쳣Ĭ��Ϊϵͳ���쳣,�����׳�
			ex.printStackTrace();
		} finally {
			try {
				// �ر� ps
				if (ps != null) {
					ps.close();
					ps = null;
					conn.close();
				}
			} catch (Exception ex) {
				// ��dao�з����쳣Ĭ��Ϊϵͳ���쳣,�����׳�
				ex.printStackTrace();
			}
		}
	}

	//
	public void updateState(OrderVo vo) {
		// ���� PreparedStatement
		PreparedStatement ps = null;
		// �������ݿ�����
		Connection conn = null;
		try {
			// �����ݿ�����
			DBConnection dbc = new DBConnection();
			if (dbc.getConnect()) {
				conn = dbc.getConn();
			}
			// ƴдsql
			StringBuffer sbSQL = new StringBuffer();
			sbSQL.append("update  Orderx   set state=? where id=?");
			// ��� ���ݿ� prepareStatement
			ps = conn.prepareStatement(sbSQL.toString());
			// ���������������
			int nIndex = 1;
			ps.setInt(nIndex++, vo.getState());
			ps.setLong(nIndex++, vo.getId());
			// ��SQL��丳ֵ
			// #sql=#
			// ִ��SQL
			ps.executeUpdate();
		} catch (Exception ex) {
			// ��dao�з����쳣Ĭ��Ϊϵͳ���쳣,�����׳�
			ex.printStackTrace();
		} finally {
			try {
				// �ر� ps
				if (ps != null) {
					ps.close();
					ps = null;
					conn.close();
				}
			} catch (Exception ex) {
				// ��dao�з����쳣Ĭ��Ϊϵͳ���쳣,�����׳�
				ex.printStackTrace();
			}
		}
	}
}
