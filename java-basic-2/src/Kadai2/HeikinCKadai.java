package Kadai2;

import java.util.Random;

public class HeikinCKadai {
    final static int n = 100;
    public static void main(String[] args){
        Random random = new Random();
        Kamoku[] scores = new Kamoku[n];
        int sum = 0;
        
        for(int i = 0;i < n;i++){
            scores[i] = new Kamoku(random.nextInt(101));
            scores[i].name("数学");
            scores[i].setStudentid(i);

            sum += scores[i].getScore();
        }

        int average = sum / n;

        System.out.println("平均点は" + average + "点");
        System.out.println("以下は合格者の点数");

        for(Kamoku score : scores){
            if(score.getScore() >= 80){
                System.out.println("学生番号:" + score.getStudentid() + ",点数:" + score.getScore());
            }
        }
    }
}
