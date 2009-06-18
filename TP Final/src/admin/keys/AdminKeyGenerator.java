package admin.keys;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.customers.Key;

import persistence.KeysPersistor;
import admin.keys.views.AdminKeyGeneratorFormView;
import admin.keys.views.AdminKeyGeneratorSavedView;
import api.web.mvc.controller.BackEndControllerServlet;
import api.web.mvc.view.View;

public class AdminKeyGenerator extends BackEndControllerServlet {

	private static String ALPHA_CHARS = "abcdefghijklmonpqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	
	@Override
	protected void executeView(HttpServletRequest req, HttpServletResponse res,
			HashMap<String, Object> requestAttributes,
			ServletContext servletContext,
			HashMap<String, Object> requestParameters) throws Exception {
		
		String action = (String)requestParameters.get("act");
		if (action == null || action.length()==0){
			action="form";
		}

		if ("form".equals(action)){
			showForm(req,res,requestAttributes,servletContext,requestParameters);
		} else if ("save".equals(action)){
			showConfirmation(req,res,requestAttributes,servletContext,requestParameters);
		}
	}

	private void showConfirmation(HttpServletRequest req,
			HttpServletResponse res, HashMap<String, Object> requestAttributes,
			ServletContext servletContext,
			HashMap<String, Object> requestParameters) throws Exception {
		List<String> keys = new ArrayList<String>();
		int qty = Integer.parseInt((String)requestParameters.get("keys_qty"));
		int value = Integer.parseInt((String)requestParameters.get("keys_value"));
		
		int saved = 0;
		KeysPersistor keyPersistor = KeysPersistor.getKeysPersistorInstance();
		Random random = new Random();
		while (saved < qty){
			String newKey = getRandomAlphaNumKey(random);
			if (keyPersistor.getKeyForAlphanumeric(newKey)==null){
				keyPersistor.saveKey(new Key(newKey,value));
				saved++;
				keys.add(newKey);
			}
		}
		
		View view = new AdminKeyGeneratorSavedView(req,res,requestAttributes,servletContext,requestParameters);
		((AdminKeyGeneratorSavedView)view).setKeys(keys);
		
		view.execute();
	}

	private String getRandomAlphaNumKey(Random r) {
		StringBuffer sb = new StringBuffer();
		int length = 10;
		
		for (int i=0; i < length; i++){
			sb.append(AdminKeyGenerator.ALPHA_CHARS.charAt(r.nextInt(AdminKeyGenerator.ALPHA_CHARS.length())));
		}
		
		return sb.toString();
	}

	private void showForm(HttpServletRequest req, HttpServletResponse res,
			HashMap<String, Object> requestAttributes,
			ServletContext servletContext,
			HashMap<String, Object> requestParameters) throws Exception {

		View view = new AdminKeyGeneratorFormView(req,res,requestAttributes,servletContext,requestParameters);
		view.execute();
	}

}
