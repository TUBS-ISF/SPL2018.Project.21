import de.tubs.tudyka.interfaces.INumDecoder;

public class BinaryCoded implements INumDecoder {

	@Override
	public int decode(String inputLine) throws NumberFormatException {
		if (inputLine.startsWith("0b")) {
			// if configuration can read binary coded numbers
			String value = inputLine.substring(2);
			return Integer.parseInt(value, 2);
		}
		throw new NumberFormatException("Inputline is not valid");
	}
}
