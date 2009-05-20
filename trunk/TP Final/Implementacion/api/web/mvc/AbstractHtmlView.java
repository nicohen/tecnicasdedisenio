package api.web.mvc;

public abstract class AbstractHtmlView {

	Model model;
	
	protected void setModel(Model model){
		this.model = model;
	}
	
	protected void execute(){
		doHttpHeader();
		doHtmlHeader();
		doHtmlMenu();
		doHtmlBody();
		doHtmlFooter();
	}
	
	public abstract void doHttpHeader();
	public abstract void doHtmlHeader();
	public abstract void doHtmlMenu();
	public abstract void doHtmlBody();
	public abstract void doHtmlFooter();
}
