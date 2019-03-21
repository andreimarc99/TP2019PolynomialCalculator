package ro.tuc.tp.assig1;

import static org.junit.Assert.*;

import org.junit.Test;

public class MultiplicationTesting {

	@Test
	public void multiplicationTest() {
		Monom m11 = new Monom(2, 3);
		Monom m12 = new Monom(4, 1);
		Monom m21 = new Monom(1, 3);
		Monom m22 = new Monom(-2, 2);
		Monom m23 = new Monom(1, 0);  
		
		Polinom p1 = new Polinom();
		Polinom p2 = new Polinom();
		
		//P1 = 2x^3 + 4x^1
		p1.addToPolinom(m11);
		p1.addToPolinom(m12);
		//P2 = 1x^3 - 2x^2 + 1
		p2.addToPolinom(m21);
		p2.addToPolinom(m22);
		p2.addToPolinom(m23);
		
		//Expecting mul = 2x^6 - 4x^5 + 4x^4 - 6x^3 + 4x
		Polinom mul = Operations.multiply(p1, p2);
		assertEquals("4x^1-6x^3+4x^4-4x^5+2x^6", mul.polynomialToString());
	}

}
