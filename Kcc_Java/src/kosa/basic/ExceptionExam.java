package kosa.basic;

public class ExceptionExam {

	public static void main(String[] args) {
		//
		try {
			System.out.println("1");	// O
			noEquals(10, 20);
			System.out.println("2");	// X -> O
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("3");	// O -> X
		} finally {
			System.out.println("4");	// O
		}
		System.out.println("5");		// O
		System.out.println("done...");	// O
	}

	private static void noEquals(int a, int b) throws Exception {
		if (a == b) {
			throw new Exception("같은 값 안돼");
		}
	}
}
