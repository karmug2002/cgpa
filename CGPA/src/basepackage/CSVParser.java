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
//import java.util.ArrayList;
//import java.util.Arrays;
import java.util.HashMap;
//import java.util.HashSet;
//import java.util.List;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;

final class CSVParser
{
	private Path filePath;
	private BufferedReader reader;
	private static String currentDirectory;
	//private HashSet<String> lines;
	private HashMap<String,Float> semInfo;
	private HashMap<String,HashMap<String,Float>> semesters;

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
			//lines = new HashSet<String>();
			semInfo=new HashMap<String,Float>();
			semesters=new HashMap<String,HashMap<String,Float>>();
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
			//lines = new HashSet<String>();
			semInfo=new HashMap<String,Float>();
			semesters=new HashMap<String,HashMap<String,Float>>();
		}
		
	}
	
	private static float parse(String s)
	{
		return Float.parseFloat(s);
	}
	
	private void readFile() throws IOException
	{
		int count=1;
		//HashMap<String,Float> semInfo = new HashMap<String,Float>();
		while(true)
		{
			String line = reader.readLine();
			if(line==null)
			{
				break;
			}
			//lines.add(line);
			String[] strs = line.split(",");
			//System.out.println(Arrays.toString(strs));
			String s="Semester "+count;
			if(!line.startsWith(s))
			{
				//System.out.println(line);
				semInfo.put(strs[2], parse(strs[strs.length-1]));
			}
			else
			{
				//if(!semesters.containsKey(s))
				semesters.put(s, semInfo);
				//semInfo = null;
				//System.out.println(semInfo + " " +s);
				semInfo = null;
				semInfo = new HashMap<String,Float>();
				count+=1;
				//System.out.println(semInfo);
			}
			//System.out.println(line);
		}
		//System.out.println(semInfo);
		//System.out.println(semesters.get("Semester 6"));
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

	
	/* old method for reading files!!
	private void valueSep()
	{
		//System.out.println(lines);
		for(String s : lines)
		{
			String[] strs = s.split(",");
			//System.out.println(Arrays.toString(strs));
			//System.out.println(semInfo);
			semInfo.put(strs[0], parse(strs[1])); //splitting the String using "," delimeter
		}
	}
	*/
	/* old methods not scalable
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
		//return semInfo;
		return semInfo;
	}
	*/
}
