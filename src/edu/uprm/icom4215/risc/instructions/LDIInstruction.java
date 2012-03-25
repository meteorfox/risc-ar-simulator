package edu.uprm.icom4215.risc.instructions;

import edu.uprm.icom4215.risc.Decoder;
import edu.uprm.icom4215.risc.ProcessorState;

public class LDIInstruction implements Instruction {

	@Override
	public void execute(ProcessorState state) {
		int instRegister = state.getIR();
		int immediateOperand = Decoder.getLeastSignificantByte(instRegister);
		
		state.writeAccumulator(immediateOperand);
		System.out.println("LDI "+immediateOperand);
	}

	

}
