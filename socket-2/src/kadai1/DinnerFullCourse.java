package kadai1;

public class DinnerFullCourse {
    private Dish[] list = new Dish[5];// [0]-[4]の計5個

    DinnerFullCourse(){
        for(int i = 0;i < list.length;i++){
            list[i] = new Dish();
            list[i].setName("前菜");
            list[i].setValune(10);
        }
    }

    void eatAll(){
        String str = "";
        for(Dish dish : list){
            str += dish.getName() + "," + dish.getValune() + "/" ;
        }
        System.out.println("今日のフルコースの内容は" + str + "です。");
    }

	public static void main(String[] args) {

		DinnerFullCourse fullcourse = new DinnerFullCourse();
		fullcourse.eatAll();
	}
}
