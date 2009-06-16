package customers.groups.views;

import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistence.BidderPersistor;
import api.web.cache.HtmlCache;
import api.web.mvc.view.HtmlView;
import api.web.text.LibWeb;
import domain.customers.Group;
import domain.customers.User;
import domain.exceptions.GroupSizeExceededException;
import domain.exceptions.UserAlreadyInGroupException;

public class GroupView extends HtmlView {

	public GroupView(HttpServletRequest req, HttpServletResponse res,
			HashMap<String, Object> requestAttributes,
			ServletContext servletContext,
			HashMap<String, Object> requestParameters) throws Exception {
		super(req, res, requestAttributes, servletContext, requestParameters);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doHtmlBody() throws Exception {
		String html = HtmlCache.getHtml(relativePath,"customers/groups/GroupHtml");
		if(!"".equals(LibWeb.getParameter(req, "group"))) {
			String userName = null;
			Cookie[] c = req.getCookies();
			for (int i = 0; i < c.length; i++) {
				if ("userName".equals(c[i].getName())) {
					userName = c[i].getValue();
				}
			}
		
			String groupName = LibWeb.getParameter(req, "group");
			
			try {
				User user = BidderPersistor.getBidderPersistorInstance().getUser(userName);
				Group group = new Group(user);
				group.addMember(user);
				BidderPersistor.getBidderPersistorInstance().saveGroup(group);
				out.println("Creacion de grupo ["+groupName+"] exitosa!");
			} catch (GroupSizeExceededException e) {
				out.println("Error, el grupo ya se encuentra lleno, vuelva a intentar en otro grupo");
			} catch (UserAlreadyInGroupException e2) {
				out.println("Error, el usuario ya fue incluido en un grupo anteriormente");
			}
		}
		out.println(html);
	}

}
