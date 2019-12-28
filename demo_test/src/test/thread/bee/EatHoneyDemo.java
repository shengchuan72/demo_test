package test.thread.bee;
/**
 * 熊吃蜂蜜问题
 * 2只熊，100只蜜蜂，
 * 蜜蜂每次生产蜂蜜量为1，罐子的容量最多为50，当罐子的蜜蜂量达到20时可以被熊吃
 * 罐子使用单列模式实现
 * @author shengchuan
 *
 */
public class EatHoneyDemo {

	static class Box{
		
		private static Box instance;
		public Box(){
		}
		
		public static Box getInstance(){
			if(instance !=null ){
				return instance;
			}
			synchronized (Box.class) {
				if(instance == null){
					instance = new Box();
				}
				return instance;
			}
		}
		public static int MAX = 50;
		
		public int current = 0;
		
		public synchronized void addOne(){
			while (current == MAX) {
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
			current ++;
			this.notify();
		}
		
		// 满20清空罐子
		public synchronized int clean(){
			while(current < 20){
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			int tem = current;
			current = 0;
			this.notifyAll();
			return tem;
		}
	}
	
	static class Bee extends Thread{
		private String beeNo;
		
		public Bee(String beeNo){
			this.beeNo = beeNo;
		}
		public void run(){
			Box box = Box.getInstance();
			for(;;){
				box.addOne();
				System.out.println(beeNo + "\t:"+ 1);
			}
		}
	}
	
	static class Bear extends Thread{
		private String bearName;
		public Bear(String bearName){
			this.bearName = bearName;
		}
		
		public void run(){
			Box box = Box.getInstance();
			for(;;){
				int cnt = box.clean();
				System.out.println(bearName + "\t:" + cnt);
			}
		}
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			Bee bee = new Bee("Bee" + i);
			bee.start();
		}
		
		Bear b1 = new Bear("熊大");
		Bear b2 = new Bear("熊二");
		b1.start();
		b2.start();
	}
}
