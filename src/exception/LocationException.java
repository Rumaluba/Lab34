package exception;

public class LocationException extends Exception {
    public static int count = 0;
    public LocationException(String message) throws RuntimeException {
        super(message);
        count++;
        if (count ==5) {
            throw new RuntimeException("Слишком много нарушений, ломающих работу программы");
        }
    }
}
