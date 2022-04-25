package fourth.coachingapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "progress")
@DynamicInsert
@DynamicUpdate
public class Progress
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false)
	private int id;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "coachform_id", updatable = false)
	private CoachForm coachForm;

	@Column(name = "progress")
	private String progress;

	@Column(name = "creation_date")
	private String creationDate;

	@Column(name = "modified_date")
	private String modifiedDate;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public CoachForm getCoachForm()
	{
		return coachForm;
	}

	public void setCoachForm(CoachForm coachForm)
	{
		this.coachForm = coachForm;
	}

	public String getProgress()
	{
		return progress;
	}

	public void setProgress(String progress)
	{
		this.progress = progress;
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

	@Override
	public String toString()
	{
		return "Progress [id=" + id + ", coachForm=" + coachForm + ", progress=" + progress + ", creationDate="
				+ creationDate + ", modifiedDate=" + modifiedDate + "]";
	}

}
