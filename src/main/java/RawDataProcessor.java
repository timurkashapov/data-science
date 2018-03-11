import java.time.OffsetDateTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

/**
 * Обработчик сырых данных (Raw Data Processor).
 *
 * производит обработку в следующей последовательности:
 * 1. Проверка null значений.
 * 2. Проверка на наличие только пробелов в значении.
 * 3. Анализ значений по типам
 * 4. Вхождение значения в определенный диапазон.
 *
 */
public abstract class RawDataProcessor {

    /**
     * Проверка null значений.
     * @param value значение.
     * @return утверждение.
     */
    private static boolean checkNull(String value) {
        return value == null || "null".equalsIgnoreCase(value);
    }

    /**
     * Проверка на наличие только пробелов в значении.
     * @param value значение.
     * @return утверждение.
     */
    private static boolean checkBlank(String value) {
        return value.trim().isEmpty();
    }

    /**
     * Анализ вещественного значения.
     * @param value значение.
     * @return вещественное число.
     */
    private static Double parseDouble(String value) {
        // todo: доработать имя метода.
        double d;
        try {
            d = Double.parseDouble(value);
        } catch (NumberFormatException e){
            throw new RuntimeException(e);
        }
        return d;
    }

    /**
     * Анализ целочисленного значения.
     * @param value значение.
     * @return целочисленное число.
     */
    private static Integer parseInt(String value) {
        // todo: доработать имя метода.
        Integer i;
        try {
            i = Integer.valueOf(value);
        } catch (NumberFormatException e){
            throw new RuntimeException(e);
        }
        return i;
    }

    /**
     * Анализ смещения значения даты и времени.
     * @param value значение.
     * @return дата и время.
     */
    private static OffsetDateTime parseDateTime(String value) {
        // todo: доработать имя метода.
        OffsetDateTime time;
        try {
            time = OffsetDateTime.parse(value);
        } catch (DateTimeParseException e){
            throw new RuntimeException(e);
        }
        return time;
    }

    /**
     * Проверка на вхождение вещественного значения в определенный диапазон.
     * @param value значение.
     * @return утверждение.
     */
    private static boolean checkRange(double value) {
        double minValue = 0.0;
        double maxValue = 1000000.0;
        boolean minValueInclusive = true;
        boolean maxValueInclusive = false;

        boolean minBit = (minValueInclusive) ? value >= minValue : value > minValue;
        boolean maxBit = (maxValueInclusive) ? value <= maxValue : value < maxValue;
                return minBit && maxBit;
    }

    /**
     * Проверка на вхождение строкового значения в определенный диапазон.
     * @param value значение.
     * @return утверждение.
     */
    private static boolean checkRange(String value) {
        ArrayList<String> validItems = new ArrayList<>();
        return validItems.contains(value);
    }

    /**
     * Проверка на вхождение значения даты и времени в определенный диапазон.
     * @param value значение.
     * @return утверждение.
     */
    private static boolean checkRange(OffsetDateTime value) {
        OffsetDateTime minDate = OffsetDateTime.now();
        OffsetDateTime maxDate = OffsetDateTime.now();
        return value.isAfter(minDate) && value.isBefore(maxDate);
    }

}
