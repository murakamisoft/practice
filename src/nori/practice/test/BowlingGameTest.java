package nori.practice.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import nori.practice.main.BowlingGame;
import nori.practice.main.BowlingScoreMng;
import nori.practice.main.Panel;

public class BowlingGameTest {
	BowlingGame game;
	BowlingScoreMng gameMng;
	//	- ガーター
	//	/ スペア
	//	X ストライク

	@Before
	public void setUp() {
		game = new BowlingGame();
		gameMng = new BowlingScoreMng(null);
	}

	@Test
	public void 文字列の1を渡すと数値の１が返却される() {
		assertEquals(game.getScore("1"), 1);
	}

	@Test
	public void 文字列の5を渡すと数値の5が返却される() {
		assertEquals(game.getScore("5"), 5);
	}

	@Test
	public void 文字列のハイフンを渡すと数値の0が返却される() {
		assertEquals(game.getScore("-"), 0);
	}

	@Test
	public void パネルがリストで返却されること() {
		String score = "11|22|33|44|55|66|77|88|99|100";
		List<String> sutList = game.getPanelList(score);
		assertEquals(sutList.get(0), "11");
		assertEquals(sutList.get(1), "22");
		assertEquals(sutList.get(2), "33");
		assertEquals(sutList.get(3), "44");
		assertEquals(sutList.get(4), "55");
		assertEquals(sutList.get(5), "66");
		assertEquals(sutList.get(6), "77");
		assertEquals(sutList.get(7), "88");
		assertEquals(sutList.get(8), "99");
		assertEquals(sutList.get(9), "100");
	}

	@Test
	public void 文字列の１と１を渡すと数値の２が返る() {
		String actual = "11";
		int excepted = 2;
		assertEquals(excepted, gameMng.getStrScore(actual));
	}

	@Test
	public void スコア文字列を渡すと合計が返却される() {
		String score = "11|22|33|44|55|66|77|88|99|123";
		int excepted = 1 + 1 + 2 + 2 + 3 + 3 + 4 + 4 + 5 + 5 + 6 + 6 + 7 + 7 + 8 + 8 + 9 + 9 + 1 + 0 + 0;
		gameMng = new BowlingScoreMng(score);
		gameMng.createList();
		ArrayList<Panel> sutList = gameMng.getPanelList();
		assertEquals(sutList.get(0).getNo(), 1);
		assertEquals(sutList.get(0).getOneRoll(), 1);
		assertEquals(sutList.get(0).getTwoRoll(), 1);
		assertEquals(sutList.get(0).getThreeRoll(), 0);

		assertEquals(sutList.get(1).getNo(), 2);
		assertEquals(sutList.get(1).getOneRoll(), 2);
		assertEquals(sutList.get(1).getTwoRoll(), 2);
		assertEquals(sutList.get(1).getThreeRoll(), 0);

		assertEquals(sutList.get(2).getNo(), 3);
		assertEquals(sutList.get(2).getOneRoll(), 3);
		assertEquals(sutList.get(2).getTwoRoll(), 3);
		assertEquals(sutList.get(2).getThreeRoll(), 0);

		assertEquals(sutList.get(3).getNo(), 4);
		assertEquals(sutList.get(3).getOneRoll(), 4);
		assertEquals(sutList.get(3).getTwoRoll(), 4);
		assertEquals(sutList.get(3).getThreeRoll(), 0);

		assertEquals(sutList.get(4).getNo(), 5);
		assertEquals(sutList.get(4).getOneRoll(), 5);
		assertEquals(sutList.get(4).getTwoRoll(), 5);
		assertEquals(sutList.get(4).getThreeRoll(), 0);

		assertEquals(sutList.get(5).getNo(), 6);
		assertEquals(sutList.get(5).getOneRoll(), 6);
		assertEquals(sutList.get(5).getTwoRoll(), 6);
		assertEquals(sutList.get(5).getThreeRoll(), 0);

		assertEquals(sutList.get(6).getNo(), 7);
		assertEquals(sutList.get(6).getOneRoll(), 7);
		assertEquals(sutList.get(6).getTwoRoll(), 7);
		assertEquals(sutList.get(6).getThreeRoll(), 0);

		assertEquals(sutList.get(7).getNo(), 8);
		assertEquals(sutList.get(7).getOneRoll(), 8);
		assertEquals(sutList.get(7).getTwoRoll(), 8);
		assertEquals(sutList.get(7).getThreeRoll(), 0);

		assertEquals(sutList.get(8).getNo(), 9);
		assertEquals(sutList.get(8).getOneRoll(), 9);
		assertEquals(sutList.get(8).getTwoRoll(), 9);
		assertEquals(sutList.get(8).getThreeRoll(), 0);

		assertEquals(sutList.get(9).getNo(), 10);
		assertEquals(sutList.get(9).getOneRoll(), 1);
		assertEquals(sutList.get(9).getTwoRoll(), 2);
		assertEquals(sutList.get(9).getThreeRoll(), 3);
	}

}
