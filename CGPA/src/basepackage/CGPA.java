package basepackage;

/**
 * Plain old java object.
 * @author implemented by Karmugilan for the miniproject.
 * 
 */


public abstract class CGPA
{
	protected float totalCGPA,totalAcquired,average;//visible to this package only!
	public CGPA() //we will use this constructor later
	{
		
	}

	public float getCGPA()
	{
		average=totalAcquired/totalCGPA;
		return average;
	}
}
