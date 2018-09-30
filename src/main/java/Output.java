import java.util.ArrayList;

public class Output {
	public String setup(Line inputLine, ArrayList<Line> shiftedLines, ArrayList<Line> sortedLines) {
		String inputLineString = "{ \"line\": \"" + inputLine.val + "\", \"color\": \"" + inputLine.color + "\" }";
		
		String shiftedLinesString = "";
		for(int i = 0; i < shiftedLines.size(); i++) {
			shiftedLinesString += "{ \"line\": \"" + shiftedLines.get(i).val + "\", \"color\": \"" + shiftedLines.get(i).color + "\" }";
			
			if(i < shiftedLines.size() - 1) {
				shiftedLinesString += ",";
			}
		}
		shiftedLinesString = "[" + shiftedLinesString + "]";
		
		String sortedLinesString = "";
		for(int i = 0; i < sortedLines.size(); i++) {
			sortedLinesString += "{ \"line\": \"" + sortedLines.get(i).val + "\", \"color\": \"" + sortedLines.get(i).color + "\" }";
			
			if(i < sortedLines.size() - 1) {
				sortedLinesString += ",";
			}
		}
		sortedLinesString = "[" + sortedLinesString + "]";
		
		return "{ \"inputLine\": " + inputLineString + ", \"shiftedLines\": " + shiftedLinesString + ", \"sortedLines\": " + sortedLinesString + " }";
	}
}