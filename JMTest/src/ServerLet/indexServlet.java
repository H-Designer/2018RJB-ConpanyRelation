package ServerLet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import Mes.guquanInfo;
import Mes.information;
import Mes.touziInfo;
import Mes.yisiInfo;
import Mes.qiyeInfo;
import dao.guquan;
import dao.qiye;
import dao.search;
import dao.touzi;
import dao.yisi;
/**
 * Servlet implementation class searchServlet
 */
@WebServlet("/searchServlet")
public class indexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public indexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String  search=request.getParameter("search");
		HttpSession session = request.getSession();
		
		//基本信息情况
		List<information> needBeans = new ArrayList<information>();
		search sear=new search();
		needBeans=sear.listNeed(search);
		request.setAttribute("needBeans", needBeans);
		session.setAttribute("needBeans", needBeans);

		//System.out.println(needBeans);
	
		
		
		//股权结构详情
		List<guquanInfo> needBeanG = new ArrayList<guquanInfo>();
		//System.out.println(search);
		guquan guquan=new guquan();
		needBeanG=guquan.listNeed(search);
		session.setAttribute("needBeanG", needBeanG);
		request.setAttribute("needBeanG", needBeanG);
		//System.out.println(needBeanG);
		
		//投资族谱情况
		List<touziInfo> needBeanT = new ArrayList<touziInfo>();
		//System.out.println(search);
		touzi touzi=new touzi();
		needBeanT=touzi.listNeed(search);
		session.setAttribute("needBeanT", needBeanT);
		//System.out.println(needBeanT);
		
		//企业族谱情况
		List<qiyeInfo> needBeanQ = new ArrayList<qiyeInfo>();
		//System.out.println(search);
		qiye qiye=new qiye();
		needBeanQ=qiye.listNeed(search);
		session.setAttribute("needBeanQ", needBeanQ);
		//System.out.println(needBeanQ);
	
		//疑似关系情况
		List<yisiInfo> needBeanY = new ArrayList<yisiInfo>();
		System.out.println(search);
		yisi yisi=new yisi();
		needBeanY=yisi.listNeed(search);
		session.setAttribute("needBeanY", needBeanY);
		System.out.println(needBeanY);

		doGet(request, response);
		request.getRequestDispatcher("/JBxinxi.jsp").forward(request, response);	}

}
