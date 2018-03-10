package 剑指offer;

public class 题49丑数 {
	
	public static boolean isUgly(int number) {
		if (number == 0) {
			return false;
		}else {
			while (number%2==0) {
				number=number<<1;
			}while (number%3==0) {
				number=number/3;
			}while (number%5==0) {
				number=number/5;
			}
		}
		return (number==1)?true:false;
	}
	
	
	public static int getUglyBumber_Solution2(int index) {
		if (index<0) {
			return 0;
		}
		int[] uglyNumbers = new int[index];
		//定义第一个丑数为1，接下去为：2、3、4、5、6、8、9、10...
		uglyNumbers[0]=1;
		
		int nextUglyIndex=1, multiply2=0, multiply3=0, multiply5=0;
		
		while (nextUglyIndex < index) {
			int min = min(uglyNumbers[multiply2]*2, uglyNumbers[multiply3]*3, uglyNumbers[multiply5]*5);
			uglyNumbers[nextUglyIndex]=min;
			//把已有的每个丑数*2，得到若干个小于或等于M的结果，累计结果的数量
			while (uglyNumbers[multiply2]*2<=uglyNumbers[nextUglyIndex]) {
				++multiply2;
			}
			while (uglyNumbers[multiply3]*3<=uglyNumbers[nextUglyIndex]) {
				++multiply3;
			}
			while (uglyNumbers[multiply5]*5<=uglyNumbers[nextUglyIndex]) {
				++multiply5;
			}
			++nextUglyIndex;
			
		}
		return uglyNumbers[nextUglyIndex-1];
	}
    
	public static int min(int x,int y,int z){
        int temp = x<y?x:y;
        return temp<z?temp:z;
    }
	
	
	
	public static void main(String[] args) {
		 System.out.println(getUglyBumber_Solution2(10));
	}
}
