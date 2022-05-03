package fourth.coachingapp.response;

public class EmailTemplate
{
	public static String coachFormBody(
			String coachfname, String coachlname,
			String traineefname, String traineelname)
	{
		return ("This is to inform you that coach " + coachfname + " " + coachlname + " has added"
				+ "a coach form with " + traineefname + " " + traineelname + " as a trainee.");
	}

	public static String progressFormBody(
			String coachfname, String coachlname,
			String traineefname, String traineelname)
	{
		return ("Coach " + coachfname + " " + coachlname + " has added"
				+ "a Progress evaluation form with " + traineefname + " " + traineelname + " as a trainee.");
	}
}
