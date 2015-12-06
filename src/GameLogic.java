
public class GameLogic {
	public GameLogic(Student a,Teacher b){
		a = new Student();
		b = new Teacher();
	}
	public GameLogic(Student a,Student a2,Teacher b){
		a = new Student();
		b = new Teacher();
	}
	public void hitButton(Student a, Teacher b) {
		if (!b.isLooking()) {
			a.plusScore();
		}
		if (b.isLooking()) {
			a.setGameOver(true);
		}
	}

	public void update(Student a, Teacher b) {
		a.update();
		b.update();
	}
}
