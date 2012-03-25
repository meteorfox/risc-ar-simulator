package edu.uprm.icom4215.risc;

public class ProcessorState {
	
	// Constants
	private static final int NUM_OF_REGISTERS = 8;
	private static final int SR_SIZE = 4;
	private static final int ZERO_BIT = 0;
	private static final int CARRY_BIT = 1;
	private static final int NEGATIVE_BIT =	2;
	private static final int OVERFLOW_BIT = 3;
	
	private static final int PLACES_FOR_MSB = 7;
	private static final int MSB_DISCRIMINATOR = 128;
	
	// Attributes
	private int[] registers;
	private int[] SR;
	private int accumulator;
	private int PC;
	private int IR;
	private boolean halted;
	private boolean run;
	
	public ProcessorState() {
		registers = new int[NUM_OF_REGISTERS];
		SR = new int[SR_SIZE];
		setHalted(true);
		setRun(true);
		PC = 0;
		setIR(0);
		accumulator = 0;
	}
	
	public int readRegister(final int index) {
		validateRegisterIndex(index);
		return registers[index];
	}
	

	public void writeRegister(final int index, final int value) {
		validateRegisterIndex(index);
		validateByte(value);
		registers[index] = value;
	}
	
	public int getPC() {
		return PC;
	}
	
	
	public void setPC(final int value) {
		if(value < 0 || value > 255) {
			throw new IllegalValueException("Value can't be less than 0," +
					" or greater than 255");
		}
		this.PC = value;
	}	
	
	public void setIR(final int iR) {
		validateWord(iR);
		IR = iR;
	}

	public int getIR() {
		return IR;
	}

	public void incrementPC() {
		PC = (PC + 1) % 128;
	}
	
	public void decrementPC() {
		if (PC == 0) 
			PC = 128;
		
		PC = (PC - 1) % 128;
	}
	
	public void setHalted(boolean halted) {
		this.halted = halted;
	}

	public boolean isHalted() {
		return halted;
	}

	public void setRun(boolean run) {
		this.run = run;
	}

	public boolean isRun() {
		return run;
	}

	public int readAccumulator() {
		return accumulator;
	}
	
	public void writeAccumulator(final int value) {
		updateFlags(value);		
		accumulator = truncateToByte(value);
	}
	
	private int truncateToByte(int value) {
		int truncatedValue = value & 0xFF;
		return truncatedValue;
	}

	public int getZero() {
		return SR[ZERO_BIT];
	}
	
	public void setZero(final int bit) {
		validateBit(bit);
		SR[ZERO_BIT] = bit;
	}

	
	public int getCarry() {
		return SR[CARRY_BIT];
	}
	
	public void setCarry(int bit) {
		validateBit(bit);
		SR[CARRY_BIT] = bit;
	}
	
	public int getNegative() {
		return SR[NEGATIVE_BIT];
	}
	
	public void setNegative(final int bit) {
		validateBit(bit);
		SR[NEGATIVE_BIT] = bit;
	}
	
	public int getOverflow() {
		return SR[OVERFLOW_BIT];
	}
	
	public void setOverflow(final int bit) {
		validateBit(bit);
		SR[OVERFLOW_BIT] = bit;
	}
	
	private void updateFlags(final int value) {
		
		if (value == 0)
		{
			this.setZero(1);
		}
		else {
			this.setZero(0);
		}
		
		int accumulatorMSB = getMostSignificantBit(this.readAccumulator());
		int resultMSB = getMostSignificantBit(value);
		
		if (accumulatorMSB != resultMSB) {
			this.setOverflow(1);
		}
		else {
			this.setOverflow(0);
		}
		
		this.setNegative(resultMSB);
		
		if (value > 0xFF)
		{
			this.setCarry(1);
		}
		else {
			this.setCarry(0);
		}
	}
	
	public int[] getRegisters() {
		return registers;
	}
	
	private void validateBit(final int bit) {
		if (bit != 0 && bit != 1)
			throw new IllegalArgumentException("Only 0 or 1 is allowed.");
	}
	
	private void validateByte(final int value) {
		if (value > 255 || value < 0)
			throw new IllegalValueException("Value can't be greater than 255" +
					" or less than zero.");
	}
	
	private void validateWord(final int value) {
		if (value > 65535 || value < 0)
			throw new IllegalValueException("Value: " + value
					+ " in IR is not  0 <= x <= 65535");
	}

	private void validateRegisterIndex(final int index) {
		if (index >= NUM_OF_REGISTERS || index < 0)
			throw new IllegalArgumentException("Register index out of bounds.");
	}
	
	public int getMostSignificantBit(int value) {
		int andResult = value & MSB_DISCRIMINATOR;
		int shiftedResult = andResult >>> PLACES_FOR_MSB;
		return shiftedResult;
	}
}
