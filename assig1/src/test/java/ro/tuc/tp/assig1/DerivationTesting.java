package ro.tuc.tp.assig1;

import static org.junit.Assert.*;

import org.junit.Test;

public class DerivationTesting {

	@Test
	public void derivationTest() {
		Monom m11 = new Monom(1, 5);
		Monom m12 = new Monom(5, 4);
		Monom m13 = new Monom(2, 2);
		Monom m14 = new Monom(-5, 1);
		Monom m15 = new Monom(-3, 0);
		
		Polinom p1 = new Polinom();
		
		//P1 = x^5 + 5x^4 + 2x^2 - 5x - 3
		p1.addToPolinom(m11);
		p1.addToPolinom(m12);
		p1.addToPolinom(m13);
		p1.addToPolinom(m14);
		p1.addToPolinom(m15);
		//Expecting der = 5x^4 + 20x^3 + 4x - 5
		//Coefficients are restrained to 2 decimals
		Polinom der = Operations.derivate(p1);
		assertEquals("-5x^0+4x^1+20x^3+5x^4", der.polynomialToString());
	}

}
