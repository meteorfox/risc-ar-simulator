package edu.uprm.icom4215.risc.instructions;

import edu.uprm.icom4215.risc.Decoder;
import edu.uprm.icom4215.risc.ProcessorState;

public class STAInstruction implements Instruction {

	@Override
	public void execute(ProcessorState state) {
		int accumulator = state.readAccumulator();
		int instReg = state.getIR();
		int regIndex = Decoder.getRegAddress(instReg);
		
		state.writeRegister(regIndex, accumulator);
		System.out.println("STA R["+regIndex+"]");
	}

}
