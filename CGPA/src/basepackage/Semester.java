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
	private float totalAcquiredCP;
	private float totalGivenCP;
	private ArrayList<Float> givenCps;
	//private CSVParser readFile;
	
	public Semester(HashMap<String,Float> semInfo) throws IOException
	{
		setSemObjectCount(getSemObjectCount() + 1); //keeping track of the semester objects for future use
		this.sem = getSemObjectCount();
		this.semInfo = semInfo; //receive the semInfo from the constructor!!
		givenCps = new ArrayList<Float>();
	}
	
	private void sumGivenCps() 
	{
		for(Float value : semInfo.values())
		{
			totalGivenCP += value;
			givenCps.add(value);//add the given credit points from the hashmap to the arraylist 
		}
	}
	
	private void sumAcquiredCPs()
	{
		ArrayList<Float> inputs = ip.getInput();	   //receive the inputs from the user

		for(int k = 0; k<inputs.size(); k++)
		{
			totalAcquiredCP += inputs.get(k) * givenCps.get(k);
		}
		
	}
	
	public float getCGPA() //initialize the values of the private variables
	{
		System.out.println("Current Semester is : " + this.getName());
		ip = new InputProcessor(semInfo);
		sumGivenCps();
		sumAcquiredCPs();
		return totalAcquiredCP/totalGivenCP;
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
		return "Semester " + sem;
	}
	
	@Override
	public String toString()  //automatically called by the println fn.
	{
		return semInfo.toString();
	}
	
}
