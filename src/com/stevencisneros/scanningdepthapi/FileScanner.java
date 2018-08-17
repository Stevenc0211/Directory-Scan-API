package com.stevencisneros.scanningdepthapi;

import java.io.File;

public class FileScanner {
		
	public static ScanResult scan(String path) {
		try{
		return new ScanResult(path); //creates an instance ScanResult
		
		}catch(ScanningException e){
			e.printStackTrace();
			return null;
		}
		
	}
	
	public static class ScanResult {
		
		private String path;
		private int numFiles;
		private int numDirectories;
		private long totalBytes;
		private long avgBytes;
		
		private ScanResult(String path)throws ScanningException{
			
			this.path = path;
			File root = new File(path);
			scanDirectory(root);
			
		}
		
		private void scanDirectory(File root) throws ScanningException 
		{// scans a root folder to see sub-folders and files contained
			 
				 if(root.exists())
			        {
			            File[] filesList = root.listFiles(); // list the files within the current directory
			            
			            if(filesList != null && filesList.length > 0)
			            {// make sure that the list of files exists and also ensure that there is at least one item in that directory before trying to extract anything from it
			            	
			                // for each file in the filesList, check if it is a directory or if it is a file
			                for(File file: filesList)
			                {
			                    if(file.isDirectory())
			                    {
			                    	
			                    	numDirectories++;
			                        scanDirectory(file); // recursively loop back to this method and take the new file and search for songs within it
			                    }
			                    if(file.isFile() && !(file.isHidden())) //it is a file and not a directory 
			                    {
			        
			                    	numFiles++;
			                        totalBytes+=file.length();
			                    }
			                }
			            }
			        }
				 else
				 {
					throw new ScanningException("Root Directory: \""+path+"\" does not exist!"); 
				 }
			
				 

		}
		
		public int getNumFiles() // return the number of files scanned
		{ 
			return numFiles;
		}
		
		public int getNumDirectories() // return the number of directories scanned
		{
			return numDirectories;
		}
		
		public long getTotalBytes() // return the total number of bytes contained within all scanned files
		{
			return totalBytes;
		}
		
		public long getAvgBytes() // return the average size of the scanned files
		{
			avgBytes = totalBytes/numFiles;
			return avgBytes;
		
		}
		
		
	};
	
	

}
