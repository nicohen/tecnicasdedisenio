package admin.auction.views;

import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import api.web.cache.HtmlCache;
import api.web.mvc.view.BackEndHtmlView;
import api.web.text.LibTxt;

public class AdminPublishAuctionFormView extends BackEndHtmlView {

	private String errors = "";
	private String htmlTemplate = "AuctionForm";
	
	public void setHtmlTemplate(String tpl){
		this.htmlTemplate = tpl;
	}
	public String getErrors() {
		return errors;
	}

	public void setErrors(String errors) {
		this.errors = errors;
	}

	public AdminPublishAuctionFormView(HttpServletRequest req,
			HttpServletResponse res, HashMap<String, Object> requestAttributes,
			ServletContext servletContext,
			HashMap<String, Object> requestParameters) throws Exception {
		super(req, res, requestAttributes, servletContext, requestParameters);
		
	}

	@Override
	protected String getAdminName() {
		// TODO Auto-generated method stub
		return "Alta de nuevo remate";
	}

	@Override
	protected String getContent() {
		String html = HtmlCache.getHtml(relativePath, "./admin/auction/"+htmlTemplate);
		
		String title = (String)requestParameters.get("title");
		String auctionType = (String)requestParameters.get("auction_type");
		String initValue = (String)requestParameters.get("price");

		
		html = LibTxt.replaceAll(html, "##TITLE_VALUE##", title!=null?title:"");
		html = LibTxt.replace(html, "value=\""+auctionType+"\"", "value=\""+auctionType+"\" CHECKED");
		html = LibTxt.replaceAll(html, "##AUCTION_TYPE##", auctionType!=null?auctionType:"");
		html = LibTxt.replaceAll(html, "##PRICE##", initValue!=null?initValue:"");
		html = LibTxt.replace(html, "##ERRORS##", errors);
		
		
		return html;
	}

}
