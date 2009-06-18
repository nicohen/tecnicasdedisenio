package admin.keys.views;

import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import api.web.cache.HtmlCache;
import api.web.mvc.view.BackEndHtmlView;
import api.web.text.LibTxt;

public class AdminKeyGeneratorSavedView extends BackEndHtmlView {

	public AdminKeyGeneratorSavedView(HttpServletRequest req,
			HttpServletResponse res, HashMap<String, Object> requestAttributes,
			ServletContext servletContext,
			HashMap<String, Object> requestParameters) throws Exception {
		super(req, res, requestAttributes, servletContext, requestParameters);

	}

	private List<String>keys;
	
	
	public List<String> getKeys() {
		return keys;
	}

	public void setKeys(List<String> keys) {
		this.keys = keys;
	}

	@Override
	protected String getAdminName() {
		// TODO Auto-generated method stub
		return "Generador automatico de claves";
	}

	@Override
	protected String getContent() {
		String html = HtmlCache.getHtml(relativePath, "./admin/keys/KeyGeneratorSaved");
		
		html = LibTxt.replace(html, "##KEYS_LIST##", getKeysList());
		html = LibTxt.replace(html,"##KEYS_VALUE##",""+Integer.parseInt((String)requestParameters.get("keys_value")));
		
		return html;
	}

	private String getKeysList() {
		StringBuffer sb = new StringBuffer();
		
		for (String key : keys){
			sb.append(key);
			sb.append("<br>");
		}
		return sb.toString();
	}

}
