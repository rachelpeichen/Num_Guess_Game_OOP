package java335_ntu_lab;

public class TimerDemo {

	public static void main(String[] args) {
		
		int N = 1000;
		int[] A = new int[N];
		for (int i = 0; i < A.length; i++) {
			A[i] = (int) (Math.random() * 10000);
		}
		
		long t0 = System.nanoTime();
		boolean swapped;
		do {
			swapped = false;
			for (int i = 0; i < A.length - 1; i++) {
				if (A[i] > A[i + 1]) {
					int tmp = A[i];
					A[i] = A[i + 1];
					A[i + 1] = tmp;
					swapped = true;
				}
			}
		} while (swapped);
		long t1 = System.nanoTime();
		System.out.println("Time cost = " + (t1 - t0) / 1000000.0 + " ms");

	}

}
