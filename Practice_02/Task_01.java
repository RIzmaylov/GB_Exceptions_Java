package Practice_02;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * Посмотрите на этот код. Все ли с ним хорошо? Если нет, то скорректируйте его и
обоснуйте свое решение.
 */
public class Task_01 {
    public static void main(String[] args) {
        int[] arr = new int[10]; // {0, ... 0}
        searchElement(arr);
    }

    public static void searchElement(int[] arr){
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Укажите индекс элемента массива, в который хотите записать значение 1");
            int index = scanner.nextInt();
            arr[index] = 1;
        } catch (InputMismatchException e){
            System.out.println("Введено некорректное значение!");
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Указан индекс за пределами массива");
        }
    }
}
