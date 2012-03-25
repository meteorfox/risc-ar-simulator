package edu.uprm.icom4215.risc;

import java.util.HashMap;
import java.util.Map;

import edu.uprm.icom4215.risc.instructions.AddCInstruction;
import edu.uprm.icom4215.risc.instructions.AndInstruction;
import edu.uprm.icom4215.risc.instructions.BRAInstruction;
import edu.uprm.icom4215.risc.instructions.BRCInstruction;
import edu.uprm.icom4215.risc.instructions.BRNInstruction;
import edu.uprm.icom4215.risc.instructions.BROInstruction;
import edu.uprm.icom4215.risc.instructions.BRZInstruction;
import edu.uprm.icom4215.risc.instructions.DECInstruction;
import edu.uprm.icom4215.risc.instructions.Instruction;
import edu.uprm.icom4215.risc.instructions.LDAAddrInstruction;
import edu.uprm.icom4215.risc.instructions.LDAInstruction;
import edu.uprm.icom4215.risc.instructions.LDIInstruction;
import edu.uprm.icom4215.risc.instructions.MulInstruction;
import edu.uprm.icom4215.risc.instructions.NOPInstruction;
import edu.uprm.icom4215.risc.instructions.NegInstruction;
import edu.uprm.icom4215.risc.instructions.OrInstruction;
import edu.uprm.icom4215.risc.instructions.RLCInstruction;
import edu.uprm.icom4215.risc.instructions.RRCInstruction;
import edu.uprm.icom4215.risc.instructions.STAAddrInstruction;
import edu.uprm.icom4215.risc.instructions.STAInstruction;
import edu.uprm.icom4215.risc.instructions.StopInstruction;

public class Decoder {

	private static final int EIGHT_BITS = 8;
	private static final int ELEVEN_BITS = 11;
	
	// Constants
	private static final int OPCODE_DISCRIMINATOR = 63488;
	private static final int REGISTER_DISCRIMINATOR = 1792;
	private static final int LSB_DISCRIMINATOR = 255;
	private static final int MSB_DISCRIMINATOR = 0xFF00;
	
	// Attributes
	private Map<Integer,Instruction> map; 
	
	public Decoder() {
		map = new HashMap<Integer,Instruction>();
		addInstructions();
	}
	
	public Instruction decode(final int ir) {
		int op = ir & OPCODE_DISCRIMINATOR;
		op = op >>> ELEVEN_BITS;
		Instruction instruction = getInstruction(op);
		
		return instruction;
	}
	
	public static int getRegAddress(final int ir) {
		int regIndex = ir & REGISTER_DISCRIMINATOR;
		regIndex = regIndex >>> EIGHT_BITS;
		return regIndex;
	}
	
	public static int getLeastSignificantByte(final int ir) {
		int lsb = ir & LSB_DISCRIMINATOR;
		return lsb;
	}
	
	public static int getMostSignificantByte(final int ir) {
		int msb = ir & MSB_DISCRIMINATOR;
		int shiftByte = msb >>> 8;
		return shiftByte;
	}

	private void addInstructions() {
		map.put(0, new AndInstruction());
		map.put(1, new OrInstruction());
		map.put(2, new AddCInstruction());
		map.put(3, new MulInstruction());
		map.put(4, new NegInstruction());
		map.put(5, new RLCInstruction());
		map.put(6, new RRCInstruction());
		map.put(7, new DECInstruction());
		map.put(8, new LDAInstruction());
		map.put(9, new STAInstruction());
		map.put(10, new LDAAddrInstruction());
		map.put(11, new STAAddrInstruction());
		map.put(12, new LDIInstruction());
		map.put(16, new BRZInstruction());
		map.put(17, new BRCInstruction());
		map.put(18, new BRNInstruction());
		map.put(19, new BROInstruction());
		map.put(21, new BRAInstruction());
		map.put(24, new NOPInstruction());
		map.put(31, new StopInstruction());
	}

	private Instruction getInstruction(int op) {
		Instruction inst = map.get(op);
		
		if (inst == null)
			return new NOPInstruction();
		
		return inst;
	}

}
