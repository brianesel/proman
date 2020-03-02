
package com.proman.saleforce.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
// @Table(name = "products")
public class Product {

	@Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;

	@NotBlank
	@Size(max = 40)
	private String name;

	@NotBlank
	@Size(max = 15)
	@Column(unique=true)
	private String color;

	@Size(max = 100)
	private int price;

	@JsonFormat(pattern = "yyyy-MM-dd")
	private String releaseDate;

	@Size(max = 200)
	private String type;

	@Size(max = 250)
	private String img;

	private int status;

	private String brand;

	public Product() {

	}

	public Product(String id, String name, String color, String releaseDate, String type,
			int price, String img, int status, String brand) {
		this.id = id;
		this.name = name;
		this.color = color;
		this.releaseDate = releaseDate;
		this.type = type;
		this.img = img;
		this.price = price;
		this.status = status;
		this.brand = brand;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getcolor() {
		return color;
	}

	public void setcolor(String color) {
		this.color = color;
	}

	public String getreleaseDate() {
		return releaseDate;
	}

	public void setreleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String gettype() {
		return type;
	}

	public void settype(String type) {
		this.type = type;
	}

	public String getimg() {
		return img;
	}

	public void setimg(String img) {
		this.img = img;
	}

	public int getprice() {
		return price;
	}

	public void setprice(int price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
