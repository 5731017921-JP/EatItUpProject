
public class GameLogic {
	private Student student1;
	private Student student2;
	private Teacher teacher;
	private Noodles noodles1;
	private Noodles noodles2;
	public Student getStudent1() {
		return student1;
	}

	public void setStudent1(Student student1) {
		this.student1 = student1;
	}

	public Student getStudent2() {
		return student2;
	}

	public void setStudent2(Student student2) {
		this.student2 = student2;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public GameLogic() {
		student1 = new Student(1);
		student2 = new Student(2);
		teacher = new Teacher();
		noodles1 = new Noodles(student1);
		noodles2 = new Noodles(student2);
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
		if(b.isLooking() && a.isEating() && !a.isDecreaseScore()){
			a.setLife(a.getLife() - 1);
			a.setEating(false);
			a.setDecreaseScore(true);
		}
		else if(!b.isLooking()){
			a.setDecreaseScore(false);
		}
	}

	public Noodles getNoodles1() {
		return noodles1;
	}

	public void setNoodles1(Noodles noodles1) {
		this.noodles1 = noodles1;
	}

	public Noodles getNoodles2() {
		return noodles2;
	}

	public void setNoodles2(Noodles noodles2) {
		this.noodles2 = noodles2;
	}
}
