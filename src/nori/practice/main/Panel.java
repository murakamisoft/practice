package nori.practice.main;

public class Panel {
	private int no = 0;
	private int oneRoll = 0;
	private int twoRoll = 0;
	private int threeRoll = 0;
	private int spareScore = 0;
	private int score = 0;
	private boolean isSpare = false;

	public int getScore() {
		calsScore();
		return score;
	}

	private void calsScore() {
		if (isSpare()) {
			this.score = 10 + spareScore;
			return;
		}
		this.score = oneRoll + twoRoll + threeRoll;
	}

	public int getSpareScore() {
		return spareScore;
	}

	public void setSpareScore(int spareScore) {
		this.spareScore = spareScore;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getOneRoll() {
		return oneRoll;
	}

	public void setOneRoll(int oneRoll) {
		this.oneRoll = oneRoll;
	}

	public int getTwoRoll() {
		return twoRoll;
	}

	public void setTwoRoll(int twoRoll) {
		this.twoRoll = twoRoll;
	}

	public int getThreeRoll() {
		return threeRoll;
	}

	public void setThreeRoll(int threeRoll) {
		this.threeRoll = threeRoll;
	}

	public boolean isSpare() {
		return this.isSpare;
	}

	public void setSpare(boolean b) {
		this.isSpare = b;
	}

	public boolean isLast() {
		return no == 10;
	}
}
