package edu.uprm.icom4215.risc.instructions;

import edu.uprm.icom4215.risc.ProcessorState;

public class RRCInstruction implements Instruction {

	@Override
	public void execute(ProcessorState state) {
		int accumulator = state.readAccumulator();
		int carry = state.getCarry();
		int MSB = state.getMostSignificantBit(accumulator);
		
		// RRC Operation
		state.writeAccumulator(((accumulator >>> 1) + (carry << 7)) & 0xFF);
		state.setCarry(MSB);
	}

}
