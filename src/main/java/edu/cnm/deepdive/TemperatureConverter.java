package edu.cnm.deepdive;

import java.util.Scanner;

public class TemperatureConverter {

  private static final int CELSIUS_FAHRENHEIT_OFFSET = 32;
  private static final double KELVIN_CELSIUS_OFFSET = 273.15;
  private static final double CELSIUS_FAHRENHEIT_SCALE_FACTOR = 1.8;

  private static Mode mode = Mode.CF;

  public static void main(String[] args) {
    System.out.printf("Starting mode = %s%n", mode);

    // While there is input:
    //  - Check if input matches one of the modes;
    //      - if so, change mode
    //    otherwise, check  if input is a number;
    //      - if so, perform conversion
    //    otherwise, halt.

    Scanner scanner = new Scanner(System.in);
    while (scanner.hasNext()) {
      if (scanner.hasNext(Mode.PATTERN)) {
        mode = Mode.valueOf(scanner.next(Mode.PATTERN).toUpperCase());
        System.out.printf("Change mode to %s%n", mode);
      } else if (scanner.hasNextDouble()) {
        double value = scanner.nextDouble();
        double convertedValue = convert(value);
        System.out.printf("Input = %.2f; output = %.2f%n", value, convertedValue);
      } else {
        throw new IllegalArgumentException(String.format("Invalid input: %s%n", scanner.next()));
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
