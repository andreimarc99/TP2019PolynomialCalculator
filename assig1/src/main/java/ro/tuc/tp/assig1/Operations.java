package ro.tuc.tp.assig1;

import java.util.HashMap;

public class Operations {

	public static Polinom add(Polinom firstPol, Polinom secondPol) {
		Polinom sum = new Polinom();
		sum.copyPolinom(firstPol);
		for (HashMap.Entry<Integer, Float> entry : secondPol.getPolinom().entrySet()) {
			if (sum.getPolinom().containsKey(entry.getKey())) {
				sum.getPolinom().put(entry.getKey(), sum.getPolinom().get(entry.getKey()) + entry.getValue());
			} else {
				sum.getPolinom().put(entry.getKey(), entry.getValue());
			}
		}
		return sum;
	}

	public static Polinom subtract(Polinom firstPol, Polinom secondPol) {
		Polinom diff = new Polinom();
		diff.copyPolinom(firstPol);
		for (HashMap.Entry<Integer, Float> entry : secondPol.getPolinom().entrySet()) {
			if (diff.getPolinom().containsKey(entry.getKey())) {
				diff.getPolinom().put(entry.getKey(), diff.getPolinom().get(entry.getKey()) - entry.getValue());
			} else {
				diff.getPolinom().put(entry.getKey(), -entry.getValue());
			}
		}
		return diff;
	}

	public static Polinom multiply(Polinom firstPol, Polinom secondPol) {
		Polinom mul = new Polinom();
		for (HashMap.Entry<Integer, Float> firstPolEntry : firstPol.getPolinom().entrySet()) {
			for (HashMap.Entry<Integer, Float> secondPolEntry : secondPol.getPolinom().entrySet()) {
				if (mul.getPolinom().containsKey(firstPolEntry.getKey() + secondPolEntry.getKey())) {
					mul.getPolinom().put(firstPolEntry.getKey() + secondPolEntry.getKey(),
							mul.getPolinom().get(firstPolEntry.getKey() + secondPolEntry.getKey())
									+ (firstPolEntry.getValue() * secondPolEntry.getValue()));
				} else {
					mul.getPolinom().put(firstPolEntry.getKey() + secondPolEntry.getKey(),
							firstPolEntry.getValue() * secondPolEntry.getValue());
				}
			}
		}
		return mul;
	}

	public static Polinom addMonomToPolinom(Polinom polinom, Monom monom) {
		Polinom sum = new Polinom();
		sum.copyPolinom(polinom);
		if (polinom.getPolinom().containsKey(monom.getDegree())) {
			sum.getPolinom().put(monom.getDegree(),
					polinom.getPolinom().get(monom.getDegree()) + monom.getCoefficient());
		} else {
			sum.getPolinom().put(monom.getDegree(), monom.getCoefficient());
		}
		return sum;
	}

	public static Polinom multiplyMonomToPolinom(Polinom polinom, Monom monom) {
		Polinom mul = new Polinom();
		for (HashMap.Entry<Integer, Float> entry : polinom.getPolinom().entrySet()) {
			mul.getPolinom().put(entry.getKey() + monom.getDegree(), entry.getValue() * monom.getCoefficient());
		}
		return mul;
	}

	public static DivisionResult divide(Polinom firstPol, Polinom secondPol) {
		DivisionResult div = new DivisionResult();
		Polinom q = new Polinom();
		Polinom r = new Polinom();
		q.getPolinom().put(0, (float) 0);
		r.copyPolinom(firstPol);
		while (r.getPolinom().size() != 0 && r.getMaxDegree() >= secondPol.getMaxDegree()) {
			Monom monom = new Monom(r.getPolinom().get(r.getMaxDegree()) / secondPol.getPolinom().get(secondPol.getMaxDegree()),
					r.getMaxDegree() - secondPol.getMaxDegree());;

			q = Operations.addMonomToPolinom(q, monom);
			r = Operations.subtract(r, Operations.multiplyMonomToPolinom(secondPol, monom));
		}
		
		div.setQ(q);
		div.setR(r);
		return div;
	}

	public static Polinom derivate(Polinom pol) {
		Polinom der = new Polinom();
		for (HashMap.Entry<Integer, Float> entry : pol.getPolinom().entrySet()) {
			if (entry.getKey() == 0) {
				der.getPolinom().put(entry.getKey(), (float) 0);
			} else {
				der.getPolinom().put(entry.getKey() - 1, entry.getKey() * pol.getPolinom().get(entry.getKey()));
			}
		}
		return der;
	}

	public static Polinom integrate(Polinom pol) {
		Polinom pIntegral = new Polinom();
		for (HashMap.Entry<Integer, Float> entry : pol.getPolinom().entrySet()) {
			if (entry.getKey() == 0) {
				pIntegral.getPolinom().put(entry.getKey(), (float) 0);
				pIntegral.getPolinom().put(entry.getKey() + 1,
						pol.getPolinom().get(entry.getKey()) / (entry.getKey() + 1));
			} else {
				pIntegral.getPolinom().put(entry.getKey() + 1,
						pol.getPolinom().get(entry.getKey()) / (entry.getKey() + 1));
			}
		}
		return pIntegral;
	}
}
