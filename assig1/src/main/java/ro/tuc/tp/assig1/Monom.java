package ro.tuc.tp.assig1;

public class Monom {
	private float coefficient;
	private int degree;
	
	public Monom() {
	}
	
	public Monom(float coefficient, int degree) {
		this.coefficient = coefficient;
		this.degree = degree;
	}

	public float getCoefficient() {
		return coefficient;
	}

	public void setCoefficient(float coefficient) {
		this.coefficient = coefficient;
	}

	public int getDegree() {
		return degree;
	}

	public void setDegree(int degree) {
		this.degree = degree;
	}
	
	public String monomToString() {
		return null;
	}
}
