package edu.uprm.icom4215.risc.instructions;

import edu.uprm.icom4215.risc.ProcessorState;

public class NOPInstruction implements Instruction {

	@Override
	public void execute(ProcessorState state) {
		System.out.println("NOP");
	}

}
