package web.api.writers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class HtmlWriter {

	private StringBuffer buffer;
	private PrintWriter writer;
	private static String EOL = "\n";
	
	public HtmlWriter(HttpServletResponse res) throws IOException {
		this.writer = res.getWriter();
		this.buffer = new StringBuffer();
	}
	public void println(String s){
		buffer.append(s+HtmlWriter.EOL);
	}
	
	public void flush(){
		writer.println(buffer);
		writer.flush();
	}
	
	
}
