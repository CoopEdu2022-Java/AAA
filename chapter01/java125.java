
public class java125 {
    
	public static void main(String[] args) {
		
		max_min(3, 16);
	}
	
	
	
	/**
	 * 方法
	 * */
	
	public static void max_min(int m, int n) {
 
		int mm=m;
		
		int nn=n;
		
		int temp = 1;
 
		int yshu = 1;
 
		int bshu = m * n;
 
		if (n < m) {
 
			temp = n;
 
			n = m;
 
			m = temp;
 
		}
 
		while (m != 0) {
 
			temp = n % m;
 
			n = m;
 
			m = temp;
 
		}
 
		yshu = n;
 
		bshu /= n;
 
		System.out.println(mm + "和" + nn + "的最大公约数为" + yshu);
 
		System.out.println(mm + "和" + nn + "的最小公倍数为" + bshu);
 
	}

}
