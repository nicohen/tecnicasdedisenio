package auction.views;

import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import api.web.cache.HtmlCache;
import api.web.mvc.view.HtmlView;
import api.web.text.LibTxt;
import dao.mocks.AuctionsMock;
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

		IncrementalAuction auction = (IncrementalAuction) AuctionsMock
				.getInstance().get(auctionId);

		html = LibTxt.replaceAll(html, "##AUCTION_ID##", "" + auctionId);

		html = LibTxt.replace(html, "##AUCTION_DESC##", auction.getPrize()
				.getDescription());
		html = LibTxt.replaceAll(html, "##AUCTION_PRICE##", ""
				+ auction.getNextBidValue());

		out.println(html);

	}

}
