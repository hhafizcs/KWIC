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
		LineStorage lineStorage = new LineStorage();
		
		input.setup(request, lineStorage);
		
		CircularShifter shifter = new CircularShifter();
		shifter.setup(lineStorage);
		
		Alphabetizer alphabetizer = new Alphabetizer(lineStorage);
		alphabetizer.setup(shifter);
		
		Output output = new Output();
		String outputString = output.setup(lineStorage, shifter, alphabetizer);
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
	    response.getWriter().write(outputString);
	}
}