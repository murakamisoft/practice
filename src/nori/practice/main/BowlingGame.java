package nori.practice.main;

import java.util.Arrays;
import java.util.List;

public class BowlingGame {

	public int getScore(String str) {
		if ("-".equals(str)) {
			return 0;
		}
		return Integer.parseInt(str);
	}

	public int getAllScore(String str) {
		BowlingScoreMng mng = new BowlingScoreMng(str);
		mng.createList();
		List<String> list = getPanelList(str);
		return 0;
	}

	public List<String> getPanelList(String str) {
		String[] s = str.split("\\|", 0);
		return Arrays.asList(s);
	}

}
