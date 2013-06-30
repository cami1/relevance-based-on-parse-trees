package opennlp.tools.jsmlearning;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;

public class ProfileReaderWriter {
	public static List<String[]> readProfiles(String filename) {
		CSVReader reader = null;
		List<String[]> profiles = null;
		try	{
			reader = new CSVReader(new FileReader(filename), ',');
			profiles = reader.readAll();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return profiles;
	}

	public static void writeReportArr( String[][] allLines, String reportName){
		List<String[]> rep = new ArrayList<String[]>();
		for(String[] line: allLines){
			rep.add(line);
		}
		writeReport( rep, reportName);
	}

	public static void writeReport( List<String[]> allLines, String reportName){
		CSVWriter writer = null;
		try {	
			writer = new CSVWriter(new PrintWriter(reportName));			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}		
		writer.writeAll(allLines);

		try {
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void writeReport( List<String[]> allLines, String reportName, char delimiter){
		CSVWriter writer = null;
		try {	
			writer = new CSVWriter(new PrintWriter(reportName), delimiter, delimiter, delimiter);			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}	

		writer.writeAll(allLines);

		try {
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void writeReportListStr(List<String> res, String string) {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args){
		List<String[]> allLines = new ArrayList<String[]>();
		allLines.add(new String[] {"aa " , "  bb", "ccc" });
		ProfileReaderWriter.writeReport( allLines, "reportName.txt", ' ');

	}


}