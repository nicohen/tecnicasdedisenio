package api.web.text;

import javax.servlet.http.HttpServletRequest;

public class LibWeb {

	public static String getParameter(HttpServletRequest request, String param) {
		String requestParam = request.getParameter(param);
		return (requestParam==null)?"":requestParam;
	}
}
