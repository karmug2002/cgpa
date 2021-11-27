package basepackage;

/**
 * This class is purely used for testing the features only!.
 * @author implemented by Karmugilan for the miniproject.
 * 
 */

public class Tester
{
	public static void main(String[] args)
	{
		Semester sem = new Semester("java.csv");
		float cgpa = sem.getCgpa();
		System.out.println(cgpa);
	}

}
