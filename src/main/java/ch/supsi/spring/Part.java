package ch.supsi.spring;

public class Part {

	private long id;
	private String name;
	private String description;
	
	public Part(long id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public long getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String setDescription() {
		return description;
	}
}