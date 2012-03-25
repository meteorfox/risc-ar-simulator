package edu.uprm.icom4215.risc;

import edu.uprm.icom4215.risc.instructions.Instruction;

public class Processor {

	private ProcessorState state;
	private MainMemory memory;
	private Decoder decoder;
	
	public Processor() {
		this.state = new ProcessorState();
		this.decoder = new Decoder();
		memory = MainMemory.getInstance();
		
	}
	
	public Processor(ProcessorState aState) {
		this.state = aState;
		this.decoder = new Decoder();
		memory = MainMemory.getInstance();
	}

	public void next() {
		int ir = fetchInstruction();
		this.state.setIR(ir);
		
		Instruction inst = decoder.decode(ir);
		inst.execute(state);
	}
	
	public ProcessorState getState() {
		return state;
	}
	
	public boolean isRun() {
		return state.isRun();
	}
	
	public void reset() {
		state.setPC(0);
		state.setIR(0);
		state.writeAccumulator(0);
		state.setCarry(0);
		state.setNegative(0);
		state.setOverflow(0);
		state.setZero(0);
		state.setRun(true);
		state.setHalted(false);
		
		for (int i = 0; i < 8; i++) {
			state.writeRegister(i, 0);
		}
	}

	private int fetchInstruction() {
		int index = state.getPC();
		state.incrementPC();
		state.incrementPC();
		return memory.fetchInstruction(index);
	}
}


