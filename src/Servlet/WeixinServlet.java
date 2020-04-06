package Servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.CheckUtil;

public class WeixinServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String signature =req.getParameter("signature");
		String timestamp =req.getParameter("timestamp");
		String nonce =req.getParameter("nonce");
		String echostr=req.getParameter("echostr");
		PrintWriter out =resp.getWriter();
		out.print(echostr);
		out.flush();
		out.close();
		out =null;
	}
        
}