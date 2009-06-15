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
		String user = (String) requestParameters.get("user");
		String pass = (String) requestParameters.get("pass");
		String pass2 = (String) requestParameters.get("pass2");
		String telephone = (String) requestParameters.get("telephone");
		String address = (String) requestParameters.get("address");
		String dni = (String) requestParameters.get("dni");
		String name = (String) requestParameters.get("name");
		String lastname = (String) requestParameters.get("lastName");
		String email = (String) requestParameters.get("email");
		String errors = (String) requestParameters.get("errors");
		
//		if(requestParameters.get("errors")!=null){
			html = LibTxt.replace(html, "##USER##",user!=null?user:"");
			html = LibTxt.replace(html, "##PASS##",pass!=null?pass:"");
			html = LibTxt.replace(html, "##PASS2##",pass2!=null?pass2:"");
			html = LibTxt.replace(html, "##TELEPHONE##",telephone!=null?telephone:"");
			html = LibTxt.replace(html, "##ADDRESS##",address!=null?address:"");
			html = LibTxt.replace(html, "##DNI##",dni!=null?dni:"");
			html = LibTxt.replace(html, "##NAME##",name!=null?name:"");
			html = LibTxt.replace(html, "##LASTNAME##",lastname!=null?lastname:"");
			html = LibTxt.replace(html, "##EMAIL##",email!=null?email:"");
			html= LibTxt.replace(html, "##ERRORS##",errors!=null?errors:"");
			
//		} else {
//			html = LibTxt.replace(html, "##USER##","");
//			html = LibTxt.replace(html, "##PASS##","");
//			html = LibTxt.replace(html, "##PASS2##","");
//			html = LibTxt.replace(html, "##TELEPHONE##","");
//			html = LibTxt.replace(html, "##ADDRESS##","");
//			html = LibTxt.replace(html, "##DNI##","");
//			html = LibTxt.replace(html, "##NAME##","");
//			html = LibTxt.replace(html, "##LASTNAME##","");
//			html = LibTxt.replace(html, "##EMAIL##","");
//			html= LibTxt.replace(html, "##ERRORS##","");
//		
//		}
		
		html = LibTxt.replace(html,"##REDIR##" , "/LaRematada/Home");
		
		out.println(html);
	}

}
