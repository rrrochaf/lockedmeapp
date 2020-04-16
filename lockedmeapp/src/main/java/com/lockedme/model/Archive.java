package com.lockedme.model;

/**
 * 
 * @author Ricardo R. Rocha Filho
 *
 */
public class Archive {

	private String name;
	private String location;

	public Archive() {
		super();

	}

	
	public Archive(String name, String location) {
		super();
		this.name = name;
		this.location = location;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "File [name=" + name + ", location=" + location + "]";
	}

}
