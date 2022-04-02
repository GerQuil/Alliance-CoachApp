package fourth.coachingapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

//@Entity

// @DynamicInsert
// @DynamicUpdate
//@Table(name = "user")
public class CoachForm
{
	// @Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	// @Column(name = "id", updatable = false)
	private int id;

	// @Column(name = "empName")
	private String empName;

	// @Column(name = "last_name")
	private String coachDate;

	// @Column(name = "empRole")
	private String empPosition;

	// @Column(name = "role")
	private String coachName;

	// @Column(name = "phone_number")
	private String coachTopic;

	// @Column(name = "password")
	private String coachOutcome;

	// @Column(name = "creation_date")
	private String coachBenefits;

	// @Column(name = "modified_date")
	private String coachAction;

	// @Column(name = "modified_date")
	private String coachTimeline;
	
	// @Column(name = "modified_date")
	private String coachEvidence;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getEmpName()
	{
		return empName;
	}

	public void setEmpName(String empName)
	{
		this.empName = empName;
	}
	public String getCoachDate()
	{
		return coachDate;
	}

	public void setCoachDate(String coachDate)
	{
		this.coachDate = coachDate;
	}

	public String getEmpPosition()
	{
		return empPosition;
	}

	public void setEmpPosition(String empPosition)
	{
		this.empPosition = empPosition;
	}

	public String getCoachName()
	{
		return coachName;
	}

	public void setCoachName(String coachName)
	{
		this.coachName = coachName;
	}

	public String getCoachTopic()
	{
		return coachTopic;
	}

	public void setCoachTopic(String coachTopic)
	{
		this.coachTopic = coachTopic;
	}

	public String getCoachOutcome()
	{
		return coachOutcome;
	}

	public void setCoachOutcome(String coachOutcome)
	{
		this.coachOutcome = coachOutcome;
	}

	public String getCoachBenefits()
	{
		return coachBenefits;
	}

	public void setCoachBenefits(String coachBenefits)
	{
		this.coachBenefits = coachBenefits;
	}

	public String getCoachTimeline()
	{
		return coachTimeline;
	}

	public void setCoachTimeline(String coachTimeline)
	{
		this.coachTimeline = coachTimeline;
	}

	public String getCoachAction()
	{
		return coachAction;
	}

	public void setCoachAction(String coachAction)
	{
		this.coachAction = coachAction;
	}

	public String getCoachEvidence()
	{
		return coachEvidence;
	}

	public void setCoachEvidence(String coachEvidence)
	{
		this.coachEvidence = coachEvidence;
	}
}
