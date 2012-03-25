package edu.uprm.icom4215.risc;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ProcessorStateTest {

	ProcessorState state;
	
	@Before
	public void initialize() {
		state = new ProcessorState();
	}
	
	@Test
	public void testReadRegister() {
		for (int i = 0; i < 8; i++) {
			int value = state.readRegister(i);
			assertEquals(0, value);
		}
	}

	@Test
	public void testWriteRegister() {
		for (int i = 0; i < 8; i++) {
			int value = state.readRegister(i);
			assertEquals(0, value);
		}
		
		for (int i = 0; i < 8; i++) {
			state.writeRegister(i, i*2);
		}
		
		for (int i = 0; i < 8; i++) {
			int value = state.readRegister(i);
			assertEquals(i*2, value);
		}
		
		try {
			state.writeRegister(0, 500);
		}
		catch(RuntimeException ex) {
			//expected
		}
		
		try {
			state.writeRegister(-10, 0);
		}
		catch(RuntimeException ex) {
			//expected
		}
		
		try {
			state.writeRegister(10, 0);
		}
		catch(RuntimeException ex) {
			//expected
		}
		
	}

	@Test
	public void testSetPC() {
		assertEquals(0, state.getPC());
		
		state.incrementPC();
		assertEquals(1, state.getPC());
		
		state.decrementPC();
		assertEquals(0, state.getPC());
		
		state.decrementPC();
		assertEquals(255, state.getPC());
		
		state.incrementPC();
		assertEquals(0, state.getPC());
		
		try {
			state.setPC(-100);
			fail();
		}
		catch (RuntimeException ex) {
			// Expected
		}
		
		try {
			state.setPC(500);
			fail();
		}
		catch (RuntimeException ex) {
			// Expected
		}
	}

	@Test
	public void testSetIR() {
		assertEquals(0, state.getPC());
		
		state.setIR(100);
		assertEquals(100, state.getIR());
		
		try {
			state.setIR(100000);
			fail();
		}
		catch (RuntimeException ex) {
			// Expected
		}
		
		try {
			state.setIR(-100000);
			fail();
		}
		catch (RuntimeException ex) {
			// Expected
		}
	}

	@Test
	public void testWriteAccumulator() {
		assertEquals(0, state.readAccumulator());
		
		state.writeAccumulator(10);
		assertEquals(10, state.readAccumulator());
		
		try {
			state.writeAccumulator(-1);
			fail();
		}
		catch (RuntimeException ex) {
			// Expected
		}
		
		try {
			state.writeAccumulator(300);
			fail();
		}
		catch (RuntimeException ex) {
			// Expected
		}
	}

	@Test
	public void testSetZero() {
		assertEquals(0, state.getZero());
		
		state.setZero(1);
		assertEquals(1, state.getZero());
		
		state.setZero(0);
		assertEquals(0, state.getZero());
		
		try {
			state.setZero(300);
			fail();
		}
		catch (RuntimeException ex) {
			// Expected
		}
	}

	@Test
	public void testSetCarry() {
	    assertEquals(0, state.getCarry());
		
		state.setCarry(1);
		assertEquals(1, state.getCarry());
		
		state.setCarry(0);
		assertEquals(0, state.getCarry());
		
		try {
			state.setCarry(300);
			fail();
		}
		catch (RuntimeException ex) {
			// Expected
		}
	}

	@Test
	public void testSetNegative() {
		assertEquals(0, state.getNegative());
		
		state.setNegative(1);
		assertEquals(1, state.getNegative());
		
		state.setNegative(0);
		assertEquals(0, state.getNegative());
		
		try {
			state.setNegative(300);
			fail();
		}
		catch (RuntimeException ex) {
			// Expected
		}
	}

	@Test
	public void testSetOverflow() {
		assertEquals(0, state.getOverflow());
		
		state.setOverflow(1);
		assertEquals(1, state.getOverflow());
		
		state.setOverflow(0);
		assertEquals(0, state.getOverflow());
		
		try {
			state.setOverflow(300);
			fail();
		}
		catch (RuntimeException ex) {
			// Expected
		}
	}

}
