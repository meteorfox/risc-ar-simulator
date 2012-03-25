package edu.uprm.icom4215.risc.instructions;

import edu.uprm.icom4215.risc.Decoder;
import edu.uprm.icom4215.risc.ProcessorState;

public class MulInstruction implements Instruction {

	public MulInstruction() {
		
	}
	
	@Override
	public void execute(ProcessorState state) {
		int accumulator = state.readAccumulator();
		
		int instReg = state.getIR();
		int regIndex = Decoder.getRegAddress(instReg);
		int regContents = state.readRegister(regIndex);
		
		System.out.println("MUL A R["+regIndex+"]");
		// Multiplication Operation
		// Only with the four least significant bits
		int result = (accumulator & 0x0F) * (regContents & 0x0F);
		
		state.writeAccumulator(result);
	}

}
