package pattern.action;

public class DeleteAction implements Action {

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		delete();
	}

	private void delete() {
		System.out.println("DELETE....OK !");
	}
}
