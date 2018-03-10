package 剑指offer;

import java.util.Iterator;

public class 题581翻转单词顺序 {
	
	public static String reverse(String str){
		if (str.length()==0||str==null) return null;
		//第一步：反转所有字符
		StringBuilder SB = new StringBuilder();
		for (int i = str.length()-1; i >= 0; i--) 
			SB.append(str.charAt(i));
		
		//第二步：反转被反转的单词
		int start = 0;int end = 0;
		String temp = null;
		while (end<=str.length()-1) {
			while (end<=str.length()-1&&SB.charAt(end)!=' ') 
				end++;
			temp = SB.substring(start,end);
			int length = temp.length();
			for (int i = start; i < end; i++) {
				int last = length-(i-start)-1;
				SB.setCharAt(i, temp.charAt(last));
			}
			//跳过当前的 空格
			start=end+1;
			end++;
		}
		
		return SB.toString();
	}
	
	
	
	
	
	
	/*public static String reverse(String str){
        StringBuilder stringBuilder = new StringBuilder(str);
        reverseSubString(stringBuilder,0,stringBuilder.length()-1);
        int start = 0,end = stringBuilder.indexOf(" ");
        while (start<stringBuilder.length()&&end!=-1){
            reverseSubString(stringBuilder,start,end-1);
            start = end+1;
            end = stringBuilder.indexOf(" ",start);
        }
        if(start<stringBuilder.length())
            reverseSubString(stringBuilder,start,stringBuilder.length()-1);
        return stringBuilder.toString();
    }
    //翻转stringBuilder[start,end]
    public static void reverseSubString(StringBuilder stringBuilder,int start,int end){
        for(int i=start;i<=start+(end-start)/2;i++){
            char temp = stringBuilder.charAt(i);
            stringBuilder.setCharAt(i,stringBuilder.charAt(end-i+start));
            stringBuilder.setCharAt(end-i+start,temp);
        }
    }*/

	public static void main(String[] args){
	    System.out.println(reverse("I am a student.")); 
	    System.out.println(reverse("Ia am a student.")); 
	    System.out.println(reverse("Iaa am a student.")); 
	    //System.out.println("asdf".substring(0,2));
	}

	
}
