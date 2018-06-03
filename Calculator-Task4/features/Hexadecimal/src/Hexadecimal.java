import de.tubs.tudyka.interfaces.INumDecoder;

public class Hexadecimal implements INumDecoder {

	@Override
	public int decode(String inputLine) throws NumberFormatException {
		if (inputLine.startsWith("0x")) {
			// if configuration can read binary coded numbers
			String value = inputLine.substring(2);
			return Integer.parseInt(value, 16);
		}
		throw new NumberFormatException("Inputline is not valid");
	}
}
