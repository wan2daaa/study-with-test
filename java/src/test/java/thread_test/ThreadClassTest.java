package thread_test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.awt.*;

class ThreadClassTest {
	
	class TaskImplRunnable implements Runnable {

		@Override
		public void run() {
			// 스레드가 실행할 코드
		}
	}

	@Test
	void annonymous() throws Exception {
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				// 스레드가 실행할 코드
//				System.out.println("start Thread");
			}
		});

		thread.start();
	}

	@DisplayName("beep 이 다섯번 실행 후 -> 띵이 5번 출력된다.")
	@Test
	void eachBeepAndPrint() throws Exception {
		beepFiveTimes();
		printFiveTimes();
	}

	@DisplayName("beep 소리는 작업 스레드가 담당하고, 띵 은 메인 스레드가 출력해서 여러 스레드가 동시에 작동된다.")
	@Test
	void beepAndPrintWithThread() throws Exception {
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				beepFiveTimes();
			}
		});
		thread.start();

		printFiveTimes();

	}


	@Test
	void beepAndPrintWithThreadWithoutRunnable() throws Exception {
		Thread thread = new Thread() {
			@Override
			public void run() {
				beepFiveTimes();
			}
		};

		thread.start();

		printFiveTimes();
	}

	private static void beepFiveTimes() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();

		for (int i = 0; i < 5; i++) {
			toolkit.beep();
			try {
				Thread.sleep(500);

			} catch (Exception e) {
			}
		}
	}

	private void printFiveTimes() {
		for (int i = 0; i < 5; i++) {
			System.out.println("띵");
			try {
				Thread.sleep(500);

			} catch (Exception e) {}
		}
	}
}
