package Kadai2;

class Kamoku {
	String name;
	int score;
	private int studentid;

	Kamoku(int s) {  // これがコンストラクタ。特殊なメソッド。クラス名と同じ。
		score = s; 
	}

// setScore というメソッドを定義する。
// score に値を設定する。
	public void setScore(int num){
		score = num;
	}

    public void setStudentid(int id){
        studentid = id;
    }

// getScore というメソッドを定義する。
// scoreを返す。
	public int getScore() {
		return score;
	}

    public int getStudentid(){
        return studentid;
    }

    public void name(String name){
        this.name = name;
    }
}


