package com.lockedme.model;

/**
 * 
 * @author Ricardo R. Rocha Filho
 *
 */
public class Archive {

	private String name;
	private String directory;
	private String root;
	private String extension;

	public Archive() {
		super();

	}

	public Archive(String name, String directory, String root, String extension) {
		super();
		this.name = name;
		this.directory = directory;
		this.root = root;
		this.extension = extension;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDirectory() {
		return directory;
	}

	public void setDirectory(String directory) {
		this.directory = directory;
	}

	public String getRoot() {
		return root;
	}

	public void setRoot(String root) {
		this.root = root;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	@Override
	public String toString() {
		return "File [name=" + name + ", directory=" + directory + "]";
	}

}