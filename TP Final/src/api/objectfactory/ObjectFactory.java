/*
 * Created on 24/09/2006
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package api.objectfactory;

import java.util.HashMap;

/**
 * @author mgonzalez
 *
 * To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
public class ObjectFactory {

	private static ObjectFactory instance = new ObjectFactory(); //Singleton
	private HashMap classMap = new HashMap();
	
	public static ObjectFactory getInstance(){
		return instance;
	}
	private ObjectFactory(){} // No instanciable
	
	public static Object getObject(Class interfaceClass){
		Object obj = null;
		HashMap map = ObjectFactory.getInstance().getClassMap();


		try {
			obj = getConcreteType(map, interfaceClass).newInstance();

		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

		return obj;		
	}

	/**
	 * @param map
	 * @param interfaceClass
	 * @return
	 */
	private static Class getConcreteType(HashMap map, Class interfaceClass) {
		if (!map.containsKey(interfaceClass)){
			try {
				Class c = Class.forName(interfaceClass.getName().replace("api.","app.")+"Impl");
				System.out.println("Adding "+interfaceClass.getName()+ " to Map");
				map.put(interfaceClass,c);
			
			}catch (ClassNotFoundException cnfe){ //Intento la instancia por el nombre recibido
				try {
					Class c = Class.forName(interfaceClass.getName());
					map.put(interfaceClass,c);
				} catch (ClassNotFoundException ce) {
					ce.printStackTrace();
					return null;
				}
//				cnfe.printStackTrace();
//				return null;
			}			
		}
		return (Class)map.get(interfaceClass);
	}
	/**
	 * @return
	 */
	public HashMap getClassMap() {
		return classMap;
	}

}
