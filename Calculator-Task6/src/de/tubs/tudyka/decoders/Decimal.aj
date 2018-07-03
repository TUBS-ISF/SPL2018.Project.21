package de.tubs.tudyka.decoders;

public aspect Decimal {

	int around(String inputLine) : execution(private int de.tubs.tudyka.Calculator.checkNumber(String)) && args(inputLine) {

		if (!(inputLine.startsWith("0b") || inputLine.startsWith("0x"))) {
			// if configuration can read binary coded numbers
			return Integer.parseInt(inputLine, 10);
		}
		return proceed(inputLine);
	}
}
