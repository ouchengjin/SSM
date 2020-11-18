package com.bjsxt.service.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjsxt.pojo.Account;
import com.bjsxt.service.AccountService;
import com.bjsxt.service.impl.AccountServicetImpl;
@WebServlet("/account.sxt")
public class AccountServlet extends HttpServlet{
	private AccountService as= new AccountServicetImpl();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		Account accOut = new Account();
		Account accIn= new Account();
		accOut.setId(Integer.parseInt(req.getParameter("outId")));
		accOut.setPwd(req.getParameter("pwd"));
		accOut.setBalance(Double.parseDouble(req.getParameter("balance")));
		
		accIn.setId(Integer.parseInt(req.getParameter("inId")));
		accIn.setName(req.getParameter("name"));
		accIn.setBalance(Double.parseDouble(req.getParameter("balance")));
		int index = as.transfer(accOut, accIn);
		String msg = "";
		switch (index) {
		case AccountService.SUCCESS:
			resp.sendRedirect("log.sxt");
			return;
		case AccountService.BALANCE_NOT_ENOUGH:
			msg = "抱歉，余额不足，无法转账！";
			break;
		case AccountService.FAILED:
			msg = "转账失败";
			break;
		case AccountService.ID_NAME_NOT_MATCHED:
			msg = "账号姓名不匹配，请核对！";
			break;
		case AccountService.ID_PWD_NOT_MATCHED:
			msg = "sorry，密码错误或账号不存在，请核对！";
			break;
		}
		
		//出现问题时才执行的后续操作
		req.setAttribute("msg", msg);
		req.getRequestDispatcher("/error.jsp").forward(req, resp);
		
	}
}
