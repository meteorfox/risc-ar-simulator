package edu.uprm.icom4215.risc.instructions;

import edu.uprm.icom4215.risc.Decoder;
import edu.uprm.icom4215.risc.MainMemory;
import edu.uprm.icom4215.risc.ProcessorState;

public class AndInstruction implements Instruction {

	// Attributes
	private ProcessorState state;
	
	public AndInstruction() {
	}
	
	public AndInstruction(ProcessorState state) {
		this.state = state;
	}
	
	@Override
	public void execute(ProcessorState state) {
		this.state = state;
		
		int accumulator = state.readAccumulator();
		
		int instReg = state.getIR();
		int regIndex = Decoder.getRegAddress(instReg);
		int regContents = state.readRegister(regIndex);
		
		// And Operation
		System.out.println("AND A R[" + regIndex + "]");
		int result = accumulator & regContents;
		
		state.writeAccumulator(result);
		
	}






}
