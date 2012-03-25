package edu.uprm.icom4215.risc.instructions;

import edu.uprm.icom4215.risc.Decoder;
import edu.uprm.icom4215.risc.ProcessorState;

public class OrInstruction implements Instruction {

	public OrInstruction() {
		
	}
	

	@Override
	public void execute(ProcessorState state) {
		int accumulator = state.readAccumulator();
		
		int instReg = state.getIR();
		int regIndex = Decoder.getRegAddress(instReg);
		int regContents = state.readRegister(regIndex);
		
		// Or Operation
		int result = accumulator | regContents;
		
		state.writeAccumulator(result);
		System.out.println("OR A R["+regIndex+"]");
	}

}
