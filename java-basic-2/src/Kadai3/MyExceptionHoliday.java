package Kadai3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MyExceptionHoliday {

	public static void main(String[] args) {
		while(true){
			MyExceptionHoliday my =new MyExceptionHoliday();
		}
	}

	MyExceptionHoliday(){
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		// BufferedReader というのは、データ読み込みのクラス(型)
		// クラスの変数を作るには、new を使う。

		// readLine() は、入出力エラーの可能性がある。エラー処理がないとコンパイルできない。
		//  Java では、 try{ XXXXXXXX }  catch(エラーの型 変数) { XXXXXXXXXXXXXXXXXX} と書く
		try {
			System.out.println("何日ですか?");
			String line = reader.readLine();
			int theday = Integer.parseInt(line);
			System.out.println("日付" + theday + "日ですね。");

			test(theday);

		}
		catch(IOException e) {
			System.out.println(e);
		} catch (NoHolidayException e) {
			e.printStackTrace();
		}
	}

	void test(int theday) throws NoHolidayException{
		if(theday == 3 || theday == 4 ||theday == 5 ||theday == 6 ||theday == 11 ||theday == 12 ||theday == 18 ||theday == 19 ||theday == 25 ||theday == 26){
            System.out.println("5月" + theday + "日は休日です！！！");
		}else{
            throw new NoHolidayException();
        }
	}
}
