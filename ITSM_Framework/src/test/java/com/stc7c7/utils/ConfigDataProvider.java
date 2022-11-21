package com.stc7c7.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigDataProvider 
{
	static File file;	
	static FileInputStream fis;
	protected static Properties ppts;
	
	public ConfigDataProvider()
	{
		String filePath = System.getProperty("user.dir")+"//config//config.ppts";
		file = new File(filePath);		
		
		try 
		{
			fis = new FileInputStream(file);
			ppts = new Properties();
			ppts.load(fis);
			
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("FileNotFoundException found in initializePpt : " + e.getMessage());
			
		} 
		catch (IOException e) 
		{
			System.out.println("IOException found in initializePpt : " + e.getMessage());
		}
		
	}

	public String readProperty(String property)
	{
		return ppts.getProperty(property);
	}
}
