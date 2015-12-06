
public class GameLogic {
	Student student1;
	Student student2;
	Teacher teacher;
	
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
	public GameLogic(){
		student1 = new Student();
		student2 = new Student();
		teacher = new Teacher();
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
