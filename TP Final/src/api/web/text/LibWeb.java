package api.web.text;

import javax.servlet.http.HttpServletRequest;

public class LibWeb {

	public static String getParameter(HttpServletRequest req, String param) {
		String requestParam = req.getParameter(param);
		return (requestParam==null)?"":requestParam;
	}
}
