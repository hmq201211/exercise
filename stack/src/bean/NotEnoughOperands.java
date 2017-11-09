package bean;

public class NotEnoughOperands extends RuntimeException {
	public NotEnoughOperands(String msg) {
		super(msg);
	}

}
