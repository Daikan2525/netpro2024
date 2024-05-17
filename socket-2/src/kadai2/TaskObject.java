package kadai2;

import java.io.Serializable;

public class TaskObject implements ITask,Serializable{
    int number;
    int answer;

    public void setExecNumber(int x){
        number = x;
    }

    public void exec(){
        answer = answerMaxPrime(number);
    }

    public int getResult(){
        return answer;
    }

    public static int answerMaxPrime(int n){
        int ans = 0;
        for(int i = n;i > 2;i--){
            if(isPrime(i)){
                ans = i;
                break;
            }
        }
        return ans;
    }

    public static boolean isPrime(int n){
        if (n <= 1) {
            return false;
        }
        if (n <= 3) {
            return true;
        }
        
        // 2と3の倍数以外の奇数を確認
        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }
        
        // 6k ± 1の形の数のみを確認
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        
        return true;
    }
}
