package de.tubs.tudyka.interfaces;

public interface IOperation {
	public boolean isValidOperator(String operator);
	public int calculate(int num0, int num1, String operator) throws IllegalArgumentException;
}
