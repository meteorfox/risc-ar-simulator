package edu.uprm.icom4215.risc.instructions;

import edu.uprm.icom4215.risc.Decoder;
import edu.uprm.icom4215.risc.ProcessorState;

public class LDAInstruction implements Instruction {

	public LDAInstruction() {}
	
	@Override
	public void execute(ProcessorState state) {
		int instReg = state.getIR();
		int regIndex = Decoder.getRegAddress(instReg);
		int regContents = state.readRegister(regIndex);
		
		state.writeAccumulator(regContents);
		
		System.out.println("LDA R["+regIndex+"]");
	}


}
