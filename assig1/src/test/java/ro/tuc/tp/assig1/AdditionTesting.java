package ro.tuc.tp.assig1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AdditionTesting {
	
	@Test
	public void testAddition() {
		Monom m11 = new Monom(4, 3);
		Monom m12 = new Monom(3, 2);
		Monom m13 = new Monom(-2, 0);
		Monom m21 = new Monom(6, 2);
		Monom m22 = new Monom(2, 1);
		Monom m23 = new Monom(1, 0);

		Polinom p1 = new Polinom();
		Polinom p2 = new Polinom();
		
		//P1 = 4x^3 + 3x^2 - 2
		p1.addToPolinom(m11);
		p1.addToPolinom(m12);
		p1.addToPolinom(m13);
		//P2 = 6x^2 + 2x^1 + 1x
		p2.addToPolinom(m21);
		p2.addToPolinom(m22);
		p2.addToPolinom(m23);

		//Expecting sum = 4x^3 + 9x^2 + 2x^1 - 1
		Polinom sum = Operations.add(p1, p2);
		assertEquals("-1x^0+2x^1+9x^2+4x^3", sum.polynomialToString());
	}

}
