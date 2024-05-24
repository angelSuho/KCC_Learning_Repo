package kosa.task;

public class ArrayTask01 {

	public static void main(String[] args) {
		int number;
		
		// 1-1
		System.out.println("1-1");
		number = 5;
		int idx1 = 1;
		
		for (int i = 0; i < number; i++) {
			for (int j = 0; j < number; j++) {
				System.out.printf("%3d", idx1++);
			}
			System.out.println();
		}
		
		System.out.println();
		
		// 1-2
		System.out.println("1-2");
		number = 5;
		int currentNum = number*number;
		
		for (int i = 0; i < number; i++) {
			for (int j = number-1; j >= 0; j--) {
				System.out.printf("%3d", currentNum - j);
			}
			currentNum -= number;
			System.out.println();
		}
		
		System.out.println();
		
		// 1-3
		System.out.println("1-3");
		number = 5;
		int[] arr = new int[]{1, 3, 5, 7, 9};
		
		int cnt = 0;
		for (int i = 0; i < number; i++) {
			for (int j = 0; j < number; j++) {
				System.out.printf("%3d", arr[j] + 10*cnt);
			}
			cnt++;
			System.out.println();
		}
		
		System.out.println();
		
		// 1-4
		System.out.println("1-4");
		number = 5;
	
		for (int i = 1; i <= number; i++) {
			for (int j = 0; j < i; j++) {
				System.out.printf("%2d", j + 1);
			}
			System.out.println();
		}
		
		// 1-5
		System.out.println("1-5");
		number = 5;
		
		int idx2 = 1;
		for (int i = 1; i <= number; i++) {
			for (int j = 0; j < i; j++) {
				System.out.printf("%3d",idx2++);
			}
			System.out.println();
		}
		
		// 1-6
		number = 5;
		int[] arr2 = new int[] {1, 2, 3, 4, 5};
		
		for (int i = number; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				System.out.printf("%3d", arr2[j]);
			}
			System.out.println();
		}
		
		// 1-7
		number = 5;
		int idx3 = 1;
		
		for (int i = number; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				System.out.printf("%3d", idx3++);
			}
			System.out.println();
		}
		
		// 1-8
		number = 5;
		int[] arr3 = new int[] {1, 2, 3, 4, 5};
		
		for (int i = 0; i < number; i++) {
			for (int j = 0; j < number; j++) {
				System.out.print(arr3[j] + i + " ");
			}
			System.out.println();
		}
		
		// 1-9
		number = 5;
		int idx4 = 0;
		int[] arr4 = new int[] {1, 2, 3, 4, 5};
		
		for (int i = 0; i < number; i++) {
			for (int j = 0; j < number - idx4; j++) {
				System.out.print(arr4[j+idx4] + " ");
			}
			
			for (int h = 0; h < idx4; h++) {
				System.out.print(arr4[h] + " ");
			}
			System.out.println();
			idx4++;
		}
		
		// 1-10
		number = 5;
		int idx5 = 1;
		
		for (int i = 0; i < number; i++) {
			for (int j = number - i; j > 1; j--) {
				System.out.print(" ");
			}
			
			for (int h = 0; h <= i; h++) {
				System.out.print(idx5++ + " ");
			}
			System.out.println();
		}
		
		// 2-1
		number = 5;
		
		for (int i = 0; i < number; i++) {
			for (int j = 0; j < number; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		// 2-2
		number = 5;
		
		for (int i = 1; i <= number; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		// 2-3
		number = 5;
		
		for (int i = 1; i <= number; i++) {
			for (int j = number - i; j > 0; j--) {
				System.out.print(" ");
			}
			
			for (int h = 0; h < i + i -1; h++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		// 2-4
		number = 5;
		
		for (int i = 1; i <= number; i++) {
			for (int j = number - i; j > 0; j--) {
				System.out.print(" ");
			}
			
			for (int h = 0; h < i + i -1; h++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for (int i = number; i >= 0; i--) {
			for (int j = 0; j <= number - i; j++) {
				System.out.print(" ");
			}
			
			for (int h = i + i - 1; h > 0; h--) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		// 2-5
		number = 5;
		
		for (int i = 1; i <= number; i++) {
			for (int j = number - i; j > 0; j--) {
				System.out.print(" ");
			}
			
			for (int h = 0; h < i + i -1; h++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for (int i = number-1; i >= 1; i--) {
			for (int j = 0; j <= number - i - 1; j++) {
				System.out.print(" ");
			}
			
			for (int h = i + i - 2; h >= 0; h--) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		// 2-6
		number = 5;
		
		for (int i = 1; i <= number; i++) {
			for (int j = number - i; j > 0; j--) {
				System.out.print(" ");
			}
			
			for (int h = 0; h < i + i -1; h++) {
				System.out.print("*");
			}
			for (int j = number - i; j > 0; j--) {
				System.out.print(" ");
			}
			for (int j = number - i; j > 0; j--) {
				System.out.print(" ");
			}
			for (int h = 0; h < i + i -1; h++) {
				System.out.print("*");
			}
			for (int j = number - i; j > 0; j--) {
				System.out.print(" ");
			}
			System.out.println();
		}
		for (int i = number-1; i >= 1; i--) {
			for (int j = 0; j <= number - i - 1; j++) {
				System.out.print(" ");
			}

			for (int h = i + i - 2; h >= 0; h--) {
				System.out.print("*");
			}
			for (int j = 0; j <= number - i - 1; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j <= number - i - 1; j++) {
				System.out.print(" ");
			}

			for (int h = i + i - 2; h >= 0; h--) {
				System.out.print("*");
			}
			for (int j = 0; j <= number - i - 1; j++) {
				System.out.print(" ");
			}
			System.out.println();
		}
		
		// 2-7
		number = 5;
		
		for (int i = 1; i <= number; i++) {
			for (int j = number - i; j > 0; j--) {
				System.out.print(" ");
			}
			for (int h = 0; h < i + i -1; h++) {
				System.out.print("*");
			}
			for (int j = number - i; j > 0; j--) {
				System.out.print(" ");
			}
			for (int j = number - i; j > 0; j--) {
				System.out.print(" ");
			}
			for (int j = number - i; j > 0; j--) {
				System.out.print("*");
			}
			for (int h = 0; h < i + i -1; h++) {
				System.out.print("*");
			}
			for (int j = number - i; j > 0; j--) {
				System.out.print("*");
			}
			for (int h = 0; h < i + i -1; h++) {
				System.out.print("*");
			}
			for (int j = number - i; j > 0; j--) {
				System.out.print(" ");
			}
			for (int j = number - i; j > 0; j--) {
				System.out.print(" ");
			}
			for (int h = 0; h < i + i -1; h++) {
				System.out.print("*");
			}
			for (int j = number - i; j > 0; j--) {
				System.out.print(" ");
			}
			for (int j = number - i; j > 0; j--) {
				System.out.print(" ");
			}
			System.out.println();
		}
		
		// 2-9
		 number = 5;
	      for (int i=0; i<number+2; i++) {
	         if (i == 0 || i == number+1) {
	            for (int j=0; j<number+2; j++) {
	               System.out.print("$");
	            }
	         } else {
	            System.out.print("$");
	            for (int k=0; k<number; k++) {
	               System.out.print("*");
	            }
	            System.out.print("$");
	         }
	         System.out.println();
	      }
		
	}

}
