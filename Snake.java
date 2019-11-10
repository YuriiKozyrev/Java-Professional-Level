package Java_Prof_Level.Lesson_7;

public class Snake {

    public static void main(String[] args) {
        Snake snake = new Snake();

        snake.snake(10,11);

    }

    public void snake (int lines, int columns){
        int k = 1;
        int[][] maze = new int[lines][columns];

        for (int t = 0; t < (lines / 2 + 1); t++) {

                //  вправо
                for (int i = t; i < t + 1; i++) {
                    for (int j = t; j < columns - t; j++) {
                        maze[i][j] = k;
                        k++;
                    }
                }
                if(k == (lines * columns + 1)) break;

                //  вверх
                for (int i = (t + 1); i < lines - t; i++) {
                    maze[i][columns - (1 + t)] = k;
                    k++;
                }
                if(k == (lines * columns + 1)) break;

                //  влево
                for (int j = columns - (t + 2); j > (t - 1); j--) {
                    maze[lines - (t + 1)][j] = k;
                    k++;
                }
                if(k == (lines * columns + 1)) break;

                //  вниз
                for (int i = lines - (t + 2); i > t; i--) {
                    maze[i][t] = k;
                    k++;
                }
                if(k == (lines * columns + 1)) break;
        }

        showArray(maze);
    }

    
    public void showArray(int array[][]){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(" " + array[i][j] + " ");
            }
            System.out.println("");
        }
    }

}
