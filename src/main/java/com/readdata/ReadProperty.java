package com.readdata;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadProperty {
	
	public String readProperty(String text) throws IOException{
		  Properties obj = new Properties();   
		  FileInputStream objfile1 = new FileInputStream("D:\\Workspace\\web\\Resources\\datafile.properties");
		  FileInputStream objfile2 = new FileInputStream("D:\\Workspace\\web\\Resources\\locator.properties");
		  obj.load(objfile1);
		  obj.load(objfile2);
		  return obj.getProperty(text) ;
	}
}
