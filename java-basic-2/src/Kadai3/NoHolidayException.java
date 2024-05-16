package Kadai3;

public class NoHolidayException extends Exception {


    @Override
    public void printStackTrace() {
        super.printStackTrace();
        System.err.println("5月のその日は平日だよ！はたらきたくないねー。エラーメッセージです。");
    }
}
