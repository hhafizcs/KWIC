import java.io.BufferedReader;

import org.json.JSONObject;

public class Input {
	public JSONObject setup(BufferedReader reader) {
		JSONObject requestObj = null;
		StringBuffer stringBuffer = new StringBuffer();
		String bufferline = null;
		
		try {
		    while ((bufferline = reader.readLine()) != null)
		    	stringBuffer.append(bufferline);
		}
		catch (Exception e) {}

		try {
		    requestObj = new JSONObject(stringBuffer.toString());
		}
		catch (Exception e) {}
		
		return requestObj;
	}
}