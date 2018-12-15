package nori.practice.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BowlingScoreMng {

	private String scoreStr;
	private ArrayList<Panel> panelList;

	public BowlingScoreMng(String str) {
		this.scoreStr = str;
	}

	public void createList() {
		this.panelList = new ArrayList<Panel>();
		Panel p = null;
		scoreStr = scoreStr.replace("-", "0");
		List<String> plist = Arrays.asList(scoreStr.split("\\|", 0));

		for (int i = 0; i < 10; i++) {
			p = new Panel();
			p.setNo(i + 1);
			p.setOneRoll(Integer.parseInt(plist.get(i).substring(0, 1)));
			if (plist.get(i).length() > 2) {
				p.setThreeRoll(Integer.parseInt(plist.get(i).substring(2, 3)));
			}
			if ("/".equals(plist.get(i).substring(1, 2))) {
				p.setSpare(true);
				this.panelList.add(p);
				continue;
			}
			p.setTwoRoll(Integer.parseInt(plist.get(i).substring(1, 2)));

			this.panelList.add(p);
		}

	}

	public int getStrScore(String str) {
		String s1 = str.substring(0, 1);
		int i1 = Integer.parseInt(s1);
		String s2 = str.substring(1, 2);
		int i2 = Integer.parseInt(s2);
		return i1 + i2;
	}

	public ArrayList<Panel> getPanelList() {
		return this.panelList;
	}

	public int getTotalScore() {
		int totalScore = 0;
		for (Panel panel : this.getPanelList()) {
			if (panel.isLast()) {
				panel.setOneRoll(0);
				panel.setTwoRoll(10);
				panel.setSpare(false);
			}
			if (panel.isSpare()) {
				int spareScore = getSpareScore(panel.getNo());
				panel.setSpareScore(spareScore);
			}
			totalScore += panel.getScore();
		}

		return totalScore;
	}

	private int getSpareScore(int no) {
		if (no >= 10) {
			return 0;
		}
		return this.panelList.get(no).getOneRoll();
	}

}
