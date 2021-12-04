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

final class CSVParser
{
	private Path filePath;
	private BufferedReader reader;
	private static String currentDirectory;
	private HashMap<String,Float> semInfo;
	private HashMap<String,HashMap<String,Float>> semesters;
	
	public CSVParser(String fileName) 
	{
		currentDirectory = System.getProperty("user.dir"); //returns the current working dir.
		//String osName = System.getProperty("os.name");	//returns the os name.
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
		semInfo=new HashMap<String,Float>();
		semesters=new HashMap<String,HashMap<String,Float>>();
	}
	
	private static float parse(String s)
	{
		return Float.parseFloat(s);
	}
	
	private void readFile() throws IOException
	{
		int count=1;
		while(true)
		{
			String line = reader.readLine();
			if(line==null)
				break;
			String[] strs = line.split(",");  //splitting the strings using ","
			String s="Semester "+count;
			if(!line.startsWith(s))
			{
				semInfo.put(strs[2], parse(strs[strs.length-1]));
			}
			else
			{
				semesters.put(s, semInfo);//old object 
				semInfo = null;           //deleting the old reference
				semInfo = new HashMap<String,Float>();//adding a new reference,new object to store the data
				count++;    //to know what semester is.
			}
		}
	}
	
	public HashMap<String,HashMap<String,Float>> getSemesters()
	{
		try
		{
			readFile();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return semesters;
	}

}
