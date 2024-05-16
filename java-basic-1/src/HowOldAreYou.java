import java.util.Calendar;
import java.util.Scanner;

public class HowOldAreYou {
    static String eraName;
    static int d;

    public static void main(String[] args){
        Calendar calendar = Calendar.getInstance();

        Scanner scanner = new Scanner(System.in);

        while(true){

            System.out.println("あなたの現在の年齢を入力してください：");

            String text = scanner.next();

            if(text.equals("q") ||text.equals("e")){
                break;
            }

            int age = Integer.valueOf(text);

            if(age < 0 || age > 119){
                System.out.println("0 ～ 119 の範囲で入力してください。");
                continue;
            }

            int year = calendar.get(Calendar.YEAR);

            int age2023 = age + (2030 - year);

            System.out.println("2030年は" + age2023 + "歳ですね");

            int birthYear = year - age;

            EraName(birthYear);

            System.out.println("あなたの生まれ年は" + eraName + (birthYear - d) + "です。");
        }

        scanner.close();
    }

    static void EraName(int birthYear){
        if(birthYear < 1912){
            eraName = "明治";
            d = 1867;
        }else if(birthYear < 1926){
            eraName = "大正";
            d = 1911;
        }else if(birthYear < 1989){
            eraName = "昭和";
            d = 1925;
        }else if(birthYear < 2019){
            eraName = "平成";
            d = 1988;
        }else{
            eraName = "令和";
            d = 2018;
        }
    }
}
