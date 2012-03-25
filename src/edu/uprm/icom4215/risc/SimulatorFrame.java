package edu.uprm.icom4215.risc;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.filechooser.FileFilter;

public class SimulatorFrame extends JFrame {
	
	private JFileChooser fileOpen;
	private Simulator sim;
	private MainMemory mem;
	private SimulatorPanel panel;
	private JButton runButton;
	private JButton stepButton;
	private JButton resetButton;
	
	public SimulatorFrame() {
		sim = new Simulator();
		mem = MainMemory.getInstance();
		panel = new SimulatorPanel();
		
		this.setTitle("RISC-AR Simulator");		
		this.addMenu();
		this.setLayout(new BorderLayout());
		this.add(panel, BorderLayout.CENTER);
		this.addButtons();
		this.pack();
		this.setSize(520, 450);
	}

	private void addButtons() {
		JPanel buttons = new JPanel();
		buttons.setLayout(new FlowLayout());
		
		runButton = new JButton("Run");
		stepButton = new JButton("Step");
		resetButton = new JButton("Reset");
		
		runButton.addActionListener(new RunButtonListener());
		stepButton.addActionListener(new StepButtonListener());
		resetButton.addActionListener(new ResetButtonListener());
		
		runButton.setEnabled(false);
		stepButton.setEnabled(false);
		resetButton.setEnabled(false);
		
		buttons.add(resetButton);
		buttons.add(stepButton);
		buttons.add(runButton);
		
		this.add(buttons, BorderLayout.SOUTH);
	}

	public void refresh(ProcessorState state) {
		displayProcessorState(state);
		displayMemoryContents();
		this.repaint();
	}
	
	public void resetButtons() {
		runButton.setEnabled(true);
		stepButton.setEnabled(true);
		resetButton.setEnabled(false);
	}

	private void displayMemoryContents() {
		StringBuilder text = new StringBuilder();
		
		for (int i = 0; i < mem.getMemorySize(); i++) {
			text.append(
					Integer.toHexString(i) + ":  "
					+ Integer.toHexString(mem.readByte(i))
					+ "\n");
		}
		
		panel.setMemTextArea(text.toString().toUpperCase());
		
		
	}

	private void displayProcessorState(final ProcessorState state) {
		panel.setPCField(addZeroesToCompleteByte(
				Integer.toBinaryString(state.getPC())));
		
		panel.setIRField(addZeroesToCompleteWord(
				Integer.toBinaryString(state.getIR())));
		
		panel.setSRField(""+state.getZero()+""+state.getCarry()
				+""+state.getNegative()+""+state.getOverflow());
		
		
		panel.setACField(addZeroesToCompleteByte(
				Integer.toBinaryString(state.readAccumulator())));
		
		int[] registers = state.getRegisters();
		
		String value = Integer.toBinaryString(registers[0]);
		panel.setR0Field(addZeroesToCompleteByte(value));
		
		value = Integer.toBinaryString(registers[1]);
		panel.setR1Field(addZeroesToCompleteByte(value));
		
		value = Integer.toBinaryString(registers[2]);
		panel.setR2Field(addZeroesToCompleteByte(value));
		
		value = Integer.toBinaryString(registers[3]);
		panel.setR3Field(addZeroesToCompleteByte(value));
		
		value = Integer.toBinaryString(registers[4]);
		panel.setR4Field(addZeroesToCompleteByte(value));
		
		value = Integer.toBinaryString(registers[5]);
		panel.setR5Field(addZeroesToCompleteByte(value));
		
		value = Integer.toBinaryString(registers[6]);
		panel.setR6Field(addZeroesToCompleteByte(value));
		
		value = Integer.toBinaryString(registers[7]);
		panel.setR7Field(addZeroesToCompleteByte(value));
		
		String kbText = (char)mem.readByte(250)+""+(char)mem.readByte(251);
		panel.setKBField(kbText);
		
		String hexText = (char)mem.readByte(252)+""+(char)mem.readByte(253)
						 +""+(char)mem.readByte(254)+""+(char)mem.readByte(254)
						 +""+(char)mem.readByte(255);
		panel.setHexField(hexText);
	}
	
	private String addZeroesToCompleteByte(String value) {
		String result = "";
		if (value.length() < 8) {
			String zeroes = "";
			for (int i = 0; i < 8 - value.length(); i++) {
				zeroes = zeroes.concat("0");
			}
			
			result =  zeroes + value;
		}
		else {
			result = value;
		}
		
		result = result.substring(0, 4) + " " + result.substring(4,8);
		
		return result;
	}
	
	private String addZeroesToCompleteWord(String value) {
		String result = "";
		if (value.length() < 16) {
			String zeroes = "";
			for (int i = 0; i < 16 - value.length(); i++) {
				zeroes = zeroes.concat("0");
			}
			
			result = zeroes + value;
		}
		else {
			result = value;
		}
		
		result = result.substring(0, 4) + " " + result.substring(4,8) + " "
			+ result.substring(8, 12) + " " + result.substring(12,16);
		return result;
	}

	private void addMenu() {
		
		JMenu fileMenu = new JMenu("File");
		JMenuItem openMenuItem = new JMenuItem("Open File...");
		
		openMenuItem.addActionListener(new OpenMenuListener());
		fileMenu.add(openMenuItem);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		menuBar.add(fileMenu);
		fileOpen = new JFileChooser();
		FileFilter fFilter = new SRFileFilter();
		fileOpen.addChoosableFileFilter(fFilter);
		fileOpen.setAcceptAllFileFilterUsed(false);
		fileOpen.setMultiSelectionEnabled(false);
		
	}
	
	private class RunButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			sim.run();
			runButton.setEnabled(false);
			stepButton.setEnabled(false);
			resetButton.setEnabled(true);
		}
		
	}
	
	private class StepButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			sim.step();
			resetButton.setEnabled(true);
			if (sim.isHalted()) {
				stepButton.setEnabled(false);
			}
		}
		
	}
	
	private class ResetButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			sim.reset();
			runButton.setEnabled(true);
			stepButton.setEnabled(true);
			resetButton.setEnabled(false);
		}
		
	}
		
	private class OpenMenuListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			int returnVal = fileOpen.showOpenDialog(getParent());
			
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fileOpen.getSelectedFile();
				sim.reset();
				sim.loadFile(file);
				resetButtons();
			}
		}
		
	}
}
