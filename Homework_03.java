import java.io.FileWriter;
import java.util.Scanner;

//#region Тесты
// Тесты на корректные вводы в разных позициях и на дописывание в файл
// Izm Rus Ed 04.07.1992 89995554422 m
// 04.07.1992 89995554422 m Izm Rus Ed
// 04.07.1992 Izm Rus Ed 89995554422 m 

// Некорректные входные данные
// Iz2m Rus Ed 04.07.1992 89995554422 m
// Izm R4us Ed 04.07.1992 89995554422 m
// Izm Ru1s Ed 04.07.1992 89995554422 m
// Izm Rus Ed 00.07.1992 89995554422 m
// Izm Rus Ed 02.04.1992 89995554422 m
// Izm Rus Ed 03.04.1992 899955544222 m
// Izm Rus Ed 02.04.1992 8999555442 m
// Izm Rus Ed 02.04.1992 89995554422 t
//#endregion

public class Homework_03 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in);){
            System.out.println("Введите данные (Фамилия Имя Отчество, дата рождения, номер телефона, пол)");
            String input = scanner.nextLine();

            String[] data = input.split("\\s+");
            if (data.length != 6) {
                throw new IllegalArgumentException("Неверное количество данных");
            }
            String lastName = "", firstName = "", midName = "", birthDate = "", phoneNumber = "", gender = "";
            for (int i = 0; i < data.length; ++i) {
                if (data[i].contains(".")) {
                    birthDate = validateBDate(data[i]);
                } else if (data[i].length() == 1) {
                    gender = validateGender(data[i]);
                } else if (Character.isDigit(data[i].charAt(0))) {
                    phoneNumber = validatePhoneNumber(data[i]);
                } else {
                    lastName = validateName(data[i++]);
                    firstName = validateName(data[i++]);
                    midName = validateName(data[i]);
                }
            }

            try(FileWriter fileWriter = new FileWriter(lastName + ".txt", true)) {
                StringBuilder output = new StringBuilder();
                output.append("Last name: ").append(lastName).append('\n');
                output.append("First name: ").append(firstName).append('\n');
                output.append("Mid name: ").append(midName).append('\n');
                output.append("Birth date: ").append(birthDate).append('\n');
                output.append("Phone number: ").append(phoneNumber).append('\n');
                output.append("Gender: ").append(gender).append("\n\n");
                fileWriter.write(String.valueOf(output));
                fileWriter.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        
    }

    public static String validateName(String name) {
        for (int i = 0; i < name.length(); i++) {
            if (Character.isDigit(name.charAt(i))) throw new IllegalArgumentException("Опечатка. В имени, фамилии или отчестве не может быть цифр");
        }
        return name;
    }

    public static String validateBDate(String bDate) {
        String[] date = bDate.split("\\.");
        if (date.length != 3) throw new IllegalArgumentException("Неправильная дата. Должно быть три поля через '.'. (dd.mm.yyyy)");
        int day, month, year;
        year = Integer.parseInt(date[2]);
        month = Integer.parseInt(date[1]);
        day = Integer.parseInt(date[0]);
        if (month < 1 || month > 12) throw new IllegalArgumentException("Такого месяца не существует");
        if (day < 1 || day > 31) throw new IllegalArgumentException("Дня с таким числом не существует");
        if (day > 30 && (month == 2 || month == 4 || month == 6 || month == 9 || month == 11)) throw new IllegalArgumentException("Неверное число. В указанном месяце не больше 30 дней");
        if (day > 28 && month == 2 && (year % 100 == 0 && year % 400 != 0)) throw new IllegalArgumentException("Неверное число. Введенный год не високосный. В феврале не больше 28 дней");
        return bDate;
    }

    public static String validateGender(String gender) {
        if (!gender.equals("f") && !gender.equals("m")) throw new IllegalArgumentException("Неправильно введен пол (f/m)");
        if (gender.equals("f")) return "Female";
        else return "Male";
    }

    public static String validatePhoneNumber(String phone) {
        if (phone.length() != 11) throw new IllegalArgumentException("Неправильный номер телефона. Должно быть 11 цифр");
        // Integer number = Integer.parseInt(phone);
        return phone.charAt(0) + "(" + phone.substring(1, 4) + ")" +
                phone.substring(4, 7) + "-" + phone.substring(7, 9) + "-" +
                phone.substring(9, 11);
    }

}

