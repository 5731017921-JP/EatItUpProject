
public class OnePlayerLogic implements GameLogic{
	private Student student1;
	private Teacher teacher;
	private Noodles noodles1;

	public Student getStudent1() {
		return student1;
	}

	public void setStudent1(Student student1) {
		this.student1 = student1;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public OnePlayerLogic() {
		student1 = new Student(1);
		teacher = new Teacher();
		noodles1 = new Noodles(student1);
		
	}

	public void hitButton(Student a, Teacher b) {
		if (!a.isGameOver() && !a.isDecreaseScore()) {
			a.setEating(true);
			if (!b.isLooking()) {
				a.plusScore();
			}

		} else {
			return;
		}
	}



	public void update(Student a, Teacher b) {
		a.update();
		b.update();
		if (b.isLooking() && a.isEating() && !a.isDecreaseScore()) {
			a.setLife(a.getLife() - 1);
			a.setEating(false);
			a.setDecreaseScore(true);
		} else if (!b.isLooking()) {
			a.setDecreaseScore(false);
		}
	}

	

	public Noodles getNoodles1() {
		return noodles1;
	}

	public void setNoodles1(Noodles noodles1) {
		this.noodles1 = noodles1;
	}

	
}
