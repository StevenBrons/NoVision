
public class Event {

	private Obj executor;
	private Obj target;
	private String name;

	public Event(Obj executor, Obj target, String name) {
		this.executor = executor;
		this.target = target;
		this.name = name;
	}

	public Obj getExecutor() {
		return executor;
	}
	
	public Obj getTarget() {
		return target;
	}

	public String getName() {
		return name;
	}
}
