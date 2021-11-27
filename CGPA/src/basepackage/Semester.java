package basepackage;

/** 
 * This class handles all stuff releated to cgpa.
 * @author implemented by Karmugilan for the miniproject.
 * 
 */


import java.util.ArrayList;
import java.util.HashMap;
import org.apache.commons.csv.*;
import edu.duke.*;

public class Semester extends CGPA
{
	
	private HashMap<String,Float> semInfo;
	private InputProcessor ip;
	private String fileName;
	
	public Semester(String fileName)
	{
		semInfo=new HashMap<String,Float>(); //initialize the semester information
		ip=new InputProcessor(semInfo);
		this.fileName=fileName;
	}
	
	private void totalCgpa() 
	{
		for(String s : semInfo.keySet())
		{
			totalCgpa+=semInfo.get(s);
		}
	}

	private void totalAverageCgpa()
	{
		ArrayList<Float> inputs = ip.getInput();
		ArrayList<Float> cgpas = new ArrayList<Float>();
		
		for(String s : semInfo.keySet())
		{
			cgpas.add(semInfo.get(s));
		}

		for(int k=0; k<inputs.size(); k++)
		{
			totalAcquired += inputs.get(k)*cgpas.get(k);
		}
	}
	
	private float parse(String s)
	{
		return Float.parseFloat(s);
	}
	
	public void readCSV()  //read the CSV files from the disk
	{
		FileResource file = new FileResource(fileName);
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
		totalCgpa();
		totalAverageCgpa();
		//System.out.println(totalAcquired);//these are for debug purposes only
		//System.out.println(totalCgpa);
		return super.getCGPA();
	}
	
}
