package web.api.mvc.view;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.api.mvc.model.Model;
import web.api.writers.HtmlWriter;

public abstract class WebView implements View {
	protected HttpServletRequest req;
	protected HttpServletResponse res;
	protected HashMap<String, Object> requestAttributes;

	protected HtmlWriter out;
	
	protected Model model;

	protected void setModel(Model model){
		this.model = model;
	}

	public WebView(HttpServletRequest req, HttpServletResponse res,
			HashMap<String,Object> requestAttributes,HashMap<String,Object> requestParameters) throws Exception {
		this.req = req;
		this.res = res;
		this.requestAttributes = requestAttributes;
		this.out = new HtmlWriter(res);
	}

	public void execute() throws Exception {
		doHttpHeader();
		htmlOpen();
		htmlHeaderOpen();
		doHtmlHeader();
		htmlHeaderClose();
		bodyOpen();
		doHtmlMenu();
		doHtmlBody();
		doHtmlFooter();
		bodyClose();
		htmlClose();
		
		writeHtml();
	}
	
	private void htmlOpen() {
		out.println("<html>");
		
	}
	private void htmlClose() {
		out.println("</html>");
		
	}
	private void htmlHeaderClose() {
		out.println("</header>");
		
	}

	private void htmlHeaderOpen() {
		out.println("<header>");
	}

	private void bodyClose() {
		out.println("</body>");
		
	}

	private void bodyOpen() {
		out.println("<body>");		
	}

	private void writeHtml() {
		out.flush();		
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
