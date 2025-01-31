import java.util.Scanner;

public class Game {

    private int x;
    private int y;
    private int size;
    private String[][] grid;
    private Maze maze;
    private ClearConsole clearConsole;

    public Game(int size) {
        this.size = size;
        this.x = 1; 
        this.y = 1; 
        this.maze = new Maze();
        this.grid = maze.generateGrid(size, size * 2);
        grid[x][y] = "*"; 
        this.clearConsole = new ClearConsole(); 
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        String key;

        while (true) {
            display(); 
            System.out.print("Куда идем? (w/a/s/d для движения, q для выхода): ");
            key = scanner.nextLine();

            // Выход из игры
            if (key.equalsIgnoreCase("q")) {
                System.out.println("До скорой встречи!");
                break;
            }


            if (move(key)) {
                clearConsole.clearConsole(); //
                grid[x][y] = "*"; 

                // Проверка на выход
                if (y == grid[0].length - 2) {
                    System.out.println("Вы нашли выход! Начинаю генерацию нового уровня...");
                    size = (int) (Math.random() * (20 - 5 + 1) + 5); 
                    maze = new Maze();
                    grid = maze.generateGrid(size, size * 2);
                    x = 1; y = 1; // Сбрасываем позицию игрока
                    grid[x][y] = "*"; 
                }
            }
        }

    }

    private boolean move(String direction) {
        // Сохраняем предыдущие координаты
        int prevX = x;
        int prevY = y;

        switch (direction.toLowerCase()) {
            case "a":
                if (y - 1 >= 0 && grid[x][y - 1] != "\uD83D\uDFE5") {
                    y -= 1;
                }
                break;
            case "d":
                if (y + 1 < size * 2 && grid[x][y + 1] != "\uD83D\uDFE5") {
                    y += 1;
                }
                break;
            case "w":
                if (x - 1 >= 0 && grid[x - 1][y] != "\uD83D\uDFE5") {
                    x -= 1;
                }
                break;
            case "s":
                if (x + 1 < size && grid[x + 1][y] != "\uD83D\uDFE5") {
                    x += 1;
                }
                break;
            default:
                return false; // если нажата другая кнопка - нельзя двигаться
        }

        // Стираем предыдущую позицию игрока
        grid[prevX][prevY] = " "; 
        return true; 
    }

    public void display() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size * 2; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }

    }
}
