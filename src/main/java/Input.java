import java.io.BufferedReader;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.json.JSONObject;

public class Input {
	public void setup(HttpServletRequest request, LineStorage lineStorage) {
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
		
		Line inputLine = new Line(requestObj.getString("line"));
		JSONArray prevSortedLinesArray = requestObj.getJSONArray("sortedLines");
		
		lineStorage.setup(inputLine, prevSortedLinesArray);
	}
}