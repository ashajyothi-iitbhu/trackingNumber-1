package trackingNumber;

import java.io.*;
import java.util.*;

public class trackingNumberSystem {

	public static void main(String[] args) {
		Scanner inputReader = new Scanner(System.in);
		String currentLine = "";
		List<String> reportList = new ArrayList<String>();
		currentLine = inputReader.nextLine();
		numberReport reportGenerator = new numberReport(currentLine);
		while((currentLine = inputReader.nextLine()) != null) {
			if (currentLine.equals("END")) {
				reportList.addAll(reportGenerator.returnReport());
				printReport(reportList);
			} else if (currentLine.equals("0")) {
				reportList.addAll(reportGenerator.returnReport());
				currentLine = inputReader.nextLine();
				reportGenerator = new numberReport(currentLine);
			} else {
				reportGenerator.generateTuple(currentLine);
			}
		}
	}
	
	public static void printReport(List<String> report_list) {
		for(String tuple : report_list) {
			System.out.println(tuple);
		}
	}
}
