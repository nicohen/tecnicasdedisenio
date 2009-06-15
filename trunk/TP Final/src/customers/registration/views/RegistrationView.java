package customers.registration.views;

import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import api.web.cache.HtmlCache;
import api.web.mvc.view.HtmlView;
import api.web.text.LibTxt;


public class RegistrationView extends HtmlView {

	
	public RegistrationView(HttpServletRequest req, HttpServletResponse res,
			HashMap<String, Object> requestAttributes, ServletContext servletContext, HashMap<String,Object> requestParameters) throws Exception {
		super(req, res, requestAttributes, servletContext,requestParameters);
		
	}

	@Override
	protected void doHtmlBody() {
		String html = HtmlCache.getHtml(relativePath,"registration/RegistrationView");
		String urlRedir = (String)requestParameters.get("urlredir"); 
		if (urlRedir == null || urlRedir.length()==0){
			urlRedir = req.getRequestURI();

			String queryString = req.getQueryString();
			if (queryString != null && queryString.length()>0){
				urlRedir+="?"+ queryString;
			}
		}
		
		if(requestParameters.get("errors")!=null)
			LibTxt.replace(html, "##USER##",(String) requestParameters.get("user"));
		else
			LibTxt.replace(html, "##USER##","");
		
		if(requestParameters.get("errors")!=null)
			LibTxt.replace(html, "##PASS##",(String) requestParameters.get("pass"));
		else
			LibTxt.replace(html, "##PASS##","");
		
		if(requestParameters.get("errors")!=null)
			LibTxt.replace(html, "##PASS2##",(String) requestParameters.get("pass2"));
		else
			LibTxt.replace(html, "##PASS2##","");
		
		if(requestParameters.get("errors")!=null)
			LibTxt.replace(html, "##TELEPHONE##",(String) requestParameters.get("telephone"));
		else
			LibTxt.replace(html, "##TELEPHONE##","");
		
		if(requestParameters.get("errors")!=null)
			LibTxt.replace(html, "##ADDRESS##",(String) requestParameters.get("address"));
		else
			LibTxt.replace(html, "##ADDRESS##","");
		
		if(requestParameters.get("errors")!=null)
			LibTxt.replace(html, "##DNI##",(String) requestParameters.get("dni"));
		else
			LibTxt.replace(html, "##DNI##","");
		
		if(requestParameters.get("errors")!=null)
			LibTxt.replace(html, "##NAME##",(String) requestParameters.get("name"));
		else
			LibTxt.replace(html, "##NAME##","");
		
		if(requestParameters.get("errors")!=null)
			LibTxt.replace(html, "##LASTNAME##",(String) requestParameters.get("lastname"));
		else
			LibTxt.replace(html, "##LASTNAME##","");
		
		if(requestParameters.get("errors")!=null)
			LibTxt.replace(html, "##EMAIL##",(String) requestParameters.get("email"));
		else
			LibTxt.replace(html, "##EMAIL##","");
		
		html= LibTxt.replace(html, "##ERRORS##",(String) requestParameters.get("errors"));
			html = LibTxt.replace(html,"##REDIR##" , "/LaRematada/Home");
		
		out.println(html);
	}

}
