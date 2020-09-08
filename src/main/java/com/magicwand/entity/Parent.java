package com.magicwand.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "parent")
public class Parent {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "parent_generator")
	@SequenceGenerator(name="parent_generator", sequenceName = "parent_seq")
    private int parentId;
    private String name;

    @Override
	public String toString() {
		return "Parent [parentId=" + parentId + ", name=" + name + "]";
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	public List<Child> getChild() {
//		return child;
//	}
//
//	public void setChild(List<Child> child) {
//		this.child = child;
//	}
//
//	@OneToMany(mappedBy="parent",fetch=FetchType.LAZY,cascade = CascadeType.PERSIST)
//    private List<Child> child = new ArrayList<Child>();

}
