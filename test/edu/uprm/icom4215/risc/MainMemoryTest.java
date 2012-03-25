package edu.uprm.icom4215.risc;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MainMemoryTest {

	private MainMemory memory;
	
	@Before
	public void setUp() {
		memory = MainMemory.getInstance();
		memory.resetMemory();
	}
	
	@Test
	public void testGetInstance() {
		for (int i = 0; i < 256; i++) {
			int value = memory.readByte(i);
			assertEquals(0, value);
		}
	}
	
	@Test(expected=RuntimeException.class)
	public void testWriteByte() {
		for (int i = 0; i < 256; i++) {
			memory.writeByte(i, i*2);
		}
		
		for (int i = 0; i < 256; i++) {
			int value = memory.readByte(i);
			assertEquals(i*2, value);
		}
		
		int value = memory.readByte(257);
		int valueAtZero = memory.readByte(1);
		assertEquals(valueAtZero, value);
		
		try {
			memory.writeByte(10, -1);
			fail();
		}
		catch(RuntimeException e) {
			// Expected
		}
		
		try {
			memory.writeByte(-12, 0);
			fail();
		}
		catch(RuntimeException e) {
			// Expected
		}
	}
	
	@Test
	public void testFetchInstruction() {
		
		memory.writeByte(0, 170);
		memory.writeByte(1, 170);
		
		int value = memory.fetchInstruction(0);
		assertEquals(43690, value);
	}
}
