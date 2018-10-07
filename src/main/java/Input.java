import java.io.BufferedReader;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.json.JSONObject;

public class Input {
	private Line inputLine;
	private JSONArray prevSortedLinesArray;
	
	public Line getInputLine() {
		return inputLine;
	}
	
	public JSONArray getPrevSortedLinesArray() {
		return prevSortedLinesArray;
	}
	
	public void setup(HttpServletRequest request) {
		JSONObject requestObj = null;
		StringBuffer stringBuffer = new StringBuffer();
		
		try {
			BufferedReader reader = request.getReader();
			String bufferline = null;
			
		    while ((bufferline = reader.readLine()) != null)
		    	stringBuffer.append(bufferline);
		}
		catch (Exception e) {}

		try {
		    requestObj = new JSONObject(stringBuffer.toString());
		}
		catch (Exception e) {}
		
		inputLine = new Line(requestObj.getString("line"));
		prevSortedLinesArray = requestObj.getJSONArray("sortedLines");
	}
}