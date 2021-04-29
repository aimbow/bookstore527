package com.xx19.wyb;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.File;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet({ "/RegisterServlet", "/reg.do" })
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("utf-8");
		
		SmartUpload su = new SmartUpload();
		ServletConfig sc = this.getServletConfig();
		su.initialize(sc, request, response);
		
		try {
			su.upload();
			PrintWriter out = response.getWriter();
			File sf = su.getFiles().getFile(0);
			String name = sf.getFileName();
			
			Date now = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMddhhmmss");
			//System.out.print(sdf.format(now));
			String fname = sdf.format(now) + " " + sf.getFileExt();
			SimpleDateFormat sdf2 = new SimpleDateFormat("YYYY");
			
			java.io.File fdir = new File(
					request.getSession().getServletContext().getRealPath("/")
					+ "/upload/" + sdf2.format(now));
			
			sf.saveAs("/"+sf.getFieldName());
			
			out.print("<html><head><meta charset='utf-8'></head>");
			out.print("<body><a href='/"+ request.getContextPath() + "/" +sf.getFieldName()+"'>下载</a></body></html>");
			
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SmartUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		String username = request.getParameter("uname");
		String userpass = request.getParameter("upass");
		String usergender = request.getParameter("gender");
		//获取兴趣数组
		String[] userinter = request.getParameterValues("interest");
		
		response.setCharacterEncoding("gbk");
		PrintWriter out = response.getWriter();
		
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("register.jsp");
		if((username.length()<8)||(username.length()>20)){
			out.print("用户名长度不符合要求");
		}
		rd.forward(request,response);
		/*String ipaddr = request.getRemoteAddr();
		out.print("IP地址为：" + ipaddr + "<br>");
		String header = request.getHeader("User-agent");
		out.print("注册成功！<br>用户名："+username+"<br>密码："+userpass+"<br>性别："+usergender);
		out.print("你的兴趣：");
		for(int i=0; i<userinter.length;i++){
			out.print(userinter[i] + "");
		}
		if(usergender.equals("male")){
			out.print("recomend you electronic product");
		}
		else{
			out.print("recomend you mac");
		}*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
