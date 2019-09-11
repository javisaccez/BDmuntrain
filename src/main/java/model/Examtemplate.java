package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the examtemplate database table.
 * 
 */
@Entity
@NamedQuery(name="Examtemplate.findAll", query="SELECT e FROM Examtemplate e")
public class Examtemplate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@Column(name="descriptionET")
	private String descriptionET;

	@Column(name="isPublisher")
	private byte isPublisher;
	
	@Column(name="dificulty")
	private int dificulty;
	
	@OneToMany 
	@JoinColumn(name="id_question")
	private List<Question>question = new ArrayList<Question>();

	public Examtemplate() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescriptionET() {
		return this.descriptionET;
	}

	public void setDescriptionET(String descriptionET) {
		this.descriptionET = descriptionET;
	}

	public byte getIsPublisher() {
		return this.isPublisher;
	}

	public void setIsPublisher(byte isPublisher) {
		this.isPublisher = isPublisher;
	}

	public int getDificulty() {
		return dificulty;
	}

	public void setDificulty(int dificulty) {
		this.dificulty = dificulty;
	}
}