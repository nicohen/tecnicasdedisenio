package api.web.mvc.view;

import api.web.mvc.model.Model;

/**
 * Marker interface view
 * @author mgonzalez
 *
 */
public interface View {
	public void execute() throws Exception;
	public void setModel(Model model);
}
