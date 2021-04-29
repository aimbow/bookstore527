package com.xx19.wyb;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet({ "/LoginServlet", "/login.do" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = (String)request.getParameter("act");
		if(action.equals("in")){		
		boolean logsuc = false;
		}
		else {
			HttpSession session = request.getSession();
			session.invalidate();
			response.sendRedirect("index.jsp");
		}
	}
	
	private boolean checkUname(String un, String up) {
		String[] userlist = {"test01","guest","abcde","hello"};
		String[] passlist = {"123456","hello","abcde","hello"};
		for (int i=0; i<userlist.length;i++){
			if(userlist[i].equals(un) && passlist[i].equals(up)){
				logsuc = true;
				break;
			}
			
		}
		return logsuc;
	}
		
		private void login(HttpServletRequest request,
				HttpServletResponse response) throws ServletException,IOException {
			boolean logsuc = false;
		response.setCharacterEncoding("gbk");
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(1);
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("index.jsp");
		
		String username = request.getParameter("uname");
		String userpass = request.getParameter("upass");
		if(checkUname(username,userpass)) {
			session.setAttribute("myusername", username);
			//response.getWriter().append("登录成功！");
			String usersave = request.getParameter("usersave");
			Cookie cookie_name = new Cookie("username",username);
			Cookie cookie_pass = new Cookie("userpass",userpass);
			if("1".equals(usersave)) {
				//System.out.print("保存用户信息");
				cookie_name.setMaxAge(60*24*60);
				cookie_pass.setMaxAge(60*24*60);
			}else {
				//System.out.print("不保存");
				cookie_name.setMaxAge(0);
				cookie_pass.setMaxAge(0);
			}
			response.addCookie(cookie_name);
			response.addCookie(cookie_pass);
			request.setAttribute("status","登录成功！");
		}
		else {
			//response.getWriter().append("登录失败！");
			request.setAttribute("status","登录失败！");
		}
			rd.forward(request,response);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
