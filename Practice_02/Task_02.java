package Practice_02;
/*
 *  Обработайте возможные исключительные ситуации. “Битые” значения в
исходном массиве считайте нулями. Можно внести в код правки, которые считаете
необходимыми.
 */

public class Task_02 {
    public static void main(String[] args) {
        String[][] arr = {{"1", "0"}, {"3a", "23"}};
        System.out.println(sum2d(arr));
    }

    public static int sum2d(String[][] arr){
        int sum = 0;
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[i].length; j++){
                try {
                    int val = Integer.parseInt(arr[i][j]);
                    sum += val;
                } catch (NumberFormatException e){
                    System.out.println("Невозможно перевести значение в целое число с индексом (" + i + ", " + j + ")");
                    // throw new RuntimeException("Невозможно перевести значения в целое число!");
                }
            }
        }
        return sum;
    }
}
