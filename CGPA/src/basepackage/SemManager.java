package basepackage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * This class will manage the semester objects.
 * @author karmugilan
 */

public final class SemManager
{
	//field variables
	private HashMap<String,Semester> semesters;//Stores semester objects mapped to the semester name.
	private String fileName;
	
	public SemManager(String dep) throws IOException
	{
		semesters = new HashMap<String,Semester>();
		this.fileName = dep;
		createSemObjects();
	}
	
	private void createSemObjects() throws IOException
	{
		CSVParser cv = new CSVParser(fileName + "data.csv");
		HashMap<String, HashMap<ArrayList<String>, ArrayList<Float>>> semestersInfo = cv.getSemesterInfos(); //get the semester Infos!!
		
		for(int k = 1; k<semestersInfo.size()+1; k++)
		{
			HashMap<ArrayList<String>,ArrayList<Float>> semInfo = semestersInfo.get("Semester "+k);
			Semester sem = new Semester(semInfo);
			semesters.put("Semester "+k , sem);//store the semester objects.
		}
		
	}
	
	public float getCGPAForOneSem(int whichSem) //this method returns cgpa for the selected semester
	{
		String sem = "Semester "+whichSem;
		Semester selectedSem = semesters.get(sem);
		System.out.println("Current Semester is : "+ sem);
		//System.out.println(selectedSem);
		return selectedSem.getCGPA();	//return the cgpa for selected semester.
	}
	

}
