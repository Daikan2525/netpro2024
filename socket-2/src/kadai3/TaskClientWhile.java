package kadai3;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.BindException;
import java.net.Socket; //ネットワーク関連のパッケージを利用する
import java.util.Scanner;

public class TaskClientWhile {

    public static void main(String arg[]) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("ポートを入力してください(5000など) → ");
            int port = scanner.nextInt();
            System.out.println("localhostの" + port + "番ポートに接続を要求します");
            Socket socket = new Socket("localhost", port);
            //scanner.close();
            System.out.println("接続されました");
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            
            while(true){
                
                System.out.println("整数値を入力してください ↓");
                int number = Integer.valueOf(scanner.next());

                TaskObject object = new TaskObject();
                object.setExecNumber(number);

                oos.writeObject(object);
                oos.flush();

                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

                TaskObject backObject = (TaskObject) ois.readObject();

                System.out.println("サーバからの解答は" + backObject.getResult());
                
                if(number < 2){
                    System.out.println("1以下の整数値が入力されたため終了します");
                    ois.close();
                    oos.close();
                    break;
                }
            }
            
            
            
            scanner.close();
            socket.close();

        } // エラーが発生したらエラーメッセージを表示してプログラムを終了する
        catch (BindException be) {
            be.printStackTrace();
            System.err.println("ポート番号が不正か、サーバが起動していません");
            System.err.println("サーバが起動しているか確認してください");
            System.err.println("別のポート番号を指定してください(6000など)");
        } catch (Exception e) {
            System.err.println("エラーが発生したのでプログラムを終了します");
            throw new RuntimeException(e);
        }
    }
}



