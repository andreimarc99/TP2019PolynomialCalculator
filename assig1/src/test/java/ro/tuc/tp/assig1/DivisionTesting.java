package ro.tuc.tp.assig1;

import static org.junit.Assert.*;

import org.junit.Test;

public class DivisionTesting {

	@Test
	public void test() {
		Monom m11 = new Monom(3, 3);
		Monom m12 = new Monom(4, 2);
		Monom m13 = new Monom(2, 1);
		Monom m21 = new Monom(2, 2);
		Monom m22 = new Monom(-3, 1);
		Monom m23 = new Monom(5, 0);  
		
		Polinom p1 = new Polinom();
		Polinom p2 = new Polinom();
		
		//P1 = 3x^3 + 4x^2 + 2x
		p1.addToPolinom(m11);
		p1.addToPolinom(m12);
		p1.addToPolinom(m13);
		//P2 = 2x^2 - 3x^1 + 5
		p2.addToPolinom(m21);
		p2.addToPolinom(m22);
		p2.addToPolinom(m23);
		//Expecting R = 7,25x - 21,25; Q = 1,5x + 4,25
		//Coefficients are restrained to 2 decimals
		DivisionResult div = Operations.divide(p1, p2);
		assertEquals("-21,25x^0+7,25x^1", div.getR().polynomialToString());
		assertEquals("4,25x^0+1,5x^1", div.getQ().polynomialToString());
	}

}
