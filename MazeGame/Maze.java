import java.util.Random;

public class Maze {
    private Random random = new Random();
    private String[][] grid;

    public String[][] generateGrid(int height, int width) {

        if (height % 2 == 0) height++;
        if (width % 2 == 0) width++;

        grid = new String[height][width];

        // Заполнение стенами
        for (int x = 0; x < height; x++) {
            for (int y = 0; y < width; y++) {
                grid[x][y] = "\uD83D\uDFE5"; 
            }
        }

        // Начальная точка
        grid[1][1] = " "; 
        generatePath(1, 1); 

        // Устанавливаем выход в правом нижнем углу
        grid[height - 2][width - 2] = " ";

        return grid;
    }

    private void generatePath(int x, int y) {
 
        int[][] directions = new int[][] {{2, 0}, {-2, 0}, {0, 2}, {0, -2}};

        // Перемешивание направлений
        for (int i = directions.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            int[] temp = directions[i];
            directions[i] = directions[j];
            directions[j] = temp;
        }


        for (int i = 0; i < directions.length; i++) {
            int[] dir = directions[i];
            int newX = x + dir[0];
            int newY = y + dir[1];

            // Проверка границ и создание прохода
            if (newX > 0 && newY > 0 && newX < grid.length - 1 && newY < grid[0].length - 1 && grid[newX][newY] == "\uD83D\uDFE5") {
                grid[newX][newY] = " "; 
                grid[x + dir[0] / 2][y + dir[1] / 2] = " "; 
                generatePath(newX, newY); 

            }
        }
    }
}
