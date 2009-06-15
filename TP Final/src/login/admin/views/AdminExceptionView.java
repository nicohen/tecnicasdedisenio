package login.admin.views;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import api.web.mvc.view.BackEndHtmlView;

public class AdminExceptionView extends BackEndHtmlView {

	public AdminExceptionView(HttpServletRequest req, HttpServletResponse res,
			HashMap<String, Object> requestAttributes,
			ServletContext servletContext,
			HashMap<String, Object> requestParameters) throws Exception {
		super(req, res, requestAttributes, servletContext, requestParameters);
	}

	private Exception adminException;
	
	public Exception getAdminException() {
		return adminException;
	}

	public void setAdminException(Exception adminException) {
		this.adminException = adminException;
	}

	@Override
	protected String getContent() {

		StringBuffer out = new StringBuffer();
		out.append(adminException.getMessage());
		out.append("<!-- STACK: \n");
		out.append(formatException());
		out.append("-->");
		
		return out.toString();
	}

	private String formatException() {
			if (adminException != null) {
				
				StringWriter sw = new StringWriter();
				PrintWriter pw = new PrintWriter(sw, true);
	

				adminException.printStackTrace(pw);
				pw.flush();
				sw.flush();
	
				return sw.toString();
			} else {
				return "";
			}
	}

	@Override
	protected String getAdminName() {
		// TODO Auto-generated method stub
		return "Ingreso al administrador";
	}

}
