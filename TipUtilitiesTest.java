import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
/**
 * This program tests tip calculator for its methods
 * @author Bobby Nguyen
 * @version January 24th, 2019
 * @version January 28th, 2019
 */
class TipUtilitiesTest {
	/**
	 * These tests test for calcTip() method
	 */
	@Test
	void test0() {
		assertEquals(0.0, TipUtilities.calcTip(0.0, 0.0));
	}
	@Test
	void test1() {
		assertEquals(1.5, TipUtilities.calcTip(10.00, 0.15));
	}
	@Test
	void test2() {
		assertEquals(2.25, TipUtilities.calcTip(15.00, 0.15));
	}
	@Test
	void test3() {
		assertEquals(3.75, TipUtilities.calcTip(25.00, 0.15));
	}
	@Test
	void test4() {
		assertEquals(2.60, TipUtilities.calcTip(26.00, 0.10));
	}
	@Test
	void test5() {
		assertThrows(IllegalArgumentException.class, () -> TipUtilities.calcTip(-29.00, 0.15), "Can't compute due to negative value.");
	}
	@Test
	void test6() {
		assertThrows(IllegalArgumentException.class, () -> TipUtilities.calcTip(26.00, -0.15), "Can't compute due to negative value.");
	}
	
	/**
	 * These tests test for round method and combination of round() and calcTip() methods
	 */
	@Test
	void testRound0() {
		assertEquals(3.75,TipUtilities.round(3.72, 0.25));
	}
	@Test
	void testRound1() {
		assertEquals(5.90,TipUtilities.round(5.93, 0.10));
	}
	@Test
	void testRound2() {
		assertEquals(11.25,TipUtilities.round(11.29, 0.25));
	}
	@Test
	void testRound3() {
		assertEquals(100.5,TipUtilities.round(100.66, 0.5));
	}
	@Test
	void testRound4() {
		assertEquals(12.25,TipUtilities.round(12.30, 0.25));
	}
	@Test
	void testRound5() {
		assertEquals(14.00,TipUtilities.round(13.95, 1.0));
	}
	@Test
	void testRound6() {
		assertEquals(0.50,TipUtilities.round(0.45, 0.5));
	}
	@Test
	void testRound7() {
		assertEquals(7.00,TipUtilities.round(TipUtilities.calcTip(47.00, 0.15 ), 0.1));
	}
	@Test
	void testRound8() {
		assertEquals(22.25,TipUtilities.round(TipUtilities.calcTip(148.95, 0.15 ), 0.25));
	}
	@Test
	void testRound9() {
		assertThrows(IllegalArgumentException.class, () -> TipUtilities.round(-0.45, 0.5), "Can't round due to negative value.");
	}
	@Test
	void testRound10() {
		assertThrows(IllegalArgumentException.class, () -> TipUtilities.round(0.29, -0.5), "Can't round due to negative value.");
	}
	@Test
	void testRound11() {
		assertThrows(IllegalArgumentException.class, () -> TipUtilities.round(TipUtilities.calcTip(-20.00, 0.15), 0.5), "Can't round due to negative value.");
	}
	@Test
	void testRound12() {
		assertThrows(IllegalArgumentException.class, () -> TipUtilities.round(TipUtilities.calcTip(20.00, 0.15), -0.5), "Can't round due to negative value.");
	}
	/**
	 * These tests test for formatNumber() method
	 */
	@Test
	void testFormat1() {
		assertEquals("15.0",TipUtilities.formatNumber(15.001, 1));
	}
	@Test
	void testFormat2() {
		assertEquals("10.75",TipUtilities.formatNumber(10.7533, 2));
	}
	@Test
	void testFormat3() {
		assertEquals("2.256",TipUtilities.formatNumber(2.2563, 3));
	}
	@Test
	void testFormat4() {
		assertEquals("10.99999",TipUtilities.formatNumber(10.9999999999, 5));
	}
	@Test
	void testFormat5() {
		assertEquals("11.0",TipUtilities.formatNumber(11, 1));
	}
	@Test
	void testFormat6() {
		assertEquals("0.257",TipUtilities.formatNumber(0.25789, 3));
	}
	
	@Test
	void testFormat7() {
		assertThrows(IllegalArgumentException.class, () -> TipUtilities.formatNumber(-0.25789, 3) , "Can't format due to negative value.");
	}
	@Test
	void testFormat8() {
		assertThrows(IllegalArgumentException.class, () -> TipUtilities.formatNumber(0.25789, -3) , "Can't format due to negative value.");
	}
	@Test
	void testFormat9() {
		assertEquals("0.2579",TipUtilities.formatNumber(0.25789, 4));
	}
	@Test
	void testFormat1_0() {
		assertEquals("2.00",TipUtilities.formatNumber(1.999999, 2));
	}
	@Test
	void testFormat1_1() {
		assertEquals("2.000",TipUtilities.formatNumber(1.999999, 3));
	}
	@Test
	void testFormat1_2() {
		assertEquals("1.0000",TipUtilities.formatNumber(0.999999, 4));
	}
	@Test
	void testFormat1_3() {
		assertEquals("10.00",TipUtilities.formatNumber(9.999999, 2));
	}
	@Test
	void testFormat1_4() {
		assertEquals("52.850",TipUtilities.formatNumber(52.85, 3));
	}
	@Test
	void testFormat1_5() {
		assertEquals("2.0",TipUtilities.formatNumber(1.999999, 1));
	}
	/**
	 * These tests test for all three calcTip(), round(), and formatNumber() methods
	 */
	@Test
	void testTotal1() {
		assertEquals("2.5000",TipUtilities.formatNumber(TipUtilities.round(TipUtilities.calcTip(26.00, 0.10), 0.50), 4));
	}
	@Test
	void testTotal2() {
		assertEquals("10.5000",TipUtilities.formatNumber(TipUtilities.round(TipUtilities.calcTip(52.00, 0.20), 0.50), 4));
	}
	@Test
	void testTotal3() {
		assertEquals("22.2500",TipUtilities.formatNumber(TipUtilities.round(TipUtilities.calcTip(148.95, 0.15), 0.25), 4));
	}
	@Test
	void testTotal4() {
		assertEquals("22.250000000000000000000",TipUtilities.formatNumber(TipUtilities.round(TipUtilities.calcTip(148.95, 0.15), 0.25), 21));
	}
}
