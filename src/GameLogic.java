
public class GameLogic {
	private Student student1;
	private Student student2;
	private Teacher teacher;
	private Noodles noodles1;
	private Noodles noodles2;
	private Thread timeCount;
	private Thread lookableTeacher;
	public Thread getTimeCount() {
		return timeCount;
	}

	public void setTimeCount(Thread timeCount) {
		this.timeCount = timeCount;
	}

	public Thread getLookableTeacher() {
		return lookableTeacher;
	}

	public void setLookableTeacher(Thread lookableTeacher) {
		this.lookableTeacher = lookableTeacher;
	}

	private boolean gameOver;


	public boolean isGameOver() {
		return gameOver;
	}

	public void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
	}

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
		gameOver = false;
		lookableTeacher = new Thread(new Runnable() {

			@Override
			public synchronized void run() {
				while (true) {
					try {
						Thread.sleep(30);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if (getTeacher().counter > 0) {
						getTeacher().counter--;
					} else {
						getTeacher();
						getTeacher().stateChangingDelay = Teacher.random(150, 300);
						getTeacher().counter = getTeacher().stateChangingDelay;
						getTeacher().setLooking(!getTeacher().isLooking);
						if (getTeacher().isLooking) {
							getTeacher().switching++;
						}
					}

				}
			}
		});
		

		timeCount = new Thread(new Runnable() {

			@Override
			public synchronized void run() {
				while (true) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					getStudent1().setRemainingTime(getStudent1().getRemainingTime() - 1);
					if (getStudent1().getRemainingTime() <= 0) {
						setGameOver(true);
						getStudent1().setRemainingTime(0);
					}
				}
			}
		});
		
	}

	public void hitButton(Student a, Teacher b) {
		if (!isGameOver() && !a.isDecreaseScore()) {
			a.setEating(true);
			if (!b.isLooking()) {
				a.plusScore();
			}

		} else {
			return;
		}
	}

	public void update(Student a, Teacher b) {
		

		if (b.isLooking() && a.isEating() && !a.isDecreaseScore()) {
			a.setLife(a.getLife() - 1);
			a.setEating(false);
			a.setDecreaseScore(true);
		} else if (!b.isLooking()) {
			a.setDecreaseScore(false);
		}

	}

	public void update(Student a, Student c, Teacher b) {
	
		
		if (b.isLooking() && a.isEating() && !a.isDecreaseScore()) {
			a.setLife(a.getLife() - 1);
			a.setEating(false);
			a.setDecreaseScore(true);
		} else if (!b.isLooking()) {
			a.setDecreaseScore(false);
		}
		if (b.isLooking() && c.isEating() && !c.isDecreaseScore()) {
			c.setLife(c.getLife() - 1);
			c.setEating(false);
			c.setDecreaseScore(true);
		} else if (!b.isLooking()) {
			c.setDecreaseScore(false);
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
	
	public String winnerName(){
		if(Main.selectedMode == 3) {
			if(getStudent1().getScore() > getStudent2().getScore()){
				return "blossom";
			}
			else if (getStudent1().getScore() < getStudent2().getScore()){
				return "buttercup";
			} else {
				return "equal";
			}
		}
		else
			return "no";
	}
}