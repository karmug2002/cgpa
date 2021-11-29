package basepackage;

/**
 * This class is used for reading files from the disk.
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

final class ReadingAFile
{
	private Path filePath;
	private BufferedReader reader;
	private static String currentDirectory;
	private HashSet<String> lines;
	private HashMap<String,Float> semInfo;
	//private String fileName;
	
	public ReadingAFile(String fileName) 
	{
		currentDirectory = System.getProperty("user.dir");
		filePath=Paths.get(currentDirectory+"/data/"+fileName);//current working dir
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
			semInfo.put(strs[0], parse(strs[1])); //splitting the String using "," delimeter
		}
	}
	
	public HashMap<String,Float> getSemInfo() 
	{
		try
		{
			readFile();
			valueSep();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		return semInfo;
	}

}
