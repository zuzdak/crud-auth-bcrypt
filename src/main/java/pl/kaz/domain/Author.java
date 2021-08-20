package pl.kaz.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Author {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	@NotEmpty
	@Size(min=2, max=30)
	private String firstName;
	
	@NotNull
	@NotEmpty
	@Size(min=3, max=30)
	private String lastName;
	
	@NotEmpty
	@NotNull
	@Size(min=3, max=100)
	@Pattern(regexp=".+@.+\\.[a-z]+", message="Invalid email address!")
	private String email;
	
	@NotEmpty
	@NotNull
	@Size(min=7, max=12)
	private String userName;
	
	@NotEmpty
	@NotNull
	@Size(min=6, max=10)
	private String role;
	
	@NotEmpty
	@NotNull
	private String password;
	
	@Column(name="active")
	private boolean active = true ;

	// @SuppressWarnings("unused")
	public Author(){}
	
	/*public Author(String first, String last){
		this.setFirstName(first);
		this.setLastName(last);
	}*/
	
	public Author(Integer id, String firstName, String lastName, String email, String userName, String role,
			String password, boolean active) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.userName = userName;
		this.role = role;
		this.password = password;
		this.active = active;
	}

	/*public Author(String first, String last, String email, boolean active){
		this.setFirstName(first);
		this.setLastName(last);
		this.setEmail(email);
		this.active = active;
	}*/
	
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Author [firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
	
}
