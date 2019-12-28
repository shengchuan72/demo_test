package test.thread.bee;

/**
 * 和尚吃馒头问题
 * 30个和尚，100个馒头，每个和尚至少吃一个馒头，最多不超过4个馒头
 * 满足上述条件，尽快将馒头吃完
 * @author shengchuan
 *
 */
public class MonkDemo {

	static class Boos{
		// 最大馒头量
		private final int MAX = 100;
		//当前馒头量
		private int currentBreadNo = MAX;
		
		private int uneatedMonks = 30;
		private static Boos instance;
		
		public Boos() {
		}
		
		public static Boos getInstance(){
			if (instance != null){
				return instance;
			}
			synchronized ( Boos.class) {
				if(instance == null){
					instance = new Boos();
				}
				return instance;
			}
		}

		public synchronized int getBread(Monk monk){
			// 判断和尚能否吃馒头，是否有可用馒头
			if(currentBreadNo == 0 || monk.eated == Monk.MAX){
				return 0;
			}
			if(monk.eated == 0){
				int temp = currentBreadNo;
				currentBreadNo --;
				uneatedMonks --;
				return temp;
			}else{
				// 判断是否还有多余馒头
				if(currentBreadNo <= uneatedMonks){
					return 0;
				}else{
					int temp = currentBreadNo;
					currentBreadNo --;
					return temp;
				}
				
			}
		}
	}
	static class Monk extends Thread{
		private String monkName;
		public static final int MAX = 4;
		public static final int MIN = 1;
		private int eated = 0;
		public String getMonkName() {
			return monkName;
		}
		public Monk(String monkName) {
			this.monkName = monkName;
		}
		
		public void run(){
			Boos boos = Boos.getInstance();
			for(;;){
				int no = boos.getBread(this);
				if(no == 0){
					break;
				}
				else{
					eated ++;
				}
			}
			System.out.println( monkName + "\t:" + eated);
		}
		
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < 30; i++) {
			 new Monk("monk:" + i).start();
		}
	}
}
