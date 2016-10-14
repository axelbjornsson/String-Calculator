package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {

	public static void main(String args[]) {
      org.junit.runner.JUnitCore.main("is.ru.stringcalculator.CalculatorTest");
    }

	
	@Test
	public void testEmptyString() {
		assertEquals(0, Calculator.add(""));
	}
	@Test
	public void testOneNumber(){
		assertEquals(1, Calculator.add("1"));
	}
	@Test
	public void testTwoNumbers(){
		assertEquals(3, Calculator.add("1,2"));
	}
	@Test
	public void testMultipleNumbers(){
		assertEquals(6, Calculator.add("1,2,3"));
	}
	@Test
	public void testMultipleNumbers2() {
		assertEquals(15, Calculator.add("5,4,3,2,1"));
	}
	@Test
	public void testLineSplits() {
		assertEquals(6, Calculator.add("1\n2,3"));
	}
	@Test
	public void testLineSplits2() {
		assertEquals(6, Calculator.add("1\n2\n3"));
	}
	@Test
	public void testNegativeNumbers() {
		try {
			Calculator.add("-1,-2,-3");
		}
		catch (Exception e){
			assertEquals("Negatives not allowed: -1,-2,-3", e.getMessage());
		}
	}
	@Test
	public void testIgnoreOver1000(){
		assertEquals(5, Calculator.add("1001,2,3"));
	}
}