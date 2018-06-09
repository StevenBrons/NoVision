package transfer;


/*
 * This class is used to transfer action data
 * it is a simplified version of the Action class
*/

public class A extends T {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String title;
	private String description;
	private String name;
	private float successChance;

	public A(String name,String title, String description, float successChance) {
		this.name = name;
		this.title = title;
		this.description = description;
		this.successChance = successChance;
	}

	public String getName() {
		return name;
	}
	
	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public float getSuccessChance() {
		return successChance;
	}

}
