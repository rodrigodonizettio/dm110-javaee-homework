package br.inatel.dm110.ejb.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="audit")
public class Audit  implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) //Must use this strategy to combine with BigSerial column in Postgres DB (Audit table)
	private Integer id;
	private Integer code;
	private String operation;
	private Date date; //TODO: Must self-generate current date + time when inserted in DB
	
	
	public Audit() { }
	
	public Audit(Integer id, Integer code, String operation, Date date) {
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
}
