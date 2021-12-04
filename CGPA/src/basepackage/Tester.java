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
		float cg = cseManager.getCGPAForOneSem(2);
		System.out.println(cg);
	}

}
