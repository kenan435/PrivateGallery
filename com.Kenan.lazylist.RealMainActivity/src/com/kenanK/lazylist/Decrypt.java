package com.Kenan.lazylist;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;


public class Decrypt {

	/**
	 * @param args
	 */
	
    
	
	public static void main(String[] args) {
		
		
			InputStream is = null;
			try {
				is = new FileInputStream("/sdcard/MyPhotos/1.jpg");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			ByteArrayOutputStream bao = new ByteArrayOutputStream();
			
			byte[] image = null;
			
	         int bytesRead = 0;


	          try {
				while((bytesRead = is.read(image)) != -1) {
				     bao.write(image, 0, bytesRead);
				  }
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		
		
		
		

	}

}
