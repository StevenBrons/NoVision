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
	private String label;
	private String name;
	private float successChance;

	public A(String name,String label, float successChance) {
		this.name = name;
		this.label = label;
		this.successChance = successChance;
	}

	public String getName() {
		return name;
	}
	
	public String getLabel() {
		return label;
	}

	public float getSuccessChance() {
		return successChance;
	}

}
