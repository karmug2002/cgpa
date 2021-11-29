package basepackage;

import java.io.IOException;
import java.util.HashMap;

/**
 * This class will manage the semester objects.
 * @author karmugilan
 *
 */

public class SemManager
{
	private HashMap<String,Semester> semesters;//Stores semester objects mapped to the semester name.
	private String fileName;
	private int howMany;
	
	public SemManager(String dep , int howMany) throws IOException
	{
		semesters=new HashMap<String,Semester>();
		this.fileName=dep;
		this.howMany=howMany;
		createSemObjects();
	}
	
	private void createSemObjects() throws IOException
	{
		for(int k = 1; k<howMany+1; k++)
		{
			Semester sem = new Semester(fileName+"sem"+k+".csv");//create semester objects.
			semesters.put(sem.toString() , sem);//store the semester objects.
		}
		//System.out.println(semesters);
	}
	
	public float getCGPAForOneSem(int whatSem) 	//this method returns cgpa for the selected semester
	{
		String sem="Semester "+whatSem;
		Semester selectedSem = semesters.get(sem);
		return selectedSem.getCGPA();	//return the cgpa for selected semester.
	}
	

}
