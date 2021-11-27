package basepackage;

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
			in=scanner.nextFloat();
			print(s);
		}
		return input;
	}
	private void print(String s)
	{
		System.out.println(String.format("%s Enter Your Cgpa: ",s));
	}

}
