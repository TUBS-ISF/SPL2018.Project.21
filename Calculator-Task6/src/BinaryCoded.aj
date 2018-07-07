

public aspect BinaryCoded {

	int around(String inputLine) : execution(private int Calculator.checkNumber(String)) && args(inputLine) {
		if (inputLine.startsWith("0b")) {
			// if configuration can read binary coded numbers
			String value = inputLine.substring(2);
			return Integer.parseInt(value, 2);
		}
		return proceed(inputLine);
	}
}
