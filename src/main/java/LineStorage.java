import org.json.JSONArray;

public class LineStorage {
	private Line inputLine;
	private JSONArray prevSortedLinesArray;
	
	public Line getInputLine() {
		return inputLine;
	}
	
	public JSONArray getPrevSortedLinesArray() {
		return prevSortedLinesArray;
	}
	
	public void setup(Line inputLine, JSONArray prevSortedLinesArray) {
		this.inputLine = inputLine;
		this.prevSortedLinesArray = prevSortedLinesArray;
	}
}