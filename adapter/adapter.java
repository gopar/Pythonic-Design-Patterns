public class OldSystem {
	public void oldExecute() {
		System.out.println("Executing method from OldSystem");
	}
}

public class NewSystem {
	public void execute() {
		System.out.println("Executing method from NewSystem");
	}
}

public interface SystemInterface {
	void execute();
}


public class OldSystemAdapter implements SystemInterface {
	private OldSystem oldSystem;

	public OldSystemAdapter(OldSystem oldSystem) {
		this.oldSystem = oldSystem;
	}

	@Override
	public void execute() {
		// setup
		oldSystem.oldExecute();
		// clean
	}
}


public class AdapterDemo {
	public static void main(String[] args) {
		SystemInterface newSystem = new NewSystem();
		SystemInterface oldSystem = new OldSystemAdapter(new OldSystem());

		newSystem.execute();
		oldSystem.execute();
	}
}
