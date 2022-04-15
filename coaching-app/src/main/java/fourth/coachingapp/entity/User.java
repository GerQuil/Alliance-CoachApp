package fourth.coachingapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity

@DynamicInsert
@DynamicUpdate
@Table(name = "user")
public class User
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false)
	private int id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "email", updatable = false)
	private String email;

	@Column(name = "role")
	private String role;

	@Column(name = "phone_number")
	private String phoneNumber;

	@Column(name = "password")
	private String password;

	@Column(name = "disabled")
	private boolean disabled;

	@Column(name = "creation_date", updatable = false)
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

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getRole()
	{
		return role;
	}

	public void setRole(String role)
	{
		this.role = role;
	}

	public String getPhoneNumber()
	{
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}

	public String getPassword()
	{
		return password;
	}

	public boolean isDisabled()
	{
		return disabled;
	}

	public void setDisabled(boolean disabled)
	{
		this.disabled = disabled;
	}

	public void setPassword(String password)
	{
		this.password = password;
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
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", role="
				+ role + ", phoneNumber=" + phoneNumber + ", password=" + password + ", disabled=" + disabled
				+ ", creationDate=" + creationDate + ", modifiedDate=" + modifiedDate + "]";
	}

}
