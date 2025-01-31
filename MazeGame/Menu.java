import java.util.Scanner;

public class Menu {

    public void showMenu() {
        ClearConsole clear = new ClearConsole();
        Scanner scanner = new Scanner(System.in); 
        System.out.println("Игра лабиринт");
        System.out.println("1: Начать игру");
        System.out.println("2: Управление");
        System.out.println("3: Автор игры");
        System.out.println("4: Выход");

        System.out.println("Напишите цифру и нажмите Enter: ");
        int command = scanner.nextInt();

        switch (command) {
            case 1:
                clear.clearConsole(); 
                Game game = new Game(15);
                game.start(); 
                break;

            case 2:
                clear.clearConsole();
                showControls();
                break;

            case 3:
                clear.clearConsole();
                showCredits();
                break;

            case 4:
                clear.clearConsole();
                System.out.println("До скорой встречи!");
                break;

            default:
                System.out.println("Неверная команда. Пожалуйста, попробуйте снова.");
                showMenu(); 
                break;
        }
    }

    public void showControls() {
        ClearConsole clear = new ClearConsole();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Клавиши:\nW-вперед\nA-влево\nS-назад\nD-вправо\n\n0-Выход в главное меню");
        System.out.println("Напишите 0 и прожмите Enter чтобы выйти в главное меню ");
        int command = scanner.nextInt();

        if (command == 0) {
            clear.clearConsole();
            showMenu();
        }
    }

    public void showCredits() {
        System.out.println("The game created by Gafarov Timur\nTelegram: @JrMladshiy\nGitHub: https://github.com/GafrikJr");
        System.out.println("\nНапишите 0 и прожмите Enter чтобы выйти в главное меню ");
        Scanner scanner = new Scanner(System.in);
        int command = scanner.nextInt();

        if (command == 0) {
            ClearConsole clear = new ClearConsole();
            clear.clearConsole();
            showMenu();
        }
    }
}
