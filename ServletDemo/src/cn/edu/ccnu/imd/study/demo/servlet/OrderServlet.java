package cn.edu.ccnu.imd.study.demo.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.ccnu.imd.study.demo.biz.OrderBiz;
import cn.edu.ccnu.imd.study.demo.vo.OrderVo;

public class OrderServlet extends HttpServlet {
	private String method;
	private String url;
	private String path;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.path = request.getContextPath();
		this.url = this.path + "/servlets/Order.do?method=list";
		
		try {
			this.method = request.getParameter("method");
		} catch (Exception e) {
			this.method = "list";
		}
		OrderVo vo = new OrderVo();
		//根据method的不同选择不同的方法 测试commit
		switch (this.method) {
		// 定单列表
		case "list":
			this.getOrderList(request, response);
			request.getRequestDispatcher(this.url).forward(request, response);
			break;
		// 添加定单第一步，跳转到添加页面
		case "toAdd":
			this.url = "/WEB-INF/jsp/OrderAdd.jsp";
			request.getRequestDispatcher(this.url).forward(request, response);
			break;
		// 添加定单
		case "add":
			vo = this.getForm(request, response);
			this.addAOrder(vo);
			response.sendRedirect(this.url);
			break;
		// 修改定单第一步，跳转到修改页面
		case "toUpdate":
			this.updateOrder1(request, response);
			request.getRequestDispatcher(this.url).forward(request, response);
			break;
		// 修改定单第二步
		case "update":
			vo = this.getForm(request, response);
			this.updateOrder2(request, response, vo);
			response.sendRedirect(this.url);
			break;
		// 修改定单状态
		case "updateState":
			this.dealOrder(request, response);
			response.sendRedirect(this.url);
			break;
		// 删除定单
		case "delete":
			this.delOrder(request, response);
			response.sendRedirect(this.url);
			break;
		default:
			this.url = this.path + "/servlets/Order.do?method=list";
		}
	}

	// 获取表单列表
	void getOrderList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String sql = "1=1";
		OrderBiz biz = new OrderBiz();
		List _l = biz.getAllOrder(sql);

		request.setAttribute("OrderList", _l);
		this.url = "/WEB-INF/jsp/OrderList.jsp";
	}

	// 获取表单的植
	OrderVo getForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 定义变量取值
		float total = 0f;
		int numbers = 0;
		float price = 0f;
		short state = 0;
		int id = 0;

		// 取值
		String name = request.getParameter("name");
		String userid = request.getParameter("userid");
		String strtotal = request.getParameter("total");
		String strnumbers = request.getParameter("numbers");
		String strprice = request.getParameter("price");
		String strstate = request.getParameter("state");
		String strid = request.getParameter("id");

		try {
			if (null != strtotal && !"".equals(strtotal)) {
				total = Float.parseFloat(strtotal);
			}
			if (null != strnumbers && !"".equals(strnumbers)) {
				numbers = Integer.parseInt(strnumbers);
			}
			if (null != strprice && !"".equals(strprice)) {
				price = Float.parseFloat(strprice);
			}
			if (null != strstate && !"".equals(strstate)) {
				state = Short.parseShort(strstate);
			}
			if (null != strid && !"".equals(strid)) {
				id = Integer.parseInt(strid);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 创建VO实例
		OrderVo vo1 = new OrderVo();
		vo1.setUserid(userid);
		vo1.setState(state);
		vo1.setTotal(total);
		vo1.setNumbers(numbers);
		vo1.setPrice(price);
		vo1.setName(name);
		vo1.setId(id);
		return vo1;
	}

	// 添加定单
	void addAOrder(OrderVo vo) {
		// 创建BIZ
		OrderBiz ob = new OrderBiz();
		ob.addOrder(vo);
	}

	// 修改定单
	void updateOrder1(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 定义变量取值
		int id;
		try {
			id = Integer.parseInt(request.getParameter("id"));
		} catch (Exception e) {
			id = 0;
			System.out.println("获取ID失败！");
		}

		// 创建VO
		OrderVo vo = new OrderVo();
		vo.setId(id);
		// 创建BIZ
		OrderBiz biz = new OrderBiz();
		vo = biz.getAOrder(vo);
		// 储存入request
		request.setAttribute("OrderVo", vo);
		this.url = "/WEB-INF/jsp/OrderUpdate.jsp";
	}

	// 修改定单第2步
	void updateOrder2(HttpServletRequest request, HttpServletResponse response,
			OrderVo vo) throws ServletException, IOException {
		// 定义变量取值
		int id;
		try {
			id = Integer.parseInt(request.getParameter("id"));
		} catch (Exception e) {
			id = 0;
			System.out.println("获取ID失败！");
		}
		vo.setId(id);
		// 创建BIZ
		OrderBiz ob = new OrderBiz();
		ob.updateOrder(vo);
	}

	// 改变定单状态
	void dealOrder(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 定义变量取值
		int id;
		short state;
		try {
			id = Integer.parseInt(request.getParameter("id"));
		} catch (Exception e) {
			id = 0;
			System.out.println("获取ID失败！");
		}
		try {
			state = Short.parseShort(request.getParameter("state"));
		} catch (Exception e) {
			state = 4;
			System.out.println("获取state失败！");
		}
		OrderVo vo = new OrderVo();
		vo.setId(id);
		vo.setState(state);
		OrderBiz ob = new OrderBiz();
		ob.changeOrder(vo);
	}

	// 删除定单
	void delOrder(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 定义变量取值
		int id;

		try {
			id = Integer.parseInt(request.getParameter("id"));
		} catch (Exception e) {
			id = 0;
			System.out.println("获取ID失败！");
		}

		OrderVo vo = new OrderVo();
		vo.setId(id);

		OrderBiz ob = new OrderBiz();
		ob.delOrder(vo);
	}

}
