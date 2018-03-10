package priv.obfu.chaosFunComp;

import java.util.Scanner;

import javax.sound.midi.Sequence;

public class DataObfu {
	private static double x[]={0.23, 0.24, 0.25, 0.26, 0.27};
	private static double y[]={0.23, 0.24, 0.25, 0.26, 0.27};
	private static int h[][]={{1,4,3,4,5,6},{0,3,3,4,5},{1,2,8,9}} ; 
	private static int chaos(double x, double y, int h[]){
		int N[] = new int[600];
    	int ans = 0;
    	int L = 0;
    	for(int i = 1; i <=1 ; i++){
    		if(h[i] > L)L = h[i];
    	}
    	for(int i = 1; i <= L; i++){
 		   if(x <= 0.43){
 			  if(y <= 0.57){
 		         x /= 0.43;
 			     y /= 0.57;
 			  }
 			  else{
 				 x /= 0.43;
 			     y = (1-y)/0.43;
 			  }
 		   }else{
 			  if(y <= 0.57){
 				  x = (1-x) / 0.57;
 				  y /= 0.57;
 			  }else{
 				  x = (1-x) / 0.57;
				  y = (1-y) / 0.43;
 			  }
 			} 
 			double d = (x + y) * 10;
            int ying = (int) Math.floor(d);
 			N[i] = ying;
 		} 
    	for(int i = 1; i >= 1; i--){
    		ans = ans * 10 + N[h[i]];
    	}
		return ans;
	}
	
	private static boolean isLeapYear(int year){
		/*int a1 = chaos(x[1], y[1], h[0]);
		int a2 = chaos(x[2], y[2], h[1]);
		int a3 = chaos(x[3], y[3], h[2]);
		if(year % a1 == 0 && year % a2 != 0 || year % a3 == 0){
            return true;
        }else{
            return false;
        }*/
		if(year%4 == 0 && year%100!=0 || year%400 == 0){//是闰年
            return true;
        }else{
            return false;
        }
	}
	private static boolean isOutOfRange(int year) {
		int a4 = chaos(x[1], y[1], h[0]);
		int a5 = chaos(x[2], y[2], h[1]);
        return year > a4 || year < a5;
    }
	private static int scannerYear(){
		Scanner scan = new Scanner(System.in);//创建输入流扫描器;
        String str = scan.nextLine();
        if (!str.matches("^-?[1-9][0-9]*$")) {
     	   System.out.println("Not an integer number! Input again:");
     	   return scannerYear(); 
     	}else{
     	   int year = Integer.parseInt(str);
     	   if(isOutOfRange(year)){
     		  System.out.println("Unusual year! Input again:");
     		  return scannerYear(); 
     	   }
     	   return year;
     	}
       
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Please input the start year as an integer number");
        int start = scannerYear();
        System.out.println("Please input the end year as an integer number");
        int end = scannerYear();
        if(start <= end){
        	int count = 0;
            for(int i = start; i <= end; i++){
               if(isLeapYear(i)){
            	  count++;
               }
            }
            System.out.println("answer:"+count);
        }else{
        	System.out.println("wrong input! No answer");
	    }
	}
}
