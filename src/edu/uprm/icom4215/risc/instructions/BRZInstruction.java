package edu.uprm.icom4215.risc.instructions;

import edu.uprm.icom4215.risc.ProcessorState;

public class BRZInstruction implements Instruction {

	@Override
	public void execute(ProcessorState state) {
		int zeroStatus = state.getZero();
		
		if (zeroStatus == 1) {
			int accumulator = state.readAccumulator();
			state.setPC(accumulator);
		}
		System.out.println("BRZ");
	}

}
