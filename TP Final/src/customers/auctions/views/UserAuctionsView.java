package customers.auctions.views;

import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import api.web.cache.HtmlCache;
import api.web.mvc.view.HtmlView;
import api.web.text.LibTxt;
import domain.auctions.Auction;

public class UserAuctionsView extends HtmlView {

	public UserAuctionsView(HttpServletRequest req, HttpServletResponse res,
			HashMap<String, Object> requestAttributes,
			ServletContext servletContext,
			HashMap<String, Object> requestParameters) throws Exception {
		super(req, res, requestAttributes, servletContext, requestParameters);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doHtmlBody() throws Exception {
		String auctionsListView = HtmlCache.getHtml(relativePath, "auction/UserAuctionsListView");

		
		
		//out.println(LibTxt.replace(auctionsListView,"##AUCTIONS##",strB.toString()));

	}

	private String getAuctionInfo(Auction auction) {
		String auctionListView = HtmlCache.getHtml(relativePath, "auction/AuctionListView");
		auctionListView = LibTxt.replace(auctionListView,"##URL##",String.valueOf(auction.getAuctionId()));
		auctionListView = LibTxt.replace(auctionListView,"##TITLE##",auction.getPrize().getDescription());
		auctionListView = LibTxt.replace(auctionListView,"##POINTS##",String.valueOf(auction.getValue()));
		auctionListView = LibTxt.replace(auctionListView,"##DESCRIPTION##",String.valueOf(auction.getPrize().getDescription()));
		return auctionListView;
	}

}
