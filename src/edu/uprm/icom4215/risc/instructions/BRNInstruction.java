package edu.uprm.icom4215.risc.instructions;

import edu.uprm.icom4215.risc.ProcessorState;

public class BRNInstruction implements Instruction {

	@Override
	public void execute(ProcessorState state) {
		int NegStatus = state.getNegative();
		
		if (NegStatus == 1) {
			int accumulator = state.readAccumulator();
			state.setPC(accumulator);
		}
		System.out.println("BRN");
	}

}
