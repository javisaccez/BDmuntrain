package model;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the question database table.
 * 
 */
@Entity
@Table (name = "question")
@NamedQuery(name="Question.findAll", query="SELECT q FROM Question q")
public class Question implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "id")
	private int id;

	@Lob
	@Column(name = "description")
	private String description;
	

	public Question() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}