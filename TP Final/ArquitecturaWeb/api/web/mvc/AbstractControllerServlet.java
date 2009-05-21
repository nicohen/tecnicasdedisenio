package api.web.mvc;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class AbstractControllerServlet extends HttpServlet {

	private static final long serialVersionUID = -3285615036163153630L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException {
		doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		execute(request, response);
	}

	protected abstract void execute(HttpServletRequest request,
			HttpServletResponse response);

	public void service(HttpServletRequest request, HttpServletResponse response)
		throws ServletException {
		doPost(request, response);
	}

}
