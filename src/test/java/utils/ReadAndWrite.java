package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;

import org.testng.annotations.Test;
@Test(alwaysRun =false)
public class ReadAndWrite {
	
	public String readData(String setFilePath) throws IOException {
		FileReader r=new FileReader(
				setFilePath);
	   BufferedReader br=new BufferedReader(r);
	   return br.readLine();
	
	}
	@Test
	public void writeData(String SetPAth) throws IOException {
		FileWriter w=new FileWriter(SetPAth);
		BufferedWriter bw=new BufferedWriter(w);
		bw.write(SetPAth);
		w.flush();
	}
}
