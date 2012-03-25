package edu.uprm.icom4215.risc.instructions;

import edu.uprm.icom4215.risc.ProcessorState;

public class BRCInstruction implements Instruction {

	@Override
	public void execute(ProcessorState state) {
		int carryStatus = state.getCarry();
		
		if (carryStatus == 1) {
			int accumulator = state.readAccumulator();
			state.setPC(accumulator);
		}
		
		System.out.println("BRC");
	}

}
