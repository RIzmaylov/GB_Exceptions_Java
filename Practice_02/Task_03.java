package Practice_02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * Запишите в файл следующие строки:
Анна=4
Елена=5
Марина=6
Владимир=?
Константин=?
Иван=4
Реализуйте метод, который считывает данные из файла и сохраняет в двумерный массив (либо HashMap, если
студенты с ним знакомы). В отдельном методе нужно будет пройти по структуре данных, если сохранено
значение ?, заменить его на соответствующее число.Если на каком-то месте встречается символ, отличный от
числа или ?, бросить подходящее исключение.Записать в тот же файл данные с замененными символами ?.
 */
public class Task_03 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("Practice_02/1.txt"));
        List<String> sb = new ArrayList();
        String content = br.readLine();
        while (content != null){
            sb.add(content);
            content = br.readLine();
        }
        br.close();
        // ["Анна=4", "Елена=5", "Марина=6", ...]
        HashMap<String, Integer> map = new HashMap<>();
        for (String i: sb){
            String[] parts = i.split("=");
            // parts = ["Анна", "4"]
            map.put(parts[0], parts[0].length());
        }
        StringBuilder output = new StringBuilder();
        FileWriter file = new FileWriter("Practice_02/1.txt");
        for (String name: map.keySet()){
            output.append(name).append("=").append(map.get(name)).append("\n");
        }
        file.write(String.valueOf(output));
        file.flush();
        file.close();
    }
}
