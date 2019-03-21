package ro.tuc.tp.assig1.gui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import ro.tuc.tp.assig1.DivisionResult;
import ro.tuc.tp.assig1.Operations;
import ro.tuc.tp.assig1.Polinom;

public class GUI extends JFrame {
	public final static int MAX_ELEMENTS = 100;
	private JTextField firstPolTextField;
	private JTextField secondPolTextField;
	private JLabel firstPolLabel;
	private JLabel secondPolLabel;
	private JButton addBtn;
	private JButton subtractBtn;
	private JButton multiplyBtn;
	private JButton divideBtn;
	private JButton derivateP1;
	private JButton derivateP2;
	private JButton integrateP1;
	private JButton integrateP2;
	private JTextArea resultTextArea;
	private JButton clearButton;

	public GUI() {
		this.setBounds(100, 100, 630, 430);
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		firstPolLabel = new JLabel("Enter first polynomial below:");
		firstPolLabel.setBounds(10, 10, 190, 20);
		getContentPane().add(firstPolLabel);

		firstPolTextField = new JTextField();
		firstPolTextField.setBounds(10, 40, 200, 20);
		getContentPane().add(firstPolTextField);

		secondPolLabel = new JLabel("Enter second polynomial below:");
		secondPolLabel.setBounds(10, 70, 190, 20);
		getContentPane().add(secondPolLabel);

		secondPolTextField = new JTextField();
		secondPolTextField.setBounds(10, 100, 200, 20);
		getContentPane().add(secondPolTextField);

		addBtn = new JButton("Add (P1 + P2)");
		addBtn.setBounds(10, 160, 200, 20);
		addBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Polinom p1 = new Polinom();
				Polinom p2 = new Polinom();
				if (firstPolTextField.getText().trim().equals("") || secondPolTextField.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "Complete both fields");
				} else {
					boolean ok = true;
					if (firstPolTextField.getText().trim() != null) {
						try {
							p1 = GUI.parsePolynomial(firstPolTextField.getText().trim());
						} catch (Exception e1) {
							ok = false;
							JOptionPane.showMessageDialog(null, "Incorrect format for first polynomial");
						}
					}
					if (secondPolTextField.getText().trim() != null) {
						try {
							p2 = GUI.parsePolynomial(secondPolTextField.getText().trim());
						} catch (Exception e2) {
							JOptionPane.showMessageDialog(null, "Incorrect format for second polynomial");
							ok = false;
						}
					}
					if (ok) {
						resultTextArea
								.append("Adding P1 to P2:\n" + Operations.add(p1, p2).polynomialToString() + "\n");
					}
				}
			}
		});
		getContentPane().add(addBtn);

		subtractBtn = new JButton("Subtract (P1 - P2)");
		subtractBtn.setBounds(10, 190, 200, 20);
		subtractBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Polinom p1 = new Polinom();
				Polinom p2 = new Polinom();
				if (firstPolTextField.getText().trim().equals("") || secondPolTextField.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "Complete both fields");
				} else {
					boolean ok = true;
					if (firstPolTextField.getText().trim() != null) {
						try {
							p1 = GUI.parsePolynomial(firstPolTextField.getText().trim());
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(null, "Incorrect format for first polynomial");
							ok = false;
						}
					}
					if (secondPolTextField.getText().trim() != null) {
						try {
							p2 = GUI.parsePolynomial(secondPolTextField.getText().trim());
						} catch (Exception e2) {
							JOptionPane.showMessageDialog(null, "Incorrect format for second polynomial");
							ok = false;
						}
					}
					if (ok) {
						resultTextArea.append(
								"Subtracting P2 from P1:\n" + Operations.subtract(p1, p2).polynomialToString() + "\n");
					}
				}
			}
		});
		getContentPane().add(subtractBtn);

		multiplyBtn = new JButton("Multiply (P1 * P2)");
		multiplyBtn.setBounds(10, 220, 200, 20);
		multiplyBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Polinom p1 = new Polinom();
				Polinom p2 = new Polinom();
				if (firstPolTextField.getText().trim().equals("") || secondPolTextField.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "Complete both fields");
				} else {
					boolean ok = true;
					if (firstPolTextField.getText().trim() != null) {
						try {
							p1 = GUI.parsePolynomial(firstPolTextField.getText().trim());
						} catch (Exception e1) {
							ok = false;
							JOptionPane.showMessageDialog(null, "Incorrect format for first polynomial");
						}
					}
					if (secondPolTextField.getText().trim() != null) {
						try {
							p2 = GUI.parsePolynomial(secondPolTextField.getText().trim());
						} catch (Exception e2) {
							ok = false;
							JOptionPane.showMessageDialog(null, "Incorrect format for second polynomial");
						}
					}
					if (ok) {
						resultTextArea.append(
								"Multiplying P1 and P2:\n" + Operations.multiply(p1, p2).polynomialToString() + "\n");
					}
				}
			}
		});
		getContentPane().add(multiplyBtn);

		divideBtn = new JButton("Divide (P1 / P2)");
		divideBtn.setBounds(10, 250, 200, 20);
		divideBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Polinom p1 = new Polinom();
				Polinom p2 = new Polinom();
				if (firstPolTextField.getText().trim().equals("") || secondPolTextField.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "Complete both fields");
				} else {
					boolean ok = true;
					if (firstPolTextField.getText().trim() != null) {
						try {
							p1 = GUI.parsePolynomial(firstPolTextField.getText().trim());
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(null, "Incorrect format for first polynomial");
							ok = false;
						}
					}
					if (secondPolTextField.getText().trim() != null) {
						try {
							p2 = GUI.parsePolynomial(secondPolTextField.getText().trim());
						} catch (Exception e2) {
							JOptionPane.showMessageDialog(null, "Incorrect format for second polynomial");
							ok = false;
						}
					}
					if (ok) {
						DivisionResult divRes = Operations.divide(p1, p2);
						resultTextArea.append("Dividing P1 by P2:\nQ = " + divRes.getQ().polynomialToString() + "; R = "
								+ divRes.getR().polynomialToString() + "\n");
					}
				}
			}
		});
		getContentPane().add(divideBtn);

		derivateP1 = new JButton("DerivateP1");
		derivateP1.setBounds(10, 280, 100, 20);
		derivateP1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Polinom p1 = new Polinom();
				if (firstPolTextField.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "Complete the necessary field");
				} else {
					boolean ok = true;
					if (firstPolTextField.getText().trim() != null) {
						try {
							p1 = GUI.parsePolynomial(firstPolTextField.getText().trim());
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(null, "Incorrect format for first polynomial");
							ok = false;
						}
					}
					if (ok) {
						resultTextArea.append("Derivating P1:\n" + Operations.derivate(p1).polynomialToString() + "\n");
					}
				}
			}
		});
		getContentPane().add(derivateP1);

		derivateP2 = new JButton("DerivateP2");
		derivateP2.setBounds(110, 280, 100, 20);
		derivateP2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Polinom p2 = new Polinom();
				if (secondPolTextField.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "Complete the necessary field");
				} else {
					boolean ok = true;
					if (secondPolTextField.getText().trim() != null) {
						try {
							p2 = GUI.parsePolynomial(secondPolTextField.getText().trim());
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(null, "Incorrect format for first polynomial");
							ok = false;
						}
					}
					if (ok) {
						resultTextArea.append("Derivating P2:\n" + Operations.derivate(p2).polynomialToString() + "\n");
					}
				}
			}
		});
		getContentPane().add(derivateP2);

		integrateP1 = new JButton("IntegrateP1");
		integrateP1.setBounds(10, 310, 100, 20);
		integrateP1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Polinom p1 = new Polinom();
				if (firstPolTextField.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "Complete the necessary field");
				} else {
					boolean ok = true;
					if (firstPolTextField.getText().trim() != null) {
						try {
							p1 = GUI.parsePolynomial(firstPolTextField.getText().trim());
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(null, "Incorrect format for first polynomial");
							ok = false;
						}
					}
					if (ok) {
						resultTextArea
								.append("Integrating P1:\n" + Operations.integrate(p1).polynomialToString() + "\n");
					}
				}
			}
		});
		getContentPane().add(integrateP1);

		integrateP2 = new JButton("IntegrateP2");
		integrateP2.setBounds(110, 310, 100, 20);
		integrateP2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Polinom p2 = new Polinom();
				if (secondPolTextField.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "Complete the necessary field");
				} else {
					boolean ok = true;
					if (secondPolTextField.getText().trim() != null) {
						try {
							p2 = GUI.parsePolynomial(secondPolTextField.getText().trim());
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(null, "Incorrect format for first polynomial");
							ok = false;
						}
					}
					if (ok) {
						resultTextArea
								.append("Integrating P2:\n" + Operations.integrate(p2).polynomialToString() + "\n");
					}
				}
			}
		});
		getContentPane().add(integrateP2);

		resultTextArea = new JTextArea();
		resultTextArea.setEditable(false);
		resultTextArea.append("You will represent the polynomial in the following way:" + " \nax^n+-bx^n-1+-...+-c\n");
		JScrollPane scrollPane = new JScrollPane(resultTextArea);
		scrollPane.setBounds(300, 20, 300, 330);
		getContentPane().add(scrollPane);
		
		clearButton = new JButton("Clear");
		clearButton.setBounds(499, 350, 100, 20);
		clearButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				resultTextArea.setText(null);
				resultTextArea.append("You will represent the polynomial in the following way:" + " \nax^n+-bx^n-1+-...+-c\n");
			}
		});
		getContentPane().add(clearButton);
	}

	public static Polinom parsePolynomial(String stringPol) {
		Polinom polinom = new Polinom();
		Pattern pattern = Pattern.compile("([+-]?[^-+]+)");
		List<String> monomArray = new ArrayList<String>();
		String[][] splitted = new String[MAX_ELEMENTS][3];
		Matcher matcher = pattern.matcher(stringPol);
		while (matcher.find()) {
			monomArray.add(matcher.group(1).toString());
		}
		int i = 0;
		for (String s : monomArray) {
			splitted[i] = s.split("x");
			++i;
		}
		for (i = 0; i < splitted.length; ++i) {
			if (splitted[i][0] != null && splitted[i][1] != null) {
				Float coeff = Float.parseFloat(splitted[i][0]);
				Integer degree = Integer.parseInt(splitted[i][1].substring(1));
				if (polinom.getPolinom().containsKey(degree)) {
					polinom.getPolinom().put(degree, polinom.getPolinom().get(degree) + coeff);
				} else {
					polinom.getPolinom().put(degree, coeff);
				}
			}
		}
		return polinom;
	}
}
