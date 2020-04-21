package string.formatter;

/**
 * @Author: shenge
 * @Date: 2020-04-13 10:21
 *
 * 使用String的formatter其实也会调用Formatter，并且会返回给你格式化后的String，非常方便。
 */
public class DatabaseException extends Exception {
    public DatabaseException(int transactionID,
                             int queryID, String message) {
        super(String.format("(t%d, q%d) %s", transactionID,
                queryID, message));
    }
    public static void main(String[] args) {
        try {
            throw new DatabaseException(3, 7, "Write failed");
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}