package edu.uprm.icom4215.risc.instructions;

import edu.uprm.icom4215.risc.Decoder;
import edu.uprm.icom4215.risc.MainMemory;
import edu.uprm.icom4215.risc.ProcessorState;

public class STAAddrInstruction implements Instruction {

	@Override
	public void execute(ProcessorState state) {
		int instReg = state.getIR();
		int memAddress = Decoder.getLeastSignificantByte(instReg);
		
		MainMemory mem = MainMemory.getInstance();
	
		int accumulator = state.readAccumulator();

		System.out.println("STA M["+Integer.toHexString(memAddress)+"]");
		mem.writeByte(memAddress, accumulator);
	}

}
