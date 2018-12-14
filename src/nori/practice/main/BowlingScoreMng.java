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
		List<String> plist = Arrays.asList(scoreStr.split("\\|", 0));
		int n = 1;
		for (String ps : plist) {
			p = new Panel();
			p.setNo(n);
			n++;
			p.setOneRoll(Integer.parseInt(ps.substring(0, 1)));
			p.setTwoRoll(Integer.parseInt(ps.substring(1, 2)));
			if (ps.length() > 2) {
				p.setThreeRoll(Integer.parseInt(ps.substring(2, 3)));
			}
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

}
