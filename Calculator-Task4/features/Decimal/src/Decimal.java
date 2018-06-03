import de.tubs.tudyka.interfaces.INumDecoder;

public class Decimal implements INumDecoder {

	@Override
	public int decode(String inputLine) throws NumberFormatException {
		
		if (!(inputLine.startsWith("0b") || inputLine.startsWith("0x"))) {
			// if configuration can read binary coded numbers
			return Integer.parseInt(inputLine, 10);
		}
		throw new NumberFormatException("Inputline is not valid");
	}
}
