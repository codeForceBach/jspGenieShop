package com.genieShop.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CatalogServlet
 */
@WebServlet(urlPatterns = "/CatalogServlet", asyncSupported = true)
public class CatalogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CatalogServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.getWriter().append(request.getParameter("name"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AsyncContext asyncContext = request.startAsync();
		asyncContext.start(new Runnable() {

			@Override
			public void run() {
				
				try {
					Thread.sleep(5000);
					System.out.println("Print the response");
					System.out.println("Reponse returned by: " + Thread.currentThread().getName());
					returnResponse(request, response);
					asyncContext.complete();

				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		});
		
		System.out.println("Initial Request: " + Thread.currentThread().getName());	
		
	}
	
	
	private void returnResponse(HttpServletRequest request, HttpServletResponse response) throws IOException {
	
		//doGet(request, response);
		//pull the String values from request and assign to String var
		String name = request.getParameter("name");
		String manufacturer = request.getParameter("manufacturer");
		String sku = request.getParameter("sku");
		//String id = request.getParameter("id");
		
		//additem to catalog
		Catalog.addItem(new CatalogItem(name, manufacturer, sku));
		
		response.setHeader("header", "headeValue");
		response.addCookie(new Cookie("cookie", "cookieValue"));
		
		//generate response body of dynamic contents
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head></head>");
		out.println("<body>");
		out.println("<table>");
		for(CatalogItem item:Catalog.getItems()) {
			out.println("<tr>");
			out.println("<td>");
			out.print(item.getName());
			out.println("</td>");
			out.println("</tr>");
		}
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
	}

}
