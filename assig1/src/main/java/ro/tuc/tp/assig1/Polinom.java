package ro.tuc.tp.assig1;

import java.text.DecimalFormat;
import java.util.HashMap;

public class Polinom {
	private HashMap<Integer, Float> polinom = new HashMap<Integer, Float>();

	public Polinom() {
	}

	public Polinom(HashMap<Integer, Float> polinom) {
		this.polinom = polinom;
	}

	public void addToPolinom(Monom monom) {
		polinom.put(monom.getDegree(), monom.getCoefficient());
	}

	public HashMap<Integer, Float> getPolinom() {
		return polinom;
	}

	public void setPolinom(HashMap<Integer, Float> polinom) {
		this.polinom = polinom;
	}

	public static void printStringPolynomial(Polinom polinom) {
		int minKey = Integer.MAX_VALUE;
		for (HashMap.Entry<Integer, Float> entry : polinom.getPolinom().entrySet()) {
			if (entry.getKey() < minKey) {
				if (entry.getValue() != 0) {
					minKey = entry.getKey();
				}
			}
		}
		for (HashMap.Entry<Integer, Float> entry : polinom.getPolinom().entrySet()) {
			if (entry.getKey() == minKey) {
				System.out.print(entry.getValue() + "x^" + entry.getKey());
			} else if (entry.getValue() > 0) {
				System.out.print(" +" + entry.getValue() + "x^" + entry.getKey());
			} else if (entry.getValue() < 0) {
				System.out.print(" " + entry.getValue() + "x^" + entry.getKey());
			}
		}
	}
	
	public String polynomialToString() {
		int minKey = Integer.MAX_VALUE;
		String pol = new String();
		for (HashMap.Entry<Integer, Float> entry : this.getPolinom().entrySet()) {
			if (entry.getKey() < minKey) {
				if (entry.getValue() != 0) {
					minKey = entry.getKey();
				}
			}
		}
		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(2);
		boolean ok = false;
		for (HashMap.Entry<Integer, Float> entry : this.getPolinom().entrySet()) {
			if (entry.getKey() == minKey) {
				pol = pol + df.format(entry.getValue()) + "x^" + entry.getKey();
				ok = true;
			} else if (entry.getValue() > 0) {
				pol = pol + "+" + df.format(entry.getValue()) + "x^" + entry.getKey();
				ok = true;
			} else if (entry.getValue() < 0) {
				pol = pol + df.format(entry.getValue()) + "x^" + entry.getKey();
				ok = true;
			}
		}
		if (ok == false) {
			pol = "0";
		}
		return pol;
	}

	public int getMaxDegree() {
		int max = Integer.MIN_VALUE;
		for (HashMap.Entry<Integer, Float> entry : this.getPolinom().entrySet()) {
			if (entry.getKey() > max) {
				if (entry.getValue() != 0) {
					max = entry.getKey();
				}
			}
		}
		return max;
	}

	public void copyPolinom(Polinom polinom) {
		for (HashMap.Entry<Integer, Float> entry : polinom.getPolinom().entrySet()) {
			this.getPolinom().put(entry.getKey(), entry.getValue());
		}
	}
}
