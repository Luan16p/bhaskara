package bhaskara;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

	public Interface() {
		DefineInterfaceElements();
		AddInterfaceElements();
		controllerListeners();
		
		UI.setSize(500, 500);
		UI.setVisible(true);
	}
	
	private void DefineInterfaceElements() {
		UI = new JFrame();
		text_h2 = new JLabel("Bem vindo ao 'BhaskaraIF'");
		
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
	}
	
	private void AddInterfaceElements() {
	    UI.setLayout(new BoxLayout(UI.getContentPane(), BoxLayout.Y_AXIS));

	    addCenteredComponent(text_h2);
	    
	    UI.add(Box.createVerticalStrut(7));
	    addCenteredComponent(label_for_a);
	    addCenteredComponent(input_get_a);
	    
	    UI.add(Box.createVerticalStrut(7));
	    addCenteredComponent(label_for_b);
	    addCenteredComponent(input_get_b);
	    
	    UI.add(Box.createVerticalStrut(7));
	    addCenteredComponent(label_for_c);
	    addCenteredComponent(input_get_c);
	    
	    UI.add(Box.createVerticalStrut(15));
	    addCenteredComponent(submit);
	    UI.add(Box.createVerticalStrut(15));
	    
	    addCenteredComponent(labelEquacao);
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
		      
		             labelEquacao.setText("f(x) = " + valueA + "x² +" + valueB + "x + " + valueC);
		             
		             calculeValues(valueA, valueB, valueC);
		             
				 } catch (NumberFormatException ex) {
					 JOptionPane.showMessageDialog(UI, "Por favor, digite números válidos para os valores de A, B e C.", "Erro", JOptionPane.ERROR_MESSAGE);
		         }
				
			}
		});
	}
	
	public void calculeValues(double a, double b, double c) {
		double delta = b * b - 4 * a * c;
		
		if(delta >= 0) {
			System.out.println(Math.sqrt(delta));
		}
		
		else {
			JOptionPane.showMessageDialog(UI, "Nao existe solução real.", "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}
}
