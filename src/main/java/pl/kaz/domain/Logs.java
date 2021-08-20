package pl.kaz.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;



@Entity
public class Logs {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty
	@Column (length = 120)
	private String sessionId;

	@NotEmpty
	@Column (length = 12)
	private String userName;
	
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat ( pattern="yyyy-MM-dd HH:mm:ss")
	private Date logDate;	
	
	@NotNull
	@Column (length = 64)
	private String ip;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getLogDate() {
		return logDate;
	}

	public void setLogDate(Date logDate) {
		this.logDate = logDate;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Logs(Integer id, String sessionId, String userName, Date logDate , String ip) {
		this.id = id;
		this.sessionId = sessionId;
		this.userName = userName;
		this.logDate = logDate;
		this.ip = ip;  // 
	}

	public Logs() {
	
	}

	@Override
	public String toString() {
		return "Logs [id=" + id + ", sessionId=" + sessionId + ", userName=" + userName + ", logDate=" + logDate
				+ ", ip=" + ip + "]";
	}
	
		
}
