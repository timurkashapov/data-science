import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Приложение (Application).
 *
 *
 *
 *
 */
public class App {

    /**
     * Одномерные массивы (Univariate arrays).
     */
    int[] id = new int[1024];
    int[] year = new int[1024];
    String[] city = new String[1024];

    /**
     * Многомерные массивы (Multivariate arrays).
     */
    int[][] data = {
            {1, 2014, 1},
            {2, 2015, 1},
            {3, 2014, 2}};

    /**
     * Объектная модель данных (Data object).
     */
    private Record record;

    /**
     * Матрица (Matrix).
     * m - rows.
     * n - columns.
     * i - row index.
     * j - columns index.
     */
    private int m = 10;
    private int n = 10;
    private int[][] matrix = new int[m][n];

    /**
     * Вектор (Vector).
     */
    private int[][] vector;

    /**
     * Буферезированное чтение (Buffered reader).
     */
    private BufferedReader bReader;

    public static void main(String[] args) {

        List<Record> recordList = new ArrayList<>();
        Map<String, Record> recordMap = new HashMap<>();
    }
}
