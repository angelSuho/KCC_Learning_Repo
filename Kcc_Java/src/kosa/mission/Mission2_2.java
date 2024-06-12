package kosa.mission;

import java.util.Arrays;

public class Mission2_2 {

	public static void main(String[] args) {
		// 성적관리 프로그램에서 여러명의 성적을 구현해보자.
		// 번호 국어 영어 수학  총점  평균
		//   1 90 80 70 240 80
		//   2 50 40 30 120 40
		// =====================
		// 	   90 120 100
		//	   45 60 50
		
		int[][] score = {
				{90, 80, 70},
				{50, 40, 30}
		};
		
		System.out.println("번호\t국어\t영어\t수학\t총점\t평균");
		for (int i = 0; i < score.length; i++) {
			int totalScore = sum(score[i]);
			System.out.println((i + 1) + "\t" + 
			score[i][0] + "\t" + score[i][1] + "\t" + score[i][2] + "\t" + 
					totalScore + "\t" + average(totalScore, score[i].length));
		}
		System.out.println("==============================================");
		
		int[] totalGrades = totalGradeBySubject(score);
		System.out.println("\t" + totalGrades[0] + "\t" + totalGrades[1] + "\t" + totalGrades[2]);
		
		float[] avgGrades = averageGradeBySubject(totalGrades, score.length);
		System.out.println("\t" + avgGrades[0] + "\t" + avgGrades[1] + "\t" + avgGrades[2]);
		
	}
	
	private static int sum(int[] arr) {
		int sum = 0;
		for (int num: arr) {
			sum += num;
		}
		
		return sum;
	}
	
	private static float average(int sum, float size) {
		return sum / size;
	}
	
	private static int[] totalGradeBySubject(int[][] score) {
		int totalGrades[] = new int[score[0].length];
		Arrays.fill(totalGrades, 0);
		for (int i = 0; i < score.length; i++) {
			for (int j = 0; j < score[0].length; j++) {
				totalGrades[j] += score[i][j];
			}
		}
		
		return totalGrades;
	}
	
	private static float[] averageGradeBySubject(int[] sum, float size) {
		float avgGrades[] = new float[sum.length];
		for (int i = 0; i < sum.length; i++) {
			avgGrades[i] = sum[i] / size;
		}
		
		return avgGrades;
	}
}
