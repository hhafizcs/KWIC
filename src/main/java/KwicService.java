import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

@SuppressWarnings("serial")
@WebServlet(
    name = "KwicService",
    urlPatterns = {"/submitLine"}
)
public class KwicService extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		Input input = new Input();
		
		JSONObject requestObj = input.setup(request.getReader());
		
		Line inputLine = new Line(requestObj.getString("line"));
		
		CircularShifter shifter = new CircularShifter();
		shifter.setup(inputLine);
		
		Alphabetizer alphabetizer = new Alphabetizer(requestObj.getJSONArray("sortedLines"));
		alphabetizer.setup(shifter.getShiftedLines());
		
		Output output = new Output();
		String outputString = output.setup(inputLine, shifter.getShiftedLines(), alphabetizer.getSortedLines());
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
	    response.getWriter().write(outputString);
	}
}