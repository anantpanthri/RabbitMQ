package com.example.RabbitMQ;


import javax.persistence.*;

@Entity
@Table(name= "car")
public final class CustomMessage {
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 private int id;
	 private int year;
	 private String make;
	 private String model;

    // Default constructor is needed to deserialize JSON
    public CustomMessage() {
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Override
	public String toString() {
		return "CustomMessage [id=" + id + ", year=" + year + ", make=" + make + ", model=" + model + "]";
	}
	
   
}
