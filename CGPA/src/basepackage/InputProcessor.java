package basepackage;

/** 
 * This class processes the inputs using scanner
 * for now , but  as the app develops this class
 * will be modified.
 * @author implemented by Karmugilan for the miniproject.
 * 
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class InputProcessor
{

	private HashMap<String,Float> semInfo;
	private Scanner scanner;
	private float in;
	
	public InputProcessor(HashMap<String,Float> semInfo)
	{
		this.semInfo=semInfo;
		scanner=new Scanner(System.in);
	}
	
	public ArrayList<Float> getInput()
	{
		
		ArrayList<Float> input= new ArrayList<Float>();
		for(String s : semInfo.keySet())
		{
			print(s);
			in=scanner.nextFloat();
			input.add(in);
		}
		return input;
	}
	
	private void print(String s)
	{
		System.out.print("Enter Your Grade for this Subject " +s+": ");
	}

}
