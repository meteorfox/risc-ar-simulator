package edu.uprm.icom4215.risc.instructions;

import edu.uprm.icom4215.risc.Decoder;
import edu.uprm.icom4215.risc.ProcessorState;

public class BRAInstruction implements Instruction {

	@Override
	public void execute(ProcessorState state) {	
		
		int instReg = state.getIR();
		int memAddress = Decoder.getLeastSignificantByte(instReg);
		System.out.println("BRA " + Integer.toHexString(memAddress).toUpperCase());
		state.setPC(memAddress);
	}

}
