package basepackage;

public abstract class CPGA
{
	protected float totalCgpa,totalAcquired,average;
	public CPGA()
	{
		
	}

	public float getCgpa()
	{
		average=totalAcquired/totalCgpa;
		return average;
	}
}
