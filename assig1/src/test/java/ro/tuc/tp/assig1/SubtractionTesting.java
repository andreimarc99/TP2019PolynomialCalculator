package ro.tuc.tp.assig1;

import static org.junit.Assert.*;

import org.junit.Test;

public class SubtractionTesting {

	@Test
	public void subtractionTest() {
		Monom m11 = new Monom(4, 5);
		Monom m12 = new Monom(2, 2);
		Monom m21 = new Monom(6, 4);
		Monom m22 = new Monom(-7, 2);
		Monom m23 = new Monom(1, 0);  
		
		Polinom p1 = new Polinom();
		Polinom p2 = new Polinom();
		
		//P1 = 4x^5 + 2x^2
		p1.addToPolinom(m11);
		p1.addToPolinom(m12);
		//P2 = 6x^4 - 7x^2 + 1
		p2.addToPolinom(m21);
		p2.addToPolinom(m22);
		p2.addToPolinom(m23);
		
		//Expecting sub12 = 4x^5 - 6x^4 + 9x^2 - 1
		Polinom sub12 = Operations.subtract(p1, p2);
		//Expecting sub21 = -4x^5 + 6x^4 - 9x^2 + 1
		Polinom sub21 = Operations.subtract(p2, p1);
		
		assertEquals("-1x^0+9x^2-6x^4+4x^5", sub12.polynomialToString());
		assertEquals("1x^0-9x^2+6x^4-4x^5", sub21.polynomialToString());
	}
}
