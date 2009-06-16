package customers.auctions.views;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistence.AuctionPersistorImplementation;
import persistence.BidderPersistor;

import api.web.cache.HtmlCache;
import api.web.mvc.view.HtmlView;
import api.web.text.LibTxt;
import domain.auctions.Auction;
import domain.auctions.AuctionStatus;
import domain.auctions.IncrementalAuction;
import domain.auctions.ReverseAuction;
import domain.customers.Bidder;
import domain.customers.User;

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
		String auctionsListView = HtmlCache.getHtml(relativePath, "customers/auctions/UserAuctionsListView");
		
		String userName = null;
		Cookie[] c = req.getCookies();
		for (int i = 0; i < c.length; i++) {
			if ("userName".equals(c[i].getName())) {
				userName = c[i].getValue();
			}
		}
		Bidder bidder= BidderPersistor.getBidderPersistorInstance().getUser(userName);
		ArrayList<IncrementalAuction> auctions = AuctionPersistorImplementation.getInstance().getIncrementalAuctionsForBidder(bidder);
		List<Auction> wonAuctions = bidder.getWonAuctions();
		StringBuilder strB = new StringBuilder();
		StringBuilder strW = new StringBuilder();
		
		if(auctions!=null) {
			for(IncrementalAuction auction : auctions) {
				strB.append(getAuctionInfo(auction));
			}
		}
		
		if(wonAuctions!=null) {
			for(Auction auction : wonAuctions) {
				strW.append(getAuctionInfo(auction));
			}
		}
		
		auctionsListView=LibTxt.replace(auctionsListView,"##AUCTIONS##",strB.toString());
		out.println(LibTxt.replace(auctionsListView,"##WONAUCTIONS##",strW.toString()));

	}

	private String getAuctionInfo(Auction auction) {
		String auctionListView = HtmlCache.getHtml(relativePath, "customers/auctions/UserAuctionListView");
		auctionListView = LibTxt.replace(auctionListView,"##URL##",String.valueOf(auction.getAuctionId()));
		auctionListView = LibTxt.replace(auctionListView,"##TITLE##",auction.getPrize().getDescription());
		auctionListView = LibTxt.replace(auctionListView,"##POINTS##",String.valueOf(auction.getValue()));
		auctionListView = LibTxt.replace(auctionListView,"##DESCRIPTION##",String.valueOf(auction.getPrize().getDescription()));
		auctionListView = LibTxt.replace(auctionListView,"##STATUS##",String.valueOf(auction.getStatus().toString()));
		return auctionListView;
	}

}
