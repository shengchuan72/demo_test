package test.suanfa;

public class InsertSort {

	public static void main(String[] args) {
		int[] ints = {6,3,7,8,2,9,1};
		for (int i = 1; i < ints.length; i++) {
			//[i]<[i-1] -->j循环(从头开始到i前面,j循环目的是为了插入位置)
			if(ints[i]<ints[i-1]){
				for (int j = 0; j < i; j++) {
					if(ints[i]<ints[j]){
						int temp = ints[i];
						//i到j之间的数据向后移动以空出j位置给temp
						for (int k = i-1; k >= j; k--) {
							ints[k+1]= ints[k];//数据向后移
						}
						ints[j]=temp;
					}
				}
			}
		}
		
		for (int i = 0; i < ints.length; i++) {
			System.out.println(ints[i]);
		}
	}
}
