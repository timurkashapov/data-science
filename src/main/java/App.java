import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
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
     * Множество данных строкового типа.
     */
    private String[] dataset;

    /**
     * Буферезированное чтение (Buffered reader) позволяет избежать ошибок при чтении больших файлов.
     */
    private BufferedReader bffReader;

    /**
     * Чтение строк (File reader).
     */
    private FileReader fReader;

    public static void main(String[] args) {

        List<Record> recordList = new ArrayList<>();
        Map<String, Record> recordMap = new HashMap<>();

        // exact file locality...
        try(BufferedReader bffInput = new BufferedReader(new FileReader("somefile.txt"))) {
            String columnNames = bffInput.readLine();
            String line;
            while( (line = bffInput.readLine()) != null ) {
                // todo: parse line.
            }
        } catch(IOException e) {
            System.err.println("Error > " + e.getMessage());
        }

        // exact file remotely...
        try {
            URL url = new URL("http://storage.example.com/public-data/somefile.txt");
            BufferedReader bffInput = new BufferedReader(new InputStreamReader(url.openStream()));
            String columnNames = bffInput.readLine();
            String line;
            while( (line = bffInput.readLine()) != null ) {
                // todo: parse line.
            }
        } catch (IOException e) {
            System.err.println("Error > " + e.getMessage());
        }
    }
}
