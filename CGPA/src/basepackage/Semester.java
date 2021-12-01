package basepackage;

import java.io.IOException;

/** 
 * This class handles all stuff related to cgpa.
 * @author implemented by Karmugilan for the miniproject.
 * 
 */


import java.util.ArrayList;
import java.util.HashMap;


final class Semester 
{
	//field variables
	private HashMap<String,Float> semInfo; //hashmaps are like dictionaries storing a key and a value.
	private InputProcessor ip;
	private static int semObjectCount;
	private int sem;
	private float totalAcquired;
	private float totalCGPA;
	private CSVParser readFile;
	
	public Semester(String fileName) throws IOException
	{
		setSemObjectCount(getSemObjectCount() + 1); //keeping track of the semester objects for future use
		this.sem=getSemObjectCount();
		readFile = new CSVParser(fileName);//new class to read files from the disk.
		semInfo = readFile.getSemInfo(); //initialize the semInfo in the constructor;
	}
	
	private void totalCGPA() 
	{
		for(String s : semInfo.keySet())
		{
			totalCGPA+=semInfo.get(s);
		}
	}
	
	private void totalAverageCGPA()
	{
		ArrayList<Float> inputs = ip.getInput();	   //receive the inputs from the user
		ArrayList<Float> cgpas = new ArrayList<Float>();//add the cgpas from the hashmap to the arraylist 
		
		for(String s : semInfo.keySet())
		{
			cgpas.add(semInfo.get(s));
		}

		for(int k=0; k<inputs.size(); k++)
		{
			totalAcquired += inputs.get(k)*cgpas.get(k);
		}
		
	}
	
	public float getCGPA() //initialize the values of the private variables
	{
		ip=new InputProcessor(semInfo);
		totalCGPA();
		totalAverageCGPA();
		return totalAcquired/totalCGPA;
	}

	public static int getSemObjectCount()
	{
		return semObjectCount;
	}
	
	public static void setSemObjectCount(int semObjectCount)
	{
		Semester.semObjectCount = semObjectCount;
	}
	
	public String getName()
	{
		return "Semester "+sem;
	}
	
	@Override
	public String toString()  //automatically called by the println fn.
	{
		return semInfo.toString();
	}
	
}
