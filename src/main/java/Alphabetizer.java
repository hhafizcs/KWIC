import java.util.ArrayList;

import org.json.JSONArray;

public class Alphabetizer {
	private ArrayList<Line> sortedLines;
	
	public Alphabetizer(Input input) {
		JSONArray sortedLinesArray = input.getPrevSortedLinesArray();
		ArrayList<Line> sortedLines = new ArrayList<>();
		
		for(int i = 0; i < sortedLinesArray.length(); i++) {
			String line = sortedLinesArray.getJSONObject(i).getString("line");
			String color = sortedLinesArray.getJSONObject(i).getString("color");
			sortedLines.add(new Line(line, color));
		}
		
		this.sortedLines = sortedLines;
	}
	
	public ArrayList<Line> getSortedLines() {
		return sortedLines;
	}
	
	public void setup(CircularShifter shifter) {
		ArrayList<Line> csLines = shifter.getShiftedLines();
		
		for(int i = 0; i < csLines.size(); i++) {
			if(sortedLines.size() == 0) {
				sortedLines.add(csLines.get(i));
			} else {
				for(int j = 0; j <= sortedLines.size(); j++) {
					if(j == sortedLines.size()) {
						sortedLines.add(csLines.get(i));
						break;
					} else {
						if(csLines.get(i).val.compareToIgnoreCase(sortedLines.get(j).val) < 0) {
							sortedLines.add(j, csLines.get(i));
							break;
						}
					}
				}
			}
		}
	}
}