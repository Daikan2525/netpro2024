package kadai3;

public interface ITask {
    public abstract void setExecNumber(int x); //クライアントで最初に計算させる数字を入力しておく関数

    public abstract void exec() ; //サーバで計算を実行をさせる関数...計算アルゴリズムが記載される。下記アルゴリズムを参照のこと

    public abstract int getResult(); //クライアントで結果を取り出す関数 
}
