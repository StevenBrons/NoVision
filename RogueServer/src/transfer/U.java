package transfer;

/*
 * This class is used to bundle multiple transfer objects as one update
*/

public class U extends T {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String title;
	private String description;
	private A[] actions;

	public U(String title, String description, A[] actions) {
		this.title = title;
		this.description = description;
		this.actions = actions;
	}
	
	public U(String title, String description) {
		this.title = title;
		this.description = description;
		this.actions = new A[0];
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public T[] getActions() {
		return actions;
	}

}
