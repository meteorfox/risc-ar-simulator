package edu.uprm.icom4215.risc.instructions;

import edu.uprm.icom4215.risc.ProcessorState;

public class StopInstruction implements Instruction {

	@Override
	public void execute(ProcessorState state) {
		System.out.println("STOP");
		state.setRun(false);
	}
}
