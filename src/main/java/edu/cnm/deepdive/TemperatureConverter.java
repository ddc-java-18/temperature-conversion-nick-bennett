package edu.cnm.deepdive;

public class TemperatureConverter {

  private static final int CELSIUS_FAHRENHEIT_OFFSET = 32;
  private static final double KELVIN_CELSIUS_OFFSET = 273.15;
  private static final double CELSIUS_FAHRENHEIT_SCALE_FACTOR = 1.8;

  private static Mode mode = Mode.CF;

  public static void main(String[] args) {
    System.out.printf("Starting mode = %s%n", mode);
    for (String arg : args) {
      try {
        mode = Mode.valueOf(arg.toUpperCase());
        System.out.printf("Change mode to %s%n", mode);
      } catch (IllegalArgumentException e) {
        double value = Double.parseDouble(arg);
        double convertedValue = convert(value);
        System.out.printf("Input = %.2f; output = %.2f%n", value, convertedValue);
      }
    }
  }

  private static double convert(double value) {
    // DONE: 5/20/24 Perform conversion with value and mode; return result.
    return switch (mode) {
      case CF -> value * CELSIUS_FAHRENHEIT_SCALE_FACTOR + CELSIUS_FAHRENHEIT_OFFSET;
      case CK -> value + KELVIN_CELSIUS_OFFSET;
      case FC -> (value - CELSIUS_FAHRENHEIT_OFFSET) / CELSIUS_FAHRENHEIT_SCALE_FACTOR;
      case FK -> (value - CELSIUS_FAHRENHEIT_OFFSET) / CELSIUS_FAHRENHEIT_SCALE_FACTOR
          + KELVIN_CELSIUS_OFFSET;
      case KC -> value - KELVIN_CELSIUS_OFFSET;
      case KF -> (value - KELVIN_CELSIUS_OFFSET) * CELSIUS_FAHRENHEIT_SCALE_FACTOR
          + CELSIUS_FAHRENHEIT_OFFSET;
    };
  }

}
