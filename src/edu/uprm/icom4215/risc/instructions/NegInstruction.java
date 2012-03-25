package edu.uprm.icom4215.risc.instructions;

import edu.uprm.icom4215.risc.ProcessorState;

public class NegInstruction implements Instruction {

	@Override
	public void execute(ProcessorState state) {
		int accumulator = state.readAccumulator();
		
		// Neg Operation
		int result = (~accumulator) & 0xFF;
		
		state.writeAccumulator(result);
		System.out.println("NEG A");
	}

}
