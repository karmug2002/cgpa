package basepackage;

import java.util.ArrayList;
import java.util.HashMap;
import org.apache.commons.csv.*;
import edu.duke.*;

public class Semester extends CPGA
{
	
	private HashMap<String,Float> semInfo;
	private InputProcessor ip;
	private String fileName;
	public Semester(String fileName)
	{
		semInfo=new HashMap<String,Float>();
		ip=new InputProcessor(semInfo);
		this.fileName=fileName;
	}
	private void totalCgpa()
	{
		for(String s : semInfo.keySet())
		{
			totalCgpa+=semInfo.get(s);
		}
	}

	private void totalAverageCgpa()
	{
		ArrayList<Float> inputs = ip.getInput();
		ArrayList<Float> cgpas = new ArrayList<Float>();
		
		for(String s : semInfo.keySet())
		{
			cgpas.add(semInfo.get(s));
		}

		for(int k=0; k<inputs.size(); k++)
		{
			totalAcquired = inputs.get(k)*cgpas.get(k);
		}
	}
	private float parse(String s)
	{
		return Float.parseFloat(s);
	}
	public void readCsv()
	{
		FileResource file = new FileResource(fileName);
		for(CSVRecord csv : file.getCSVParser(false))
		{
			semInfo.put(csv.get(0), parse(csv.get(1)));
		}
		System.out.println(semInfo);
	}
	@Override
	public float getCgpa()
	{
		totalCgpa();
		totalAverageCgpa();
		return super.getCgpa();
	}
}
