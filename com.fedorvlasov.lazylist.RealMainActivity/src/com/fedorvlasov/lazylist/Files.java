package com.fedorvlasov.lazylist;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Files {
	
	/**
	 * Return list of files from path. <FileName, FilePath>
	 *
	 * @param path - The path to directory with images
	 * @return Files name and path all files in a directory, that have ext = "jpeg", "jpg","png", "bmp", "gif"  
	 */	
	
	String[] getListOfFiles(String path) {

	    File files = new File(path);
	    String[] mstring;
	    
	    FileFilter filter = new FileFilter() {

	        private final List<String> exts = Arrays.asList("jpeg", "jpg",
	                "png", "bmp", "gif");

	        public boolean accept(File pathname) {
	            String ext;
	            String path = pathname.getPath();
	            ext = path.substring(path.lastIndexOf(".") + 1);
	            return exts.contains(ext);  
	        }
	    };

	    final File [] filesFound = files.listFiles(filter);
	    
	    mstring = new String[filesFound.length];
	    
	    if (filesFound != null && filesFound.length > 0) {
	       for(int i = 0; i < mstring.length; i++){
	    	   
	    	   mstring[i] = filesFound[i].toString();
	       }
	        
	        
	        
	        
	    }

	    return mstring;
	}

}
