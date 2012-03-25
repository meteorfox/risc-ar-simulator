package edu.uprm.icom4215.risc;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import edu.uprm.icom4215.risc.instructions.Instruction;
import edu.uprm.icom4215.risc.instructions.OrInstruction;

public class DecoderTest {

	private Decoder decoder;
	
	@Before
	public void initialize() {
		decoder = new Decoder();
	}
	
	@Test
	public void testGetRegAddress() {
		int ir = 298;
		int regIndex = Decoder.getRegAddress(ir);
		
		assertEquals(1, regIndex);
	}
	
	@Test
	public void testGetLeastSignificatByte() {
		int ir = 298;
		int lsb = Decoder.getLeastSignificantByte(ir);
		
		assertEquals(42, lsb);
	}
	
	@Test
	public void testDecoder() {
		int ir = 2048;
		Instruction Or = decoder.decode(ir);
		
		assertEquals(OrInstruction.class, Or.getClass());
		
	}
}
