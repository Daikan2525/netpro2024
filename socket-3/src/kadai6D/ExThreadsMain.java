package kadai6D;

public class ExThreadsMain implements Runnable {

    private char alphabet;

    // main メソッドはプログラムのエントリーポイントです。
    public static void main(String[] args){
        char[] c = new char[26];
        ExThreadsMain[] ct = new ExThreadsMain[26];
        Thread[] th = new Thread[26];
        

        for(int i = 0; i < c.length;i++){
            c[i] = (char) (97 + i);
            ct[i] = new ExThreadsMain();
            ct[i].setChar(c[i]);
            th[i] = new Thread(ct[i]);

            th[i].start();
        }
        
/*
        // この try-catch ブロックは、0 から 9 までの値を 500 ミリ秒間隔で出力するループを実行します。
        try {
            for(int i = 0; i < 10; i++) {
                System.out.println("main:i=" + i);

                // メインスレッドを 500 ミリ秒間一時停止します。
                Thread.sleep(500);  // ミリ秒単位のスリープ時間
            }
        }
        catch(InterruptedException e) {
            // スレッドが中断された場合は、例外を出力します。
            System.err.println(e);
        }
*/
    }

    // run メソッドは、新しいスレッドが実行するコードを含みます。
    public void run() {
        try {
            for(int i = 0; i < 10; i++) {
                System.out.println(alphabet + "-" + i);

                Thread.sleep(1000);  // ミリ秒単位のスリープ時間
            }
        }
        catch(InterruptedException e) {
            // スレッドが中断された場合は、例外を出力します。
            System.err.println(e);
        }
    }

    void setChar(char ch){
        this.alphabet = ch;
    }
}


