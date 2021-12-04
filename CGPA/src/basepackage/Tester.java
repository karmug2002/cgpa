package basepackage;

<<<<<<< Updated upstream
=======
import java.io.IOException;
import java.util.HashMap;

>>>>>>> Stashed changes
/**
 * This class is purely used for testing the features only!.
 * @author implemented by Karmugilan for the miniproject.
 * 
 */

public class Tester
{
	public static void main(String[] args)
	{
		/*
		Semester sem = new Semester("data/csesem1.csv");
		Semester sem2 = new Semester("data/csesem3.csv");
		Semester sem3 = new Semester("data/csesem3.csv");
		
		int objectCount=Semester.getSemObjectCount();//get the object count
		
		System.out.println(objectCount);
		System.out.println(sem);
		System.out.println(sem2);
		System.out.println(sem3);
		
		float cgpa = sem.getCGPA();
		System.out.println(cgpa);
		*/
<<<<<<< Updated upstream
		SemManager cseManager = new SemManager("cse",3);
		float cg = cseManager.getCGPAForOneSem(3);
=======
		SemManager cseManager = new SemManager("cse");
		float cg = cseManager.getCGPAForOneSem(1);		
>>>>>>> Stashed changes
		System.out.println(cg);
		
		//CSVParser cv = new CSVParser("data.csv");
		//HashMap<String,HashMap<String,Float>> semesters =cv.getSemesters();
		//System.out.println(semesters.get("Semester 1"));
		//System.out.println(semInfo);

	}

}
