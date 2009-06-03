package api.web.files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class InputTextFile {

	private String fileName;
	
	private boolean isOpen;
	private BufferedReader r;
	private boolean EOF;
	private String line;
	
	public InputTextFile(String fileName){
		this.fileName = fileName;
		isOpen = false;
		EOF = false;
	}
	
	public String getLine() throws FileNotFoundException{
		return line;
	}
	
	public boolean next() throws IOException{
		if (!isOpen && !EOF){ //Si no esta abierto y no es EOF (o sea nunca fue leido)
			open();
			isOpen = true;
			EOF = false;
		}
		
		String s = r.readLine();
		if (s == null){ // fin de archivo 
			EOF = true;
			close();
		}
		line = s;
		
		return !EOF;
	}

	private void close() {
		try {
			r.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Already close");
		}		
	}

	private void open() throws FileNotFoundException {
		try {
			File arch = new File(fileName);
			System.out.println("PATH=" + arch.getAbsolutePath());
		} catch (Exception e){
			
		}

		r = new BufferedReader(new FileReader(fileName));
	}
	
	@Override
	protected void finalize() throws Throwable {
		r.close();
		super.finalize();
	}
}
