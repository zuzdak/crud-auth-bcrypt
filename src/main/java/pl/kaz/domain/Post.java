package pl.kaz.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import pl.kaz.json.JsonDateSerializer;


@Entity
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty
	private String title;

	@NotEmpty
	private String slug;
	
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat ( pattern="yyyy-MM-dd HH:mm:ss")
	private Date postedOn;	
	
	@Size(min=1, max=2)
	@ElementCollection
	private List<String> keywords;
	
	private Boolean active;
	
	@NotNull
	@ManyToOne
	private Author author;
	
	@Column(columnDefinition = "TEXT")
	private String teaser;
	
	@NotEmpty
	@Column(columnDefinition = "TEXT")
	private String body;
	
	public Post(){
		this.postedOn = new Date();
		this.active = true;
	}
	
	public Post(String title){
		this.setTitle(title);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	@JsonSerialize(using=JsonDateSerializer.class) 
	public Date getPostedOn() {
		return postedOn;
	}

	public void setPostedOn(Date postedOn) {
		this.postedOn = postedOn;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}
	
	public String getTeaser() {
		return teaser;
	}

	public void setTeaser(String teaser) {
		this.teaser = teaser;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public List<String> getKeywords() {
		return keywords;
	}

	public void setKeywords(List<String> keywords) {
		this.keywords = keywords;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "Post [title=" + title + "]";
	}
	
}
