package edu.cnm.deepdive;

public class TemperatureConverter {

  private static Mode mode = Mode.CF;

  public static void main(String[] args) {
    for (String arg : args) {
      try {
        mode = Mode.valueOf(arg.toUpperCase());
      } catch (IllegalArgumentException e) {
        double value = Double.parseDouble(arg);
        double convertedValue = convert(value);
      }
    }
  }

  private static double convert(double value) {
    // TODO: 5/20/24 Perform conversion with value and mode; return result.
    throw new UnsupportedOperationException();
  }

}
