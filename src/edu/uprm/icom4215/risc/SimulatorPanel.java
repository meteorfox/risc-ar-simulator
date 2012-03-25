/*
 * Created by JFormDesigner on Mon Nov 22 15:24:33 AST 2010
 */

package edu.uprm.icom4215.risc;

import javax.swing.*;
import com.jgoodies.forms.layout.*;

/**
 * @author Carlos Torres
 */
public class SimulatorPanel extends JPanel {
	public SimulatorPanel() {
		initComponents();
	}
	public void setMemTextArea(final String value) {
		textArea1.setText(value);
		textArea1.setCaretPosition(0);
	}
	public void setKBField(final String value) {
	
		kbField.setText(value);
	}
	public void setHexField(final String value) {
		hexField.setText(value);
	}
	public void setPCField(final String value) {
		pcField.setText(value);
	}
	public void setIRField(final String vavlue) {
		irField.setText(vavlue);
	}
	public void setSRField(final String vavlue) {
		srField.setText(vavlue);
	}
	public void setACField(final String vavlue) {
		acField.setText(vavlue);
	}
	public void setR0Field(final String vavlue) {
		r0Field.setText(vavlue);
	}
	public void setR1Field(final String vavlue) {
		r1Field.setText(vavlue);
	}
	public void setR2Field(final String vavlue) {
		r2Field.setText(vavlue);
	}
	public void setR3Field(final String vavlue) {
		r3Field.setText(vavlue);
	}
	public void setR4Field(final String vavlue) {
		r4Field.setText(vavlue);
	}
	public void setR5Field(final String vavlue) {
		r5Field.setText(vavlue);
	}
	public void setR6Field(final String vavlue) {
		r6Field.setText(vavlue);
	}
	public void setR7Field(final String vavlue) {
		r7Field.setText(vavlue);
	}
	
	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Carlos Torres
		label16 = new JLabel();
		label13 = new JLabel();
		pcLabel = new JLabel();
		pcField = new JTextField();
		scrollPane1 = new JScrollPane();
		textArea1 = new JTextArea();
		irLabel = new JLabel();
		irField = new JTextField();
		srLabel = new JLabel();
		srField = new JTextField();
		acLabel = new JLabel();
		acField = new JTextField();
		label15 = new JLabel();
		r0Label = new JLabel();
		r0Field = new JTextField();
		r1Label = new JLabel();
		r1Field = new JTextField();
		r2Label = new JLabel();
		r2Field = new JTextField();
		r3Label = new JLabel();
		r3Field = new JTextField();
		r4Label = new JLabel();
		r4Field = new JTextField();
		kbLabel = new JLabel();
		r5Label = new JLabel();
		r5Field = new JTextField();
		kbField = new JTextField();
		r6Label = new JLabel();
		r6Field = new JTextField();
		hexLabel = new JLabel();
		r7Label = new JLabel();
		r7Field = new JTextField();
		hexField = new JTextField();
		CellConstraints cc = new CellConstraints();

		//======== this ========

		// JFormDesigner evaluation mark
		setBorder(new javax.swing.border.CompoundBorder(
			new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
				"JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
				javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
				java.awt.Color.red), getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

		setLayout(new FormLayout(
			"2*(default, $lcgap), 85dlu, 2*($lcgap, default), $lcgap, [14dlu,default], $lcgap, [85dlu,default], $lcgap, default",
			"16*(default, $lgap), default"));

		//---- label16 ----
		label16.setText("Processor State");
		add(label16, cc.xy(5, 3));

		//---- label13 ----
		label13.setText("Memory:");
		add(label13, cc.xywh(13, 3, 3, 1, CellConstraints.FILL, CellConstraints.DEFAULT));

		//---- pcLabel ----
		pcLabel.setText("PC:");
		add(pcLabel, cc.xy(3, 5));
		add(pcField, cc.xy(5, 5));

		//======== scrollPane1 ========
		{
			scrollPane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			scrollPane1.setViewportView(textArea1);
		}
		add(scrollPane1, cc.xywh(13, 5, 1, 17));

		//---- irLabel ----
		irLabel.setText("IR:");
		add(irLabel, cc.xy(3, 7));
		add(irField, cc.xy(5, 7));

		//---- srLabel ----
		srLabel.setText("SR:");
		add(srLabel, cc.xy(3, 9));
		add(srField, cc.xy(5, 9));

		//---- acLabel ----
		acLabel.setText("Ac:");
		add(acLabel, cc.xy(3, 11));
		add(acField, cc.xy(5, 11));

		//---- label15 ----
		label15.setText("Registers");
		add(label15, cc.xy(5, 15));

		//---- r0Label ----
		r0Label.setText("R0:");
		add(r0Label, cc.xy(3, 17));
		add(r0Field, cc.xy(5, 17));

		//---- r1Label ----
		r1Label.setText("R1:");
		add(r1Label, cc.xy(3, 19));
		add(r1Field, cc.xy(5, 19));

		//---- r2Label ----
		r2Label.setText("R2:");
		add(r2Label, cc.xy(3, 21));
		add(r2Field, cc.xy(5, 21));

		//---- r3Label ----
		r3Label.setText("R3:");
		add(r3Label, cc.xy(3, 23));
		add(r3Field, cc.xy(5, 23));

		//---- r4Label ----
		r4Label.setText("R4:");
		add(r4Label, cc.xy(3, 25));
		add(r4Field, cc.xy(5, 25));

		//---- kbLabel ----
		kbLabel.setText("Keyboard");
		add(kbLabel, cc.xy(13, 25));

		//---- r5Label ----
		r5Label.setText("R5:");
		add(r5Label, cc.xy(3, 27));
		add(r5Field, cc.xy(5, 27));
		add(kbField, cc.xy(13, 27));

		//---- r6Label ----
		r6Label.setText("R6:");
		add(r6Label, cc.xy(3, 29));
		add(r6Field, cc.xy(5, 29));

		//---- hexLabel ----
		hexLabel.setText("Hex Display");
		add(hexLabel, cc.xy(13, 29, CellConstraints.DEFAULT, CellConstraints.CENTER));

		//---- r7Label ----
		r7Label.setText("R7:");
		add(r7Label, cc.xy(3, 31));
		add(r7Field, cc.xy(5, 31));
		add(hexField, cc.xy(13, 31));
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Carlos Torres
	private JLabel label16;
	private JLabel label13;
	private JLabel pcLabel;
	private JTextField pcField;
	private JScrollPane scrollPane1;
	private JTextArea textArea1;
	private JLabel irLabel;
	private JTextField irField;
	private JLabel srLabel;
	private JTextField srField;
	private JLabel acLabel;
	private JTextField acField;
	private JLabel label15;
	private JLabel r0Label;
	private JTextField r0Field;
	private JLabel r1Label;
	private JTextField r1Field;
	private JLabel r2Label;
	private JTextField r2Field;
	private JLabel r3Label;
	private JTextField r3Field;
	private JLabel r4Label;
	private JTextField r4Field;
	private JLabel kbLabel;
	private JLabel r5Label;
	private JTextField r5Field;
	private JTextField kbField;
	private JLabel r6Label;
	private JTextField r6Field;
	private JLabel hexLabel;
	private JLabel r7Label;
	private JTextField r7Field;
	private JTextField hexField;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
