import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet(
    name = "KwicService",
    urlPatterns = {"/submitLine"}
)
public class KwicService extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Input input = new Input();
		input.setup(request);
		
		CircularShifter shifter = new CircularShifter();
		shifter.setup(input);
		
		Alphabetizer alphabetizer = new Alphabetizer(input);
		alphabetizer.setup(shifter);
		
		Output output = new Output();
		String outputString = output.setup(input, shifter, alphabetizer);
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
	    response.getWriter().write(outputString);
	}
}