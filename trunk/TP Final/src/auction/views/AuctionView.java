package auction.views;

import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistence.AuctionPersistorImplementation;
import api.web.cache.HtmlCache;
import api.web.mvc.view.HtmlView;
import api.web.text.LibTxt;
import domain.auctions.IncrementalAuction;

public class AuctionView extends HtmlView {

	public AuctionView(HttpServletRequest req, HttpServletResponse res,
			HashMap<String, Object> requestAttributes,
			ServletContext servletContext,
			HashMap<String, Object> requestParameters) throws Exception {
		super(req, res, requestAttributes, servletContext, requestParameters);
	}

	@Override
	protected void doHtmlBody() {
		String html = HtmlCache.getHtml(relativePath, "auction/AuctionView");
		long auctionId = Long.parseLong((String) requestParameters
				.get("auctionId"));

		
		/*if("Y".equals(LibWeb.getParameter(req, "cargarProd"))) {
			Product p = new Product("Sony W50");
			VariationRateFunction vrf = new VariationRateFunction(null);
			IncrementalAuction ia = new IncrementalAuction(p,AuctionType.SINGLE,vrf,1);
			AuctionPersistor.getInstance().saveIncrementalAuction(ia);
		}*/
		IncrementalAuction auction = AuctionPersistorImplementation.getInstance().getIncrementalAuctionById(auctionId);

		html = LibTxt.replaceAll(html, "##AUCTION_ID##", "" + auctionId);
		html = LibTxt.replace(html, "##DESCRIPTION##", auction.getPrize().getDescription());
		html = LibTxt.replaceAll(html, "##POINTS##", "" + auction.getNextBidValue());

		out.println(html);

	}

}
