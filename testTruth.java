package test;

import java.util.HashMap;
import java.util.Scanner;

public class testTruth {
	public static HashMap hm = new HashMap();

	public static void main(String[] args) {
		int N; // no. of animals
		int K; // no. of clues
		int C; // type of clue
		int X, Y;
		Scanner stdin = new Scanner(System.in);
		N = stdin.nextInt();
		K = stdin.nextInt();
		int countFalse = 0;
		for (int d = 0; d < K; d++) {
			C = stdin.nextInt();
			X = stdin.nextInt();
			Y = stdin.nextInt();
			if (X <= N && Y <= N) {
				if (C == 1) {
					// add to Hashmap
					if (!checkAlreadyExist(X, Y))
						countFalse++;
				} else if (C == 2) {
					if (X == Y){
						countFalse++;
					} else{
						if (!eats(X,Y)){
							countFalse++;
						}
					}
				} else {
					System.out.println("error");
				}
			} else {
				countFalse++;
			}
		}
		 stdin.close();
		 System.out.print(countFalse);
	}

	public static boolean checkAlreadyExist(int d, int e) {
		boolean oneFlag = true;
		if (null == hm.get(d) && null == hm.get(e)) {
			hm.put(d, "W");
			hm.put(e, "W");
		} else if (null != hm.get(d) && null == hm.get(e)) {
			hm.put(e, hm.get(d));
		} else if (null != hm.get(e) && null == hm.get(d)) {
			hm.put(d, hm.get(e));
		} else if (null != hm.get(d) && null != hm.get(e)) {
			if (!hm.get(d).equals(hm.get(e)))
			oneFlag = false;
		}
		return oneFlag;
	}
	
	public static boolean eats(int d, int e){
		boolean twoFlag = true;
		if (null == hm.get(d) && null == hm.get(e)) {
			hm.put(d, "W");
			hm.put(e, "N");
		} else if (null != hm.get(d) && null == hm.get(e)) {
			if (hm.get(d).equals("W"))
				hm.put(e, "N");
			else if (hm.get(d).equals("N"))
				hm.put(e, "T");
			else if (hm.get(d).equals("T"))
				hm.put(e, "W");
		} else if (null != hm.get(e) && null == hm.get(d)) {
			if (hm.get(e).equals("N"))
				hm.put(d, "W");
			else if (hm.get(e).equals("W"))
				hm.put(d, "T");
			else if (hm.get(e).equals("T"))
				hm.put(d, "N");
		} else if (null != hm.get(d) && null != hm.get(e)) {
			if ((hm.get(d).equals("W") && hm.get(e).equals("N"))
					|| (hm.get(d).equals("N") && hm.get(e).equals("T"))
					|| (hm.get(d).equals("T") && hm.get(e).equals("W")))
				twoFlag = true;
			else 
				twoFlag = false;
		}
		return twoFlag;
	}
}
