package fourth.coachingapp.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "coachform")
public class CoachForm
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false)
	private int id;

	@ManyToOne(
			fetch = FetchType.EAGER,
			cascade = { CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST })
	@JoinColumn(name = "trainee", updatable = false)
	private User trainee;

	@Column(name = "trainee_position")
	private String traineePosition;

	@ManyToOne(
			fetch = FetchType.EAGER,
			cascade = { CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST })
	@JoinColumn(name = "coach", updatable = false)
	private User coach;

	@Column(name = "coaching_topic")
	private String coachingTopic;

	@Column(name = "desired_outcome")
	private String desiredOutcome;

	@Column(name = "benefits_of_change")
	private String benefitsOfChange;

	@Column(name = "action_plan")
	private String actionPlan;

	@Column(name = "timeline")
	private String timeline;

	@Column(name = "creation_date", updatable = false)
	private String creationDate;

	@Column(name = "modified_date", updatable = false)
	private String modifiedDate;

	@OneToMany(fetch = FetchType.EAGER,
			cascade = CascadeType.ALL,
			mappedBy = "coachForm")
	private List<Progress> progress;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public User getTrainee()
	{
		return trainee;
	}

	public void setTrainee(User trainee)
	{
		this.trainee = trainee;
	}

	public String getTraineePosition()
	{
		return traineePosition;
	}

	public void setTraineePosition(String traineePosition)
	{
		this.traineePosition = traineePosition;
	}

	public User getCoach()
	{
		return coach;
	}

	public void setCoach(User coach)
	{
		this.coach = coach;
	}

	public String getCoachingTopic()
	{
		return coachingTopic;
	}

	public void setCoachingTopic(String coachingTopic)
	{
		this.coachingTopic = coachingTopic;
	}

	public String getDesiredOutcome()
	{
		return desiredOutcome;
	}

	public void setDesiredOutcome(String desiredOutcome)
	{
		this.desiredOutcome = desiredOutcome;
	}

	public String getBenefitsOfChange()
	{
		return benefitsOfChange;
	}

	public void setBenefitsOfChange(String benefitsOfChange)
	{
		this.benefitsOfChange = benefitsOfChange;
	}

	public String getActionPlan()
	{
		return actionPlan;
	}

	public void setActionPlan(String actionPlan)
	{
		this.actionPlan = actionPlan;
	}

	public String getTimeline()
	{
		return timeline;
	}

	public void setTimeline(String timeline)
	{
		this.timeline = timeline;
	}

	public String getCreationDate()
	{
		return creationDate;
	}

	public void setCreationDate(String creationDate)
	{
		this.creationDate = creationDate;
	}

	public String getModifiedDate()
	{
		return modifiedDate;
	}

	public void setModifiedDate(String modifiedDate)
	{
		this.modifiedDate = modifiedDate;
	}

	public List<Progress> getProgress()
	{
		return progress;
	}

	public void setProgress(List<Progress> progress)
	{
		this.progress = progress;
	}

	@Override
	public String toString()
	{
		return "CoachForm [id=" + id + ", trainee=" + trainee + ", traineePosition=" + traineePosition + ", coach="
				+ coach + ", coachingTopic=" + coachingTopic + ", desiredOutcome=" + desiredOutcome
				+ ", benefitsOfChange=" + benefitsOfChange + ", actionPlan=" + actionPlan + ", timeline=" + timeline
				+ ", creationDate=" + creationDate + ", modifiedDate=" + modifiedDate + ", progress=" + progress
				+ ", getId()=" + getId() + ", getTrainee()=" + getTrainee() + ", getTraineePosition()="
				+ getTraineePosition() + ", getCoach()=" + getCoach() + ", getCoachingTopic()=" + getCoachingTopic()
				+ ", getDesiredOutcome()=" + getDesiredOutcome() + ", getBenefitsOfChange()=" + getBenefitsOfChange()
				+ ", getActionPlan()=" + getActionPlan() + ", getTimeline()=" + getTimeline() + ", getCreationDate()="
				+ getCreationDate() + ", getModifiedDate()=" + getModifiedDate() + ", getProgress()=" + getProgress()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

}
