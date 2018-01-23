package com.leetcode.newround;

public class CanIWin {
	public static void main(String[] args) {
		CanIWin cw = new CanIWin();
		System.out.println(cw.canIWin(10, 11));
	}
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
    	if (desiredTotal == 0) {
    		return true;
    	}
    	if (maxChoosableInteger * (maxChoosableInteger + 1) / 2 < desiredTotal) {
    		return false;
    	}
        Boolean[] win = new Boolean[1 << maxChoosableInteger];
        int choosen = 0;
        return canWin(maxChoosableInteger, desiredTotal, win, choosen);
    }

	private boolean canWin(int maxChoosableInteger, int desiredTotal, Boolean[] win, int choosen) {
		if (win[choosen] != null) {
			return win[choosen];
		}
		if (desiredTotal <= 0) {
			win[choosen] = false;
			return false;
		}
		for(int i = 1; i<= maxChoosableInteger; i++) {
			int bit = 1 << (i - 1);
			if ((choosen & bit) == 0) {
				choosen ^= bit;
				boolean opponentWin = canWin(maxChoosableInteger, desiredTotal - i, win, choosen);
				choosen ^= bit;
				if (!opponentWin) {
					win[choosen] = true;
					return true;
				}
			}
		}
		win[choosen] = false;
		return false;
	}
}
