package kosa.api;

import java.util.Arrays;
import java.util.Scanner;

public class StringMission1_5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		
		String[] str = input.split("");
		for (int i = 0; i < str.length; i++) {
			if (str[i].matches("[\\{Alpha}]+")) {
				String tmp = str[str.length-1 - i];
				str[str.length-1 - i] = str[i];
				str[str.length-1 - i] = tmp;
			}
		}
		
		System.out.println(Arrays.toString(str));
		
	}
}
