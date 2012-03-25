package edu.uprm.icom4215.risc;

import java.awt.EventQueue;
import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Simulator {
	
	private MainMemory mem;
	private Processor processor;
	private static SimulatorFrame frame;
	
	public Simulator() {
		mem = MainMemory.getInstance();
		processor = new Processor();
	}
	
	public void step() {
		if (processor.isRun()) {
			processor.next();
		}
		frame.refresh(processor.getState());
	}
	
	public void run() {
		while (processor.isRun()) {
			this.step();
		}
	}
	
	public void reset() {
		processor.reset();
		
	}
	
	public boolean isHalted() {
		return !(processor.getState().isRun());
	}
	
	
	public void loadFile(File file) {
		FileLoader fL = new FileLoader();
		
		try {
			int[] instructions = fL.getInstructions(file);
			validateInstructions(instructions);
			loadIntoMemory(instructions);
			frame.refresh(processor.getState());
			
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(frame, e.getMessage(), "File Not Found",
					JOptionPane.ERROR_MESSAGE);
		} catch (InstructionsOverflowException i) {
			JOptionPane.showMessageDialog(frame, i.getMessage(), "Instructions Error",
					JOptionPane.ERROR_MESSAGE);
		} catch (NoStopInstructionFoundException e) {
			JOptionPane.showMessageDialog(frame, e.getMessage(), "Instructions Error",
					JOptionPane.ERROR_MESSAGE);
		} catch (IllegalInstructionFormatException e) {
			JOptionPane.showMessageDialog(frame, e.getMessage(), "Instructions Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void loadIntoMemory(final int[] instructions) {
		mem.resetMemory();
		
		for (int i = 0; i < instructions.length; i++) {
			int value = instructions[i];
			mem.writeByte(i, value);
		}
		
	}

	private void validateInstructions(final int[] instructions)
		throws InstructionsOverflowException {
		
		if (instructions.length > 127) {
			throw new InstructionsOverflowException(
					"Cannot load more than 128 instructions");
		} else if (instructions[instructions.length - 2] != 0xF8) {
			throw new NoStopInstructionFoundException("Missing stop instruction.");
		}
	}

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable()
		{
			public void run() {
				frame = new SimulatorFrame();
				
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}

}
