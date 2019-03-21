package ro.tuc.tp.assig1;

import static org.junit.Assert.*;

import org.junit.Test;

public class IntegrationTesting {

	@Test
	public void integrationTest() {
		Monom m11 = new Monom(1, 6);
		Monom m12 = new Monom(5, 4);
		Monom m13 = new Monom(8, 3);
		Monom m14 = new Monom(-2, 1);
		Monom m15 = new Monom(-3, 0);
		
		Polinom p1 = new Polinom();
		
		//P1 = x^6 + 5x^4 + 8x^3 - 2x - 3
		p1.addToPolinom(m11);
		p1.addToPolinom(m12);
		p1.addToPolinom(m13);
		p1.addToPolinom(m14);
		p1.addToPolinom(m15);
		//Expecting der = 1/7x^7 + x^5 + 2x^4 - x^2 - 3x
		//Note: 1/7 ~ 0.1428
		//Coefficients are restrained to 2 decimals
		Polinom integral = Operations.integrate(p1);
		assertEquals("-3x^1-1x^2+2x^4+1x^5+0,14x^7", integral.polynomialToString());
	}

}
