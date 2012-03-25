package edu.uprm.icom4215.risc;

public class MainMemory {
	
	private static final int SIXTEEN_SQUARED = 256;
	private static final int INSTRUCTION_SPACE = 128;

	// Thread-safe Singleton class
	private volatile static MainMemory INSTANCE;
	
	// Initial size of the memory
	private final static int MEMORY_SIZE = 256;
	private static int[] mem;

	
	private MainMemory() {
		// Singleton
		initializeMemory();
	}
	
	public static MainMemory getInstance() {
		if (INSTANCE == null) {
			synchronized(MainMemory.class) {
				if (INSTANCE == null) {
					INSTANCE = new MainMemory();
				}
			}
		}
		return INSTANCE;
	}
	
	public int readByte(final int index) {
		int validIndex = validateIndex(index);
		return MainMemory.mem[validIndex];
	}
	
	public synchronized void writeByte(final int index, final int value) {
		if (value > 255 || value < 0)
			throw new IllegalValueException("Value can't be greater than 255" +
					" or less than zero.");
		
		int validIndex = validateIndex(index);
		MainMemory.mem[validIndex] = value;
	}
	
	public int fetchInstruction(final int index) {
		int firstByte = readByte((index % INSTRUCTION_SPACE))
			* SIXTEEN_SQUARED;
		
		int secondByte = readByte((index + 1) % INSTRUCTION_SPACE);
		
		return (firstByte + secondByte);
	}
	
	public synchronized void resetMemory() {
		for (int i = 0; i < mem.length; i++) {
			mem[i] = 0;
		}
	}
	
	public int getMemorySize() {
		return MEMORY_SIZE;
	}

	private void initializeMemory() {
		MainMemory.mem = new int[MEMORY_SIZE];
	}
	
	private int validateIndex(int index) {
		if (index < 0) {
			throw new IllegalIndexException("Index can't be negative.");
		}
		return index % SIXTEEN_SQUARED;
	}
	
}
