package kosa.task;

public class ArrayTask01 {

	public static void main(String[] args) {
		int number = 7;
		
		// 1-1
		taskMethod1_1(number);
		
		// 1-2
		taskMethod1_2(number);
		
		// 1-3
		taskMethod1_3(number);
		
		// 1-4
		taskMethod1_4(number);
		
		// 1-5
		taskMethod1_5(number);
		
		// 1-6
		taskMethod1_6(number);
		
		// 1-7
		taskMethod1_7(number);
		
		// 1-8
		taskMethod1_8(number);
		
		// 1-9
		taskMethod1_9(number);
		
		// 1-10
		taskMethod1_10(number);
		
		// 2-1
		taskMethod2_1(number);
		
		// 2-2
		System.out.println("2-2) number = " + number);
		taskMethod2_2(number);
		System.out.println();
		
		// 2-3
		taskMethod2_3(number);
		
		// 2-4
		System.out.println("2-4) number = " + number);
		taskMethod2_4(number);
		System.out.println();
		
		// 2-5
		taskMethod2_5(number);
		
		// 2-6
		taskMethod2_6(number);
		
		// 2-7
		System.out.println("2-7) number = " + number);
		taskMethod2_7(number);
		System.out.println();

		// 2-8
		taskMethod2_8(number);
		
		// 2-9
	    taskMethod2_9(number);
	    
	    // 2-10
	    taskMethod2_10(number);
	}

	private static void taskMethod2_10(int number) {
		System.out.println("2-10) number = " + number);
		System.out.println("*");
	    for (int i = 1; i < number + 2; i++) {
	        System.out.print("*");

	        for (int j = 1; j < i; j++) {
	            System.out.print("@");
	        }
	        System.out.print("*");
	        System.out.println();
	    }
	    for (int i = number; i > 0; i--) {
	        System.out.print("*");

	        for (int j = i; j > 1; j--) {
	            System.out.print("@");
	        }
	        
	        System.out.print("*");
	        System.out.println();
	    }
	    System.out.println("*");
	}

	private static void taskMethod2_9(int number) {
		System.out.println("2-9) number = " + number);
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
	    System.out.println();
	}

	private static void taskMethod2_8(int number) {
		System.out.println("2-8) number = " + number);
		for (int i = 1; i <= number; i++) {
			for (int j = number - i; j > 0; j--) {
				System.out.print(" ");
			}
			for (int h = 0; h < i + i - 1; h++) {
				System.out.print(" ");
			}
			for (int j = number - i; j > 0; j--) {
				System.out.print(" ");
			}
			for (int j = number * 2 - i; j > 0; j--) {
				System.out.print(" ");
			}
			for (int h = 0; h < i + i - 1; h++) {
				System.out.print("*");
			}
		    System.out.println();
		}
		taskMethod2_7(number);
		System.out.println();
	}

	private static void taskMethod2_7(int number) {
		for (int i = 1; i <= number; i++) {
			for (int j = number - i; j > 0; j--) {
				System.out.print(" ");
			}
			for (int h = 0; h < i + i - 1; h++) {
				System.out.print("*");
			}
			for (int j = number - i; j > 0; j--) {
				System.out.print(" ");
			}
			for (int j = number - i; j > 0; j--) {
				System.out.print(" ");
			}
			for (int j = number - i + 1; j > 0; j--) {
				System.out.print("*");
			}
			for (int h = 0; h < i + i - 1; h++) {
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
			for (int h = 0; h < i + i - 1; h++) {
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
	}

	private static void taskMethod2_6(int number) {
		System.out.println("2-6) number = " + number);
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
		System.out.println();
	}

	private static void taskMethod2_5(int number) {
		System.out.println("2-5) number = " + number);
		taskMethod2_4(number);
		for (int i = number-1; i >= 1; i--) {
			for (int j = 0; j <= number - i - 1; j++) {
				System.out.print(" ");
			}
			
			for (int h = i + i - 2; h >= 0; h--) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
	}

	private static void taskMethod2_4(int number) {		
		for (int i = 1; i <= number; i++) {
			for (int j = number - i; j > 0; j--) {
				System.out.print(" ");
			}
			
			for (int h = 0; h < i + i -1; h++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	private static void taskMethod2_3(int number) {
		System.out.println("2-3) number = " + number);
		for (int i = 0; i < number; i++) {
			for (int j = number - i; j > 1; j--) {
				System.out.print(" ");
			}
			
			for (int h = 0; h <= i; h++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
	}

	private static void taskMethod2_2(int number) {
		for (int i = 1; i <= number; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	private static void taskMethod2_1(int number) {
		System.out.println("2-1) number = " + number);
		for (int i = 0; i < number; i++) {
			for (int j = 0; j < number; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
	}

	private static void taskMethod1_10(int number) {
		System.out.println("1-10) number = " + number);
		int idx5 = 1;
		
		for (int i = 0; i < number; i++) {
			for (int j = number - i; j > 1; j--) {
				System.out.printf("%3c", ' ');
			}
			
			for (int h = 0; h <= i; h++) {
				System.out.printf("%3d", idx5++);
			}
			System.out.println();
		}
		System.out.println();
	}

	private static void taskMethod1_9(int number) {
		System.out.println("1-9) number = " + number);
		int idx4 = 0;
		
		for (int i = 0; i < number; i++) {
			for (int j = idx4; j < number; j++) {
				System.out.print(j % number + 1 + " ");
			}
			
			for (int h = 0; h < idx4; h++) {
				System.out.print(h % number + 1 + " ");
			}
			System.out.println();
			idx4++;
		}
		System.out.println();
	}

	private static void taskMethod1_8(int number) {
		System.out.println("1-8) number = " + number);
		
		for (int i = 0; i < number; i++) {
			for (int j = 0; j < number; j++) {
				System.out.print(j % number + 1 + i + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	private static void taskMethod1_7(int number) {
		System.out.println("1-7) number = " + number);
		int idx3 = 1;
		
		for (int i = number; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				System.out.printf("%3d", idx3++);
			}
			System.out.println();
		}
		System.out.println();
	}

	private static void taskMethod1_6(int number) {
		System.out.println("1-6) number = " + number);
		int[] arr2 = new int[] {1, 2, 3, 4, 5};
		
		for (int i = number; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				System.out.printf("%3d", j % number + 1);
			}
			System.out.println();
		}
		System.out.println();
	}

	private static void taskMethod1_5(int number) {
		System.out.println("1-5) number = " + number);		
		int idx2 = 1;
		for (int i = 1; i <= number; i++) {
			for (int j = 0; j < i; j++) {
				System.out.printf("%3d",idx2++);
			}
			System.out.println();
		}
		System.out.println();
	}

	private static void taskMethod1_4(int number) {
		System.out.println("1-4) number = " + number);
		for (int i = 1; i <= number; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print(j + 1 + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	private static void taskMethod1_3(int number) {
		System.out.println("1-3) number = " + number);
		int[] arr = new int[]{1, 3, 5, 7, 9};
		
		int cnt = 0;
		for (int i = 0; i < number; i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.printf("%3d", arr[j] + 10*cnt);
			}
			cnt++;
			System.out.println();
		}
		System.out.println();
	}

	
	private static void taskMethod1_2(int number) {
		System.out.println("1-2) number = " + number);
		int currentNum = number*number;
		
		for (int i = 0; i < number; i++) {
			for (int j = number-1; j >= 0; j--) {
				System.out.printf("%3d", currentNum - j);
			}
			currentNum -= number;
			System.out.println();
		}
		System.out.println();
	}

	private static void taskMethod1_1(int number) {
		System.out.println("1-1) number =" + number);
		int idx1 = 1;
		
		for (int i = 0; i < number; i++) {
			for (int j = 0; j < number; j++) {
				System.out.printf("%3d", idx1++);
			}
			System.out.println();
		}
		
		System.out.println();
	}
}
