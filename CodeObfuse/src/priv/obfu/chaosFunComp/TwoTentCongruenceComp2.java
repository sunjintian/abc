package priv.obfu.chaosFunComp;
import java.util.Random;

public class TwoTentCongruenceComp2 {
	private static String ObfuFunction =
			"public int evaluate(double x, double y,int h[]){\n" +
		    "    int N[] = new int[600];\n" +
		    "    int ans = 0;\n" +
		    "    int L = 0;\n" +
            "    for(int i = 1; i <=1 ; i++){\n" +
            "       if(h[i] > L)L = h[i];\n" +
            "    }\n" +
            "    for(int i = 1; i <= L; i++){\n" +
            "        if(x <= 0.43){\n" +
            "           if(y <= 0.57){\n" +
            "              x /= 0.43;\n" +
            "              y /= 0.57;\n" +
            "           }\n" +
            "           else{\n" +
            "              x /= 0.43;\n" +
            "              y = (1-y)/0.43;\n" +
            "           }\n"+
            "        }else{\n" +
            "           if(y <= 0.57){\n" +
            "              x = (1-x) / 0.57;\n" +
            "              y /= 0.57;\n"+
	        "           }else{\n" +
	        "              x = (1-x) / 0.57;\n"+
            "              y = (1-y) / 0.43;\n" +
            "           }\n"+
            "        }\n" +
            "        double d = (x + y) * 10;\n"+
            "        int ying = (int) Math.floor(d);\n"+
            "        N[i] = ying;\n"+
            "    }\n"+
            "    for(int i = 1; i >= 1; i--){\n"+
            "        ans = ans * 10 + N[h[i]];\n"+
            "    }\n"+
            "    return ans;\n"+
            "}\n";
	public static String getObfuFunction() {
		return ObfuFunction;
	}
    private static boolean chaosKey(double x, double y, int num){
    	int flag[] = new int[10];
    	int wei;
    	int shu = 0;
    	while(num > 0){
    		wei = num % 10;
    		num /= 10;
    		if(flag[wei] == 0){
    		   flag[wei] = 1;
    		   shu ++;
    		}
    	}
    	for(int i = 1; i <= 26; i++){
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
 			if(flag[ying] == 1){
 				flag[ying] = 0;
 				shu--;
 			}
 			if(shu == 0) return true;
 		} 
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int count;
		int ans = 0;
		double x; 
		double y;
		long s=System.currentTimeMillis();  //获取开始时间
		while(true){
			   x = new Random().nextDouble();
			   y = new Random().nextDouble();
			   if(chaosKey(x,y,1234567890)){
				   break;
			   }
		}
		System.out.println("ChaosKey.main()"+x+", "+y);
		long e=System.currentTimeMillis(); //获取结束时间
        System.out.println("程序运行时间： "+(e-s)+"ms");
	}

}
