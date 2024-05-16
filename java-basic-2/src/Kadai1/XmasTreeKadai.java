package Kadai1;

public class XmasTreeKadai {
    final static int n = 20;
    final static int m = 7;
	public static void main(String[] args) {
		for(int i = 0;i < n;i++){
            for(int j = 0;j < n + 1;j++){
                if(i + j > n){
                    System.out.print("**");
                }else{
                    if((i + j) % 3 == 0){
                        System.out.print("+");
                    }else{
                        System.out.print(" ");
                    }
                }
            }
            System.out.println();
        }

        for(int k = 0;k < m;k++){
            for(int l = 0;l < n;l++){
                if(l < n - 1){
                    System.out.print(" ");
                }else{
                    System.out.print("**");
                }
            }
            System.out.println();
        }
	}
}
