package edu.uprm.icom4215.risc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileLoader {
	
	public int[] getInstructions(File file) 
		throws FileNotFoundException, IllegalInstructionFormatException {
		
		Scanner in = new Scanner(new FileInputStream(file));
		int[] instructions = parseFile(in);
		return instructions;
	}

	private int[] parseFile(Scanner in) throws IllegalInstructionFormatException {
		ArrayList<Integer> instructions = new ArrayList<Integer>();
		
		try {
			while(in.hasNextLine()) {
				String hexInst = in.nextLine();
				int intInst = Integer.parseInt(hexInst, 16);
				int firstByte = Decoder.getMostSignificantByte(intInst);
				int secondByte = Decoder.getLeastSignificantByte(intInst);
				
				instructions.add(firstByte);
				instructions.add(secondByte);
			}
		} catch (NumberFormatException e) {
			throw new IllegalInstructionFormatException("Please use a valid file.");
		}
		finally {
			in.close();
		}
		
		int[] primitiveArray = new int[instructions.size()];
		int i = 0;
		
		for (Integer inst : instructions) {
			primitiveArray[i] = inst;
			i++;
		}
		
		return primitiveArray;
	}
	
}
