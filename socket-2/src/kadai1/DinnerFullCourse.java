package kadai1;

public class DinnerFullCourse {
    private Dish[] list = new Dish[5];// [0]-[4]の計5個

    DinnerFullCourse(){
        for(int i = 0;i < list.length;i++){
            list[i] = new Dish();
        }
        list[0].setName("前菜盛り合わせ");
        list[0].setValune(1000);

        list[1].setName("魚料理");
        list[1].setValune(1200);

        list[2].setName("肉料理");
        list[2].setValune(1500);

        list[3].setName("ご飯もの");
        list[3].setValune(700);

        list[4].setName("デザート");
        list[4].setValune(600);
    }

    void eatAll(){
        String str = "";
        for(Dish dish : list){
            str += dish.getName() + "," + dish.getValune() + "円/" ;
        }
        System.out.println("今日のフルコースの内容は" + str + "です。");
    }

	public static void main(String[] args) {

		DinnerFullCourse fullcourse = new DinnerFullCourse();
		fullcourse.eatAll();
	}
}
