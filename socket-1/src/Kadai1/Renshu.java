package Kadai1;

public class Renshu {
    public int doubleValue(int x){
        return x * 2;
    }

    public int sumUpToN(int x){
        int sum = 0;
        for(int i = 1;i <= x;i++){
            sum += i;
        }
        return sum;
    }

    public int sumFromPtoQ(int p, int q){
        if(p > q){
            return -1;
        }
        int sum = 0;
        for(int i = p;i <= q;i++){
            sum += i;
        }
        return sum;
    }

    public int sumFromArrayIndex(int[] a, int n){
        if(n < 0 || n >= a.length){
            return -1;
        }
        int sum = 0;
        for(int i = n;i < a.length;i++){
            sum += a[i];
        }
        return sum;
    }

    public int selectMaxValue(int[] list){ 
        int max = list[0];
        if(list.length == 1){
            return max;
        }
        for(int i = 1;i < list.length;i++){
            if(list[i] > max){
                max = list[i];
            }
        }
        return max;
    }

    public int selectMinValue(int[] list){
        int min = list[0];
        if(list.length == 1){
            return min;
        }
        for(int i = 1;i < list.length;i++){
            if(list[i] < min){
                min = list[i];
            }
        }
        return min;
    }

    public int selectMaxIndex(int[] list){
        int max = list[0];
        int maxIndex = 0;
        if(list.length == 1){
            return maxIndex;
        }
        for(int i = 1;i < list.length;i++){
            if(list[i] > max){
                max = list[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public int selectMinIndex(int[] list){
        int min = list[0];
        int minIndex = 0;
        if(list.length == 1){
            return minIndex;
        }
        for(int i = 1;i < list.length;i++){
            if(list[i] < min){
                min = list[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    public int[] swapArrayElements(int[] list,int p,int q){
        if(p < 0 || p > list.length ||q < 0 || q > list.length){
            for(int i = 0;i < list.length;i++){
                list[i] = -1;
            }
            return list;
        }
        int copy = list[p];
        list[p] = list[q];
        list[q] = copy;
        return list;
    }

    public boolean swapTwoArrays(int[] listA,int[] listB){
        if(listA.length != listB.length){
            return false;
        }
        int copy;
        for(int i = 0;i < listA.length;i++){
            copy = listA[i];
            listA[i] = listB[i];
            listB[i] = copy;
        }

        return true;
    }
}
