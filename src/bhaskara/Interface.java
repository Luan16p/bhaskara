package bhaskara;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class Interface {
	private JFrame UI;
	private JLabel text_h2;
	private JLabel label_for_a;
	private JLabel label_for_b;
	private JLabel label_for_c;
	private JLabel labelEquacao;
	private JTextField input_get_a;
	private JTextField input_get_b;
	private JTextField input_get_c;
	private JButton submit;
	private JLabel labelResult;
	private JLabel result;
	private DecimalFormat df;
	private Font setarFonte;

	public Interface() {
		DefineInterfaceElements();
		AddInterfaceElements();
		controllerListeners();
		
		UI.setSize(500, 500);
		UI.setVisible(true);
		UI.setLocationRelativeTo(null);
	}
	
	private void DefineInterfaceElements() {
		UI = new JFrame();
		
		setarFonte = new Font("Arial", Font.BOLD, 20);
		
		text_h2 = new JLabel("Bem vindo ao 'BhaskaraIF'");
		
		text_h2.setFont(setarFonte);
		
		label_for_a = new JLabel("Digite o Valor de A:");
		input_get_a = new JTextField(15);
		
		input_get_a.setMaximumSize(new Dimension(350, 40));
		
		label_for_b = new JLabel("Digite o Valor de B:");
		input_get_b = new JTextField(15);
		
		input_get_b.setMaximumSize(new Dimension(350, 40));
		
		label_for_c = new JLabel("Digite o Valor de C:");
		input_get_c = new JTextField(15);
		
		input_get_c.setMaximumSize(new Dimension(350, 40));
		
		submit = new JButton("Calcular");
		
		labelEquacao = new JLabel("f(x) = ax² + bx + c");
		
		labelResult = new JLabel("");
		
		result = new JLabel("");
	}
	
	private void AddInterfaceElements() {
	    UI.setLayout(new BoxLayout(UI.getContentPane(), BoxLayout.Y_AXIS));
	    
	    UI.add(Box.createVerticalStrut(15));
	    
	    addCenteredComponent(text_h2);
	    
	    UI.add(Box.createVerticalStrut(25));
	    
	    addCenteredComponent(label_for_a);
	    UI.add(Box.createVerticalStrut(5));
	    addCenteredComponent(input_get_a);
	    
	    UI.add(Box.createVerticalStrut(7));
	    addCenteredComponent(label_for_b);
	    UI.add(Box.createVerticalStrut(5));
	    addCenteredComponent(input_get_b);
	    
	    UI.add(Box.createVerticalStrut(7));
	    addCenteredComponent(label_for_c);
	    UI.add(Box.createVerticalStrut(5));
	    addCenteredComponent(input_get_c);
	    
	    UI.add(Box.createVerticalStrut(15));
	    addCenteredComponent(submit);
	    UI.add(Box.createVerticalStrut(15));
	    
	    addCenteredComponent(labelEquacao);
	    
	    UI.add(Box.createVerticalStrut(15));
	    
	    addCenteredComponent(labelResult);
	    
	    UI.add(Box.createVerticalStrut(15));
	    
	    addCenteredComponent(result);
	}

	private void addCenteredComponent(Component component) {
	    ((JComponent) component).setAlignmentX(Component.CENTER_ALIGNMENT);
	    
	    UI.add(component);
	}
	
	private void controllerListeners() {
		submit.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String getContextA = input_get_a.getText();
				String getContextB = input_get_b.getText();
				String getContextC = input_get_c.getText();
				
				 try {
					 double valueA = Double.parseDouble(getContextA);
		             double valueB = Double.parseDouble(getContextB);
		             double valueC = Double.parseDouble(getContextC);
		      
		             labelEquacao.setText("f(x) = " + valueA + "x² +" + valueB + "x +" + valueC);
		             
		             calculeValues(valueA, valueB, valueC);
		             
				 } catch (NumberFormatException ex) {
					 JOptionPane.showMessageDialog(UI, "Por favor, digite números válidos para os valores de A, B e C.", "Erro", JOptionPane.ERROR_MESSAGE);
		         }
				
			}
		});
	}
	
	public void calculeValues(double a, double b, double c) {
		double delta = b * b - 4 * a * c; 

		df = new DecimalFormat("#.###");
		
		if (delta > 0) {
			double inters1 = (-b + Math.sqrt(delta))/(2*a);
			double inters2 = (-b - Math.sqrt(delta))/(2*a);
			
			
			labelResult.setText("Resultado");
			
			result.setText("A curva toca o plano X nos pontos: " + df.format(inters1) + " e " + df.format(inters2));
			
			System.out.println("Resultado: \nX' -> " + inters1 + "\nX'' -> " + inters2);
		}
		
		else if (delta == 0) {
			double inters = (-b)/(2*a);
			
			labelResult.setText("Resultado");
			
			result.setText("A curva toca o plano X em: " + df.format(inters));
			
			System.out.println("Resultado: \nX -> " + inters);
		}
		
		else {
			JOptionPane.showMessageDialog(UI, "Nao existe solução real.", "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}
}
