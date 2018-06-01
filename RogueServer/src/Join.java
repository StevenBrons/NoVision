import java.io.Serializable;

public class Join implements Serializable{

	private static final long serialVersionUID = 1L;

	private String loginId;
	
	public Join(String loginId) {
		this.loginId = loginId;
	}
	
	public String getLoginId() {
		return loginId;
	}
}
