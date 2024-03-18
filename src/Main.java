import java.util.Scanner;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("введи ФИО и дату рождения:");
            String data = scanner.nextLine();

            String surname = data.split(" ")[0] + " " + data.split(" ")[1].charAt(0) + "." + data.split(" ")[2].charAt(0) + ".";

            String birthday = data.split(" ")[3];

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            LocalDate birthDate = LocalDate.parse(birthday, formatter);
            LocalDate currentDate = LocalDate.now();
            int age = Period.between(birthDate, currentDate).getYears();

            String gender = (data.split(" ")[2].endsWith("ич")) ? "Мужской" : "Женский";

            System.out.println(surname);
            System.out.println("Возраст: " + age);
            System.out.println("Пол: " + gender);
        } catch(DateTimeParseException e) {
            System.out.println("Некорректный формат даты рождения. Используйте формат dd.MM.yyyy.");
        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("Некорректный формат ввода. Введите ФИО и дату рождения через пробел.");
        } catch(Exception e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
        }
    }
}