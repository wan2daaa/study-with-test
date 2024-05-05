package thread_test;

public class ThreadCanExtends extends Thread {

	@Override
	public void run() {
		// 스레드가 실행할 코드
	}

	Thread thread = new ThreadCanExtends();
}
