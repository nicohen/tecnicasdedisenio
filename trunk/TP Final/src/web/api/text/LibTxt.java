package web.api.text;

public class LibTxt {

	public static String replace(String in, String find, String replace){
		int index = in.indexOf(find);
		
		if (index >= 0){
			StringBuffer s = new StringBuffer();//new StringBuffer(replace.length()+(in.length()-find.length()));
			s.append(in.substring(0, index));
			s.append(replace);
			s.append(in.substring(index+find.length()));
			
			return s.toString();
		} else 		
			return in;
	}
}
