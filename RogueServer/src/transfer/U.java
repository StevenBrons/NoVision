package transfer;

import java.io.Serializable;

/*
 * This class is used to bundle multiple transfer objects as one update
*/

public class U implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String title;
	private String description;
	private T[] updates;

	public U(String title, String description) {
		this.title = title;
		this.description = description;
	}

	public void addUpdate(T trans) {
		if (updates == null) {
			updates = new T[1];
			updates[0] = trans;
		} else {
			T[] temp = updates;
			updates = new T[updates.length + 1];
			System.arraycopy(temp, 0, updates, 0, temp.length);
			updates[updates.length - 1] = trans;
		}
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public T[] getUpdates() {
		return updates;
	}

}
