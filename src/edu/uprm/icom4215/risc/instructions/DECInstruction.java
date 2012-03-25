package edu.uprm.icom4215.risc.instructions;

import edu.uprm.icom4215.risc.ProcessorState;

public class DECInstruction implements Instruction {

	public DECInstruction() {
		
	}
	
	@Override
	public void execute(ProcessorState state) {
		int accumulator = state.readAccumulator();
		
		state.writeAccumulator(accumulator - 1);
		System.out.println("DEC A");
	}

}
