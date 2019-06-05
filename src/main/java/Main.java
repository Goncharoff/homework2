import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.util.CollectionUtils;

public class Main {

  public static void main(String[] args) {
    System.out.println(division(35, 5));
    System.out.println(filterListByFirstChar(Arrays.asList("It", "Is", "Result"), "I"));
    String resultString = trimAllWhitespace("    This     string     should     be    trimmed      ");
    System.out.println(resultString);

    List<String> test = Arrays.asList("Test", "Or", "Not", "To", "Test");
    List<String> test2 = Arrays.asList("Test");

    System.out.println("Method from spring jar " + CollectionUtils.containsAny(test, test2));
  }

  /**
   * Division of two long numbers
   *
   * @param dividend - as long
   * @param divider  - as long
   * @return result of division as double
   * @throws ArithmeticException if divider == 0
   */
  public static double division(long dividend, long divider) {
    if (divider == 0) throw new ArithmeticException("Divider can not be null");

    return dividend / (double) divider;
  }

  /**
   * Return new list of string items, which starts with startChar parameter.
   *
   * @param inputList - input list of Strings.
   * @param startChar - Start char for filtering list.
   * @return list of String, which starts with startChar param.
   */
  public static List<String> filterListByFirstChar(List<String> inputList, final String startChar) {
    return inputList.stream()
            .filter(item -> item.startsWith(startChar))
            .collect(Collectors.toList());
  }

  /**
   * Trim <i>all</i> whitespace from the given {@code String}:
   * leading, trailing, and in between characters.
   * *
   *
   * @param str the {@code String} to check
   * @return the trimmed {@code String}
   * @see java.lang.Character#isWhitespace
   */
  public static String trimAllWhitespace(String str) {
    boolean hasLength = str != null && str.length() > 0;
    if (!hasLength) {
      return str;
    }

    int len = str.length();
    StringBuilder sb = new StringBuilder(str.length());
    for (int i = 0; i < len; i++) {
      char c = str.charAt(i);
      if (!Character.isWhitespace(c)) {
        sb.append(c);
      }
    }
    return sb.toString();
  }

}
