package transfer;


/*
 * This class is used to transfer login data
*/


public class L extends T{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String loginId;
	
	public L() {
		this.loginId = Math.floor(Math.random() * 1000) + "";
	}
	
	public String getLoginId() {
		return loginId;
	}
	
}
