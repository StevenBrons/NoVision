package game;
import java.io.Serializable;

public interface Action extends Serializable{
	
	static final long serialVersionUID = 1L;

	public String getTitle();
	public default String getDescription() {
		return "";
	}

	public default void invoke(Obj executor,String...args) {
		if (Math.random() < getSuccessChance(executor, args)) {
			resolve();
		}else {
			reject();
		}
	}
	
	public default float getSuccessChance(Obj executor,String...args) {
		return 1;
	}
	
	public void resolve();
	
	public void reject();
}
