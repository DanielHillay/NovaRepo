package com.spearhead.nova.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AuditLogs extends DateAudit {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long autologId;
	@Column(nullable = false)
	private Integer user_id;
	@Column(columnDefinition = "JSON", nullable = false)
	private String action;
	
	private String status;
	
	public Long getAutologId() {
		return autologId;
	}
	public void setAutologId(Long autologId) {
		this.autologId = autologId;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public AuditLogs() {
		super();
	}

	@Override
	public String toString() {
		return "AuditLogs [autologId=" + autologId + ", user_id=" + user_id + ", action=" + action + ", status="
				+ status + "]";
	}
}
