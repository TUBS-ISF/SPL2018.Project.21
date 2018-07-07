

public aspect Decimal {

	int around(String inputLine) : execution(private int Calculator.checkNumber(String)) && args(inputLine) {

		if (!(inputLine.startsWith("0b") || inputLine.startsWith("0x"))) {
			// if configuration can read binary coded numbers
			return Integer.parseInt(inputLine, 10);
		}
		return proceed(inputLine);
	}
}
