package basepackage;

public class Tester
{

	public Tester()
	{
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args)
	{
		Semester sem = new Semester("java.csv");
		sem.readCsv();
		float cgpa = sem.getCgpa();
		System.out.println(cgpa);
	}

}
