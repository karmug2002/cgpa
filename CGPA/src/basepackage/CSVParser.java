package basepackage;

/**
 * This is a basic csv parser class. it parses using the delimeter ",".
 * It reads the files line by line and uses split to parse the files.
 * @author karmugilan
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.HashSet;

final class CSVParser
{
	private Path filePath;
	private BufferedReader reader;
	private static String currentDirectory;
	private HashSet<String> lines;
	private HashMap<String,Float> semInfo;
	//private String fileName;
	
	public CSVParser(String fileName) 
	{
		currentDirectory = System.getProperty("user.dir"); //returns the current working dir.
		String osName = System.getProperty("os.name");	//returns the os name.
		if(osName.equals("Linux"))
		{
			filePath=Paths.get(currentDirectory+"/data/"+fileName);//current working dir
			try
			{
				reader=Files.newBufferedReader(filePath);
			} 
			catch (IOException e)
			{
				System.out.println("The specified file is not found! "+ fileName);
				e.printStackTrace();
			}
			lines = new HashSet<String>();
			semInfo=new HashMap<String,Float>();
		}
		else   //this code is for windows but java automatically supports for windows dir navigation but I added it just in case.
		{
			filePath=Paths.get(currentDirectory+"\\data\\"+fileName);//current working dir
			try
			{
				reader=Files.newBufferedReader(filePath);
			} catch (IOException e)
			{
				System.out.println("The specified file is not found! "+ fileName);
				e.printStackTrace();
			}
			lines = new HashSet<String>();
			semInfo=new HashMap<String,Float>();
		}
		
	}

	private void readFile() throws IOException
	{
		while(true)
		{
			String line = reader.readLine();
			if(line==null)
			{
				break;
			}
			lines.add(line);	
		}
	}
	
	private static float parse(String s)
	{
		return Float.parseFloat(s);
	}
	
	private void valueSep()
	{
		for(String s : lines)
		{
			String[] strs = s.split(",");
			//System.out.println(strs);
			semInfo.put(strs[0], parse(strs[1])); //splitting the String using "," delimeter
		}
	}
	
	public HashMap<String,Float> getSemInfo() 
	{
		try
		{
			readFile();
			valueSep();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return semInfo;
	}

}
