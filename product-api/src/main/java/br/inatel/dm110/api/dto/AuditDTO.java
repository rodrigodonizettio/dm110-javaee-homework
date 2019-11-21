package br.inatel.dm110.api.dto;

import java.io.Serializable;
import java.util.Date;

public class AuditDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Integer code;
	private String operation;
	private Date date;
	
	public AuditDTO() { }

	public AuditDTO(Integer id, Integer code, String operation, Date date) {
		super();
		this.id = id;
		this.code = code;
		this.operation = operation;
		this.date = date;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public String toString() {
		return "AuditDTO ["
				+ "id=" + id
				+ ", code=" + code
				+ ", operation=" + operation
				+ ", date=" + date + "]";			
	}
}
