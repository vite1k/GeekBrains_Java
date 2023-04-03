public class Task_4 {
    private static final int BOARD_SIZE = 8;
    private static int[] solution = new int[BOARD_SIZE];

    public static void main(String[] args) {
        solve(0);
    }

    private static boolean canPlaceQueen(int row, int column) {
        for (int i = 0; i < column; i++) {
            if (solution[i] == row || Math.abs(column - i) == Math.abs(row - solution[i])) {
                return false;
            }
        }
        return true;
    }

    private static void solve(int column) {
        if (column == BOARD_SIZE) {
            printSolution();
            System.out.println("\n");
            return;
        }

        for (int row = 0; row < BOARD_SIZE; row++) {
            if (canPlaceQueen(row, column)) {
                solution[column] = row;
                solve(column + 1);
            }
        }
    }

    private static void printSolution() {
        for (int row : solution) {
            for (int column = 0; column < BOARD_SIZE; column++) {
                if (column == row) {
                    System.out.print("Q ");
                } else {
                    System.out.print("_ ");
                }
            }
            System.out.println();
        }
    }
}
