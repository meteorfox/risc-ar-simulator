package edu.uprm.icom4215.risc.instructions;

import edu.uprm.icom4215.risc.ProcessorState;

public interface Instruction {

	void execute(ProcessorState state);
	
}
