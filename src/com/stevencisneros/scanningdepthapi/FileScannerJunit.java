package com.stevencisneros.scanningdepthapi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.stevencisneros.scanningdepthapi.FileScanner.ScanResult;

public class FileScannerJunit {

	ScanResult results; 
	String rootDirectory = "/Users/steve-0/Desktop/testAPI"; // Use your path after this. 
	
	@Before
	public void setUp()
	{
		results = FileScanner.scan(rootDirectory);
	}
	
	
	@Test
	public void getNumFilesTest() {
		assertEquals(results.getNumFiles(),4);
	}
	
	@Test
	public void getNumDirectoriesTest() {
		assertEquals(results.getNumDirectories(),0);
	}
	
	@Test
	public void getTotalBytesTest() {
		assertEquals(results.getTotalBytes(),18621);
	}
	
	@Test
	public void getAvgBytesTest() {
		assertEquals(results.getAvgBytes(),4655);
	}

}
