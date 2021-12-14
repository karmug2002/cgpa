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
import java.util.ArrayList;
import java.util.HashMap;

final class CSVParser
{
	//field variables
	private Path filePath;
	private BufferedReader reader;
	private static String currentDirectory;
	private HashMap<ArrayList<String>,ArrayList<Float>> semInfo;
	private HashMap<String,HashMap<ArrayList<String>,ArrayList<Float>>> semesterInfos;
	
	public CSVParser(String fileName) 
	{
		currentDirectory = System.getProperty("user.dir"); //returns the current working dir.
		//String osName = System.getProperty("os.name");	//returns the os name.
		filePath = Paths.get(currentDirectory + "/data/" + fileName);//current working dir
		try
		{
			reader = Files.newBufferedReader(filePath);
		} 
		catch (IOException e)
		{
			System.out.println("The specified file is not found! " + fileName);
			e.printStackTrace();
		}
		semInfo = new HashMap<ArrayList<String>,ArrayList<Float>>();		
		semesterInfos = new HashMap<String,HashMap<ArrayList<String>,ArrayList<Float>>>();
	}
	
	private static float parse(String s)
	{
		return Float.parseFloat(s);
	}
	
	private void readFile() throws IOException
	{
		int count = 1;
		ArrayList<String> semNames = new ArrayList<String>();
		ArrayList<Float> givenCPS = new ArrayList<Float>();
		while(true)
		{
			String line = reader.readLine();
			if(line == null)
				break;
			
			String[] strs = line.split(",");  //splitting the strings using ","
			String s = "Semester "+count;
			
			if(!line.startsWith(s))
			{
				semNames.add(strs[2]);
				givenCPS.add(parse(strs[strs.length-1]));
				
			}
			else
			{
				semInfo.put(semNames,givenCPS);
				semesterInfos.put(s, semInfo);//old object 
				semInfo = new HashMap<ArrayList<String>,ArrayList<Float>>();//adding a new reference,new object to store the data
				semNames = new ArrayList<String>();
				givenCPS = new ArrayList<Float>();
				count++;    //to know what semester is.
			}
			
		}
	}
	
	public HashMap<String,HashMap<ArrayList<String>,ArrayList<Float>>> getSemesterInfos()
	{
		try
		{
			this.readFile();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return semesterInfos;
	}

}
