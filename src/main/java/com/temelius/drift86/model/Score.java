package com.temelius.drift86.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Score {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String username;
	private String points;
	private String time;
	private boolean multiplayer;
	private boolean verified;
	private String photo;
	
	@ManyToOne
	@JoinColumn(name = "mapId")
	@JsonManagedReference
	private Map map;
	
	@ManyToOne
	@JoinColumn(name = "carId")
	@JsonManagedReference
	private Car car;
	
	public Score() {}
	
	public Score(String username, String points, String time, boolean multiplayer, boolean verified, Car car, Map map) {
		super();
		this.username = username;
		this.points = points;
		this.time = time;
		this.multiplayer = multiplayer;
		this.verified = verified;
		this.car = car;
		this.map = map;
	}
	
	public String getPhotoPath() {
		if (photo == null) return null;
		return "images/" + photo;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getPoints() {
		return points;
	}

	public void setPoints(String points) {
		this.points = points;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public boolean isMultiplayer() {
		return multiplayer;
	}

	public void setMultiplayer(boolean multiplayer) {
		this.multiplayer = multiplayer;
	}

	public boolean isVerified() {
		return verified;
	}

	public void setVerified(boolean verified) {
		this.verified = verified;
	}

	public Map getMap() {
		return map;
	}

	public void setMap(Map map) {
		this.map = map;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}
	
}
