package apps;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Fetch extends HttpServlet implements FetchInt {
	String url;
	HttpServletResponse resp;
	HttpServletRequest req;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		url=req.getParameter("url");
		resp.getWriter().write(url);
		this.resp=resp;
		this.req=req;
		FetchUrl f=new FetchUrl(this);
		f.fetchurl(url);
	}

	@Override
	public void publishresult(int tot_num_iss, int num_24, int num_24_7, int num_more7) 
	{try {
		PrintWriter out = resp.getWriter(  ); 
		//resp.setContentType("text/html"); 
		//resp.sendRedirect("table");
		System.out.println(tot_num_iss);
		req.setAttribute("total",tot_num_iss);
		req.setAttribute("total24",num_24);
		req.setAttribute("total247",num_24_7);
		req.setAttribute("total7",num_more7);
		req.getRequestDispatcher("table").forward(req, resp);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ServletException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		// TODO Auto-generated method stub
		
	}

	
	
	

}
