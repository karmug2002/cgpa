package basepackage;

import java.util.ArrayList;
import java.util.HashMap;

public class InputProcessor
{

	private HashMap<String,Float> semInfo;
	public InputProcessor(HashMap<String,Float> semInfo)
	{
		this.semInfo=semInfo;
	}
	public ArrayList<Float> getInput()
	{
		ArrayList<Float> input= new ArrayList<Float>();
		for(String s : semInfo.keySet())
		{
			print(s);
		}
		return input;
	}
	private void print(String s)
	{
		System.out.println(String.format("%s Enter Your Cgpa: ",s));
	}

}
