package com.duolingo.app.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "categories")
public class Category implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idCategory")
	private int idCategory;
	
	@Column(name = "categoryName")
	private String categoryName;

	@ManyToOne()
	@JoinColumn(name = "idCourse")
	private Course idCourse;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "idCategory", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Level> levels;
	
	public Category() {}

	public Category(int idCategory, String categoryName, Course idCourse) {
		super();
		this.idCategory = idCategory;
		this.categoryName = categoryName;
		this.idCourse = idCourse;
	}

	public int getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Course getIdCourse() {
		return idCourse;
	}

	public void setIdCourse(Course idCourse) {
		this.idCourse = idCourse;
	}

	public List<Level> getLevels() {
		return levels;
	}

	public void setLevels(List<Level> levels) {
		this.levels = levels;
	}

	@Override
	public String toString() {
		return categoryName;
	}
}
