
public class TwoPlayerLogic extends OnePlayerLogic {
	private Student student1;
	private Student student2;
	private Teacher teacher;
	private Noodles noodles1;
	private Noodles noodles2;

	public Student getStudent2() {
		return student2;
	}

	public void setStudent2(Student student2) {
		this.student2 = student2;
	}

	public Noodles getNoodles2() {
		return noodles2;
	}

	public void setNoodles2(Noodles noodles2) {
		this.noodles2 = noodles2;
	}



	public TwoPlayerLogic() {
		student1 = new Student(1);
		student2 = new Student(2);
		teacher = new Teacher();
		noodles1 = new Noodles(student1);
		noodles2 = new Noodles(student2);
	}

	public void update(Student a, Student c, Teacher b) {
		a.update();
		c.update();
		b.update();
		if (b.isLooking() && a.isEating() && !a.isDecreaseScore() && !a.isGameOver()) {
			a.setLife(a.getLife() - 1);
			a.setEating(false);
			a.setDecreaseScore(true);
		} else if (!b.isLooking()) {
			a.setDecreaseScore(false);
		}
		if (b.isLooking() && c.isEating() && !c.isDecreaseScore() && !c.isGameOver()) {
			c.setLife(c.getLife() - 1);
			c.setEating(false);
			c.setDecreaseScore(true);
		} else if (!b.isLooking()) {
			c.setDecreaseScore(false);
		}
	}

}
