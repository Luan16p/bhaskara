package bhaskara;

import javax.swing.*;
import java.awt.*;

public class Interface {
	private JFrame UI;
	private JLabel text_h2;
	private JLabel label_for_a;
	private JLabel label_for_b;
	private JLabel label_for_c;
	private JTextField input_get_a;
	private JTextField input_get_b;
	private JTextField input_get_c;
	private JButton submit;

	public Interface() {
		DefineInterfaceElements();
		AddInterfaceElements();
		
		UI.setSize(500, 500);
		UI.setVisible(true);
	}
	
	private void DefineInterfaceElements() {
		UI = new JFrame();
		text_h2 = new JLabel("Bem vindo ao 'BhaskaraIF'");
		
		label_for_a = new JLabel("Digite o Valor de A:");
		input_get_a = new JTextField(15);
		
		input_get_a.setMaximumSize(new Dimension(Integer.MAX_VALUE, 45));
		
		label_for_b = new JLabel("Digite o Valor de B:");
		input_get_b = new JTextField(15);
		
		input_get_b.setMaximumSize(new Dimension(Integer.MAX_VALUE, 45));
		
		label_for_c = new JLabel("Digite o Valor de C:");
		input_get_c = new JTextField(15);
		
		input_get_c.setMaximumSize(new Dimension(Integer.MAX_VALUE, 45));
		
		submit = new JButton("Calcular");
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
	}

	private void addCenteredComponent(Component component) {
	    ((JComponent) component).setAlignmentX(Component.CENTER_ALIGNMENT);
	    UI.add(component);
	}
}
