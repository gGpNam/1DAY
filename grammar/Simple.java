package grammar.basic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Simple extends Parent implements IParent {
	private final static String FIELD_ID = "field_id";
	public Simple() {
	}
	
	void binaryLiteral() {
		// An 8-bit 'byte' value:
		byte aByte = (byte)0b00100001;

		// A 16-bit 'short' value:
		short aShort = (short)0b1010000101000101;

		// Some 32-bit 'int' values:
		int anInt1 = 0b10100001010001011010000101000101;
		int anInt2 = 0b101;
		int anInt3 = 0B101; // The B can be upper or lower case.

		// A 64-bit 'long' value. Note the "L" suffix:
		long aLong = 0b1010000101000101101000010100010110100001010001011010000101000101L;
		
		int i = (0b101 + 0b100);
		String len = "abc".substring(0b001,0b010);
	}
	
	void unerscoreInNumber() {
		long creditCardNumber = 1234_5678_9012_3456L;
		long socialSecurityNumber = 999_99_9999L;
		float pi = 	3.14_15F;
		long hexBytes = 0xFF_EC_DE_5E;
		long hexWords = 0xCAFE_BABE;
		long maxLong = 0x7fff_ffff_ffff_ffffL;
		byte nybbles = 0b0010_0101;
		long bytes = 0b11010010_01101001_10010100_10010010;
		
		//float pi2 = 3._1415F;      // Invalid; cannot put underscores adjacent to a decimal point
		//long socialSecurityNumber1  = 999_99_9999_L;         // Invalid; cannot put underscores prior to an L suffix

		//int x1 = _52;              // This is an identifier, not a numeric literal
		int x2 = 5_2;              // OK (decimal literal)
		//int x3 = 52_;              // Invalid; cannot put underscores at the end of a literal
		int x4 = 5_______2;   // OK (decimal literal)

		//int x5 = 0_x52;            // Invalid; cannot put underscores in the 0x radix prefix
		//int x6 = 0x_52;            // Invalid; cannot put underscores at the beginning of a number
		int x7 = 0x5_2;            // OK (hexadecimal literal)
		//int x8 = 0x52_;            // Invalid; cannot put underscores at the end of a number

		int x9 = 0_52;             // OK (octal literal)
		int x10 = 05_2;            // OK (octal literal)
		//int x11 = 052_;            // Invalid; cannot put underscores at the end of a number
		
		double x11 = 19090.;
		
		float f = 0.f;
	}
	
	void stringSwitch(String id) {
		switch (id) {
		case "name1" :
			// ...
			break;
		case "name2" :
			// ...
			break;
		}
	}
	
	<String>List<String> simpleGeneric(List<String> a) {
		Map<String, List<String>> map = new HashMap<>();
		
		ArrayList<String> ar = new <Integer>ArrayList<String>();
		ar.add((String)"A");
		
		return null;
	}
	
	void tryWithResource(String path) {
		// 1
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
		    br.readLine();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//2
		try (java.util.zip.ZipFile zf = new java.util.zip.ZipFile(path);
			 java.io.BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {

				for (Enumeration entries = zf.entries(); entries.hasMoreElements();) {
					String newLine = System.getProperty("line.separator");
			        String zipEntryName = ((java.util.zip.ZipEntry)entries.nextElement()).getName() + newLine;
			        writer.write(zipEntryName, 0, zipEntryName.length());
				}
		} catch (final IOException e) {
			e.printStackTrace();
		}
	}
	
	void multyCatch() throws Throwable {
		try (FileWriter fw = new FileWriter("")) {
			
			fw.write("Q");
		} catch (IOException | Error ex) {
			throw ex;
		}
	}
}
