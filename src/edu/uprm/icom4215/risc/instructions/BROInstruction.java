package edu.uprm.icom4215.risc.instructions;

import edu.uprm.icom4215.risc.ProcessorState;

public class BROInstruction implements Instruction {

	@Override
	public void execute(ProcessorState state) {
		int overflowStatus = state.getOverflow();
		
		if (overflowStatus == 1) {
			int accumulator = state.readAccumulator();
			state.setPC(accumulator);
		}
		System.out.println("BRO");
	}

}
