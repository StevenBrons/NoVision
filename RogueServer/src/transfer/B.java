package transfer;

/*
 * This class is used to transfer chunk data
 * it is a simplified version of the Chunk class
*/

public class B extends T {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	T[] bundle = new T[0];
	
	public B() {
	}

	public void addT(T obj) {
		T[] temp = new T[bundle.length + 1];
		System.arraycopy(bundle, 0, temp, 0, bundle.length);
		temp[bundle.length] = obj;
		bundle = temp;
	}

	public T[] getBundle() {
		return bundle;
	}

}
