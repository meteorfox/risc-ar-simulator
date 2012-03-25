package edu.uprm.icom4215.risc.instructions;


import edu.uprm.icom4215.risc.Decoder;
import edu.uprm.icom4215.risc.MainMemory;
import edu.uprm.icom4215.risc.ProcessorState;

public class LDAAddrInstruction implements Instruction {

	@Override
	public void execute(ProcessorState state) {
		int instReg = state.getIR();
		int memAddress = Decoder.getLeastSignificantByte(instReg);
		
		System.out.println("LDA M["+Integer.toHexString(memAddress).toUpperCase()+"]");
		MainMemory mem = MainMemory.getInstance();
		state.writeAccumulator(mem.readByte(memAddress));
	}

}
