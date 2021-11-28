package basepackage;

/** 
 * This class handles all stuff related to cgpa.
 * @author implemented by Karmugilan for the miniproject.
 * 
 */


import java.util.ArrayList;
import java.util.HashMap;
import org.apache.commons.csv.*;
import edu.duke.*;

public class Semester extends CGPA
{
	
	private HashMap<String,Float> semInfo;//hashmaps are like dictionaries storing a key and value.
	private InputProcessor ip;
	private String fileName;
	private FileResource file;
	private static int semObjectCount;
	private int sem;
	
	public Semester(String fileName)
	{
		setSemObjectCount(getSemObjectCount() + 1); //keeping track of the semester objects for future use
		this.sem=getSemObjectCount();
		semInfo=new HashMap<String,Float>(); 
		ip=new InputProcessor(semInfo);
		this.fileName=fileName;
		file = new FileResource(this.fileName);//this class reads the files from the disk
	}
	
	private void totalCGPA() 
	{
		for(String s : semInfo.keySet())
		{
			super.totalCGPA+=semInfo.get(s);
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
			super.totalAcquired += inputs.get(k)*cgpas.get(k);
		}
	}
	
	private float parse(String s)
	{
		return Float.parseFloat(s);
	}
	
	public void readCSV()  //read the CSV files from the disk
	{
		
		for(CSVRecord csv : file.getCSVParser(false))
		{
			semInfo.put(csv.get(0), parse(csv.get(1)));//update the semester info
		}
		//System.out.println(semInfo);
	}
	
	@Override
	public float getCGPA() //override this method from the base class to initialize the values of the protected variables
	{
		readCSV();
		totalCGPA();
		totalAverageCGPA();
		//System.out.println(super.totalAcquired);//these are for debug purposes only
		//System.out.println(super.totalCGPA);
		return super.getCGPA();
	}

	public static int getSemObjectCount()
	{
		return semObjectCount;
	}
	
	public static void setSemObjectCount(int semObjectCount)
	{
		Semester.semObjectCount = semObjectCount;
	}
	
	public String toString()  //automatically called by the println fn.
	{
		return "Semester "+sem;
	}
	
}
