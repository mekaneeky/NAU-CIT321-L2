// Java program to create a simple calculator
// with basic +, -, /, * using java swing elements

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
class two_stroke extends JFrame implements ActionListener {
	// create a frame
	static JFrame f;

	// create a textfield
	static JTextField l_oil, l_percentage, l_fuel;

	// store operator and operands
	String s_petrol, s_ratio, s_result;

	// default constructor
	two_stroke()
	{
		s_petrol = s_ratio = s_result = "0";
	}

	// main function
	public static void main(String args[])
	{
		// create a frame
		f = new JFrame("2-stroke Fuel Calculator");

		try {
			// set look and feel
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (Exception e) {
			System.err.println(e.getMessage());
		}

		// create a object of class
		two_stroke c = new two_stroke();

		// create a textfield
		l_oil = new JTextField(16);
        l_percentage = new JTextField(16);
        l_fuel = new JTextField(16);
        // set the textfield to non editable
		//l.setEditable(false);

		// create number buttons and some operators
		JButton b_calc_ratio, b_calc_oil;

		// create number buttons
		b_calc_ratio = new JButton("Calculate Oil");
		b_calc_oil = new JButton("Calculate Fuel");
		

		// create a panel
		JPanel p = new JPanel();

		// add action listeners
		b_calc_ratio.addActionListener(c);
		b_calc_oil.addActionListener(c);

        JLabel label_oil = new JLabel("Oil (In mL):");
        JLabel label_percentage = new JLabel("Oil Percentage 1/X: ");
        JLabel label_fuel = new JLabel("Fuel (In L):");


		// add elements to panel
		p.add(label_fuel);
        p.add(l_fuel);
        p.add(label_percentage);
        p.add(l_percentage);
        p.add(label_oil);
		p.add(l_oil);

        p.add(b_calc_ratio);
		p.add(b_calc_oil);
	
		// set Background of panel
		p.setBackground(Color.blue);

		// add panel to frame
		f.add(p);

		f.setSize(250, 400);
		f.show();
	}
	public void actionPerformed(ActionEvent e)
	{
		String s = e.getActionCommand();
        s_petrol = l_fuel.getText();
        s_ratio = l_percentage.getText();
        s_result = l_oil.getText();

		if (s == "Calculate Oil") {

			double te;

            te = (Double.parseDouble(s_petrol) * (1/Double.parseDouble(s_ratio)) * 1000);
            s_result = Double.toString(te);
            l_oil.setText(s_result);
			
			//s1 = s2 = "";
		} else if (s == "Calculate Fuel") {
            double te;
            
            te = (Double.parseDouble(s_result) / (1/Double.parseDouble(s_ratio)) /1000 );
            s_petrol = Double.toString(te);
            l_fuel.setText(s_petrol);

        }
		

			// set the value of text
		}
	}


