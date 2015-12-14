import resource.Resource;

public class GameLogic {
	private Student student1,student2;
	private Teacher teacher;
	private Noodles noodles1,noodles2;
	private Thread timeCount,lookableTeacher,bonusTimeAble;
	private boolean gameOver,bonusTime,timeOut;

	public Thread getBonusTimeAble() {
		return bonusTimeAble;
	}

	public void setBonusTimeAble(Thread bonusTimeAble) {
		this.bonusTimeAble = bonusTimeAble;
	}
	public boolean isBonusTime() {
		return bonusTime;
	}

	public void setBonusTime(boolean bonusTime) {
		this.bonusTime = bonusTime;
	}


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
		bonusTime = false;
		lookableTeacher = new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(30);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if (getTeacher().getCounter() > 0) {
						getTeacher().setCounter(getTeacher().getCounter()-1);
					} else {
						getTeacher().setStateChangingDelay(Teacher.random(150, 300));
						getTeacher().setCounter(getTeacher().getStateChangingDelay());
						getTeacher().setLooking(!getTeacher().isLooking);
						if (getTeacher().isLooking) {
							getTeacher().setSwitching(getTeacher().getSwitching()+1);
						}
					}
					if (gameOver || timeOut) {
						getTeacher().setLooking(false);
						break;
					}

				}
			}
		});

		timeCount = new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					Teacher.setRemainingTime(Teacher.getRemainingTime() - 1);
					if (Teacher.getRemainingTime() <= 0) {
						timeOut = true;
						Teacher.setRemainingTime(0);
					}
					if (gameOver || timeOut) {
						getStudent1().setEating(false);
						getStudent2().setEating(false);
						break;
					}
				}
			}
		});

		bonusTimeAble = new Thread(new Runnable() {
			boolean activate = false;

			@Override
			public void run() {

				while (true) {
					int randomTime = Teacher.random(10000, 30000);
					if (!activate) {
						try {
							Thread.sleep(randomTime);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} else if (activate) {
						try {
							Thread.sleep(15000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					bonusTime = !bonusTime;
					activate = !activate;
					if(activate){
						GameScreen.popup = new PopUp();
						Thread popUpThread = new Thread(new Runnable() {
							
							@Override
							public void run() {
								// TODO Auto-generated method stub
								
								for(int i = 0;i< 25000000;i++){
									synchronized (GameScreen.popup) {
										student1.setEating(false);
										student2.setEating(false);
										GameScreen.popup.setShow(true);
										GameScreen.popup.notifyAll();
									}
								}
								GameScreen.popup = null;
							}
						});
						popUpThread.start();
					}
					System.out.println(bonusTime);
					if (gameOver) {
						bonusTime = false;
						break;
					}
				}
			}

		});

	}

	public void hitButton(Student student, Teacher teacher) {

		if (!isGameOver() && !student.isLifeDecreased()) {
			student.setEating(true);
			Resource.eatingSound.play();
			if (!teacher.isLooking() && !bonusTime) {
				student.plusScore(1);
			}
			if (!teacher.isLooking() && bonusTime) {
				student.plusScore(2);
			}

		} else {
			return;
		}
	}

	public void update(Student student, Teacher teacher) {

		if (teacher.isLooking() && student.isEating() && !student.isLifeDecreased()) {
			student.setLife(student.getLife() - 1);
			if (student.getLife() <= 0) {
				gameOver = true;
			}
			student.setEating(false);
			student.setLifeDecreased(true);
		} else if (!teacher.isLooking()) {
			student.setLifeDecreased(false);
		}

	}

	public void update(Student student1, Student student2, Teacher teacher) {

		if (teacher.isLooking() && student1.isEating() && !student1.isLifeDecreased()) {
			student1.setLife(student1.getLife() - 1);
			if (student1.getLife() <= 0) {
				gameOver = true;
			}
			student1.setEating(false);
			student1.setLifeDecreased(true);
		} else if (!teacher.isLooking()) {
			student1.setLifeDecreased(false);
		}
		if (teacher.isLooking() && student2.isEating() && !student2.isLifeDecreased()) {
			student2.setLife(student2.getLife() - 1);
			if (student2.getLife() <= 0) {
				gameOver = true;
			}
			student2.setEating(false);
			student2.setLifeDecreased(true);
		} else if (!teacher.isLooking()) {
			student2.setLifeDecreased(false);
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

	public String winnerName() {
		if (Main.selectedMode == 3) {
			if (getStudent1().getScore() > getStudent2().getScore()) {
				return "blossom";
			} else if (getStudent1().getScore() < getStudent2().getScore()) {
				return "buttercup";
			} else {
				return "equal";
			}
		} else
			return "no";
	}
}