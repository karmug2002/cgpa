package basepackage;

import java.io.IOException;

/**
 * This class is purely used for testing the features only!.
 * @author implemented by Karmugilan for the miniproject.
 */

public class Tester
{
	public static void main(String[] args) throws IOException
	{
		SemManager cseManager = new SemManager("cse");
		float cgpaForSem1 = cseManager.getCGPAForOneSem(8);
		//float cpaForSem2 = cseManager.getCGPAForOneSem(2);
		System.out.println(cgpaForSem1);
	}

}
