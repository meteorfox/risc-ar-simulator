package edu.uprm.icom4215.risc.instructions;

import edu.uprm.icom4215.risc.Decoder;
import edu.uprm.icom4215.risc.ProcessorState;

public class AddCInstruction implements Instruction {

	public AddCInstruction() {
		
	}
	
	@Override
	public void execute(ProcessorState state) {
		int accumulator = state.readAccumulator();
		
		int instReg = state.getIR();
		int regIndex = Decoder.getRegAddress(instReg);
		int regContents = state.readRegister(regIndex);
		
		int carry = state.getCarry();
		
		// Add with Carry Operation
		System.out.println("ADDC A R[" + regIndex+"]");
		int result = accumulator + regContents + carry;
		
		state.writeAccumulator(result);
	}

}
