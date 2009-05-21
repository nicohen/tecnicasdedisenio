package api.web.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class AbstractHtmlView {
	
	HttpServletRequest req;
	HttpServletResponse res;

	Model model;
	
	protected void setModel(Model model){
		this.model = model;
	}
	public AbstractHtmlView(HttpServletRequest req, HttpServletResponse res) {
		this.req = req;
		this.res = res;
	}
	protected void execute(){
		doHttpHeader();
		doHtmlHeader();
		doHtmlMenu();
		doHtmlBody();
		doHtmlFooter();
	}
	
	protected void doHttpHeader(){
		setContentType();
		setCacheControl();
	}
	protected abstract void doHtmlHeader();
	protected abstract void doHtmlMenu();
	protected abstract void doHtmlBody();
	protected abstract void doHtmlFooter();
	
	protected void setContentType(){
		res.setContentType("text/html");
	}
	protected void setCacheControl(){
		res.setHeader("Cache-control", "no-cache");
	}
}
