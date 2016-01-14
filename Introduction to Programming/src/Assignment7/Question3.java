package Assignment7;

/**
 * Write the pseudo-code/flowchart for an application that calculates the
 * Celsius equivalent to Fahrenheit Temperatures. The Fahrenheit temps should
 * start at 0 and go up to 300, incrementing 20 each time through the
 * loop.(Formula is: Celsius = (Fahrenheit-32.0) * (5.0/9.0)). Your output
 * should be displayed on the Console Window. Don’t worry about formatting the
 * Celsius data.
 *
 * <br> I know I went a bit overboard on the solution. :P
 *
 * @author sseidel
 */
public class Question3 {

    public enum Temperature {

        CELSIUS,
        FAHRENHEIT;

        public double convert(double currentTemp) {
            if (this == FAHRENHEIT) {
                //Convert to Celcius
                return (currentTemp - 32) * (5.0 / 9.0);
            } else {
                //Convert to Fahrenheit
                throw new UnsupportedOperationException("No implementation required for this problem.");
            }
        }
    }

    public void run() {
        for (int x = 0; x <= 300; x = x + 20) {
            String f = trimDecimals(String.valueOf(x)).concat("°");
            String c = trimDecimals(String.valueOf(Temperature.FAHRENHEIT.convert(x))).concat("°");

            String line1 = "Fahrenheit           Celsius";
            String line2 = replaceStringInString(line1, "Fahrenheit", f);
            line2 = replaceStringInString(line2, "Celsius", c);

            System.out.println(line1 + "\r\n" + line2);
        }
    }

    private String replaceStringInString(String string, String toReplace, String replacement) {
        replacement = replacement + String.format("%" + (toReplace.length() - replacement.length()) + "s", "");
        return string.replace(toReplace, replacement);
    }

    private String trimDecimals(String str) {
        return str.contains(".") ? str.substring(0, str.indexOf(".") + 2) : str;
    }

    public static void main(String[] args) {
        new Question3().run();
    }

}
