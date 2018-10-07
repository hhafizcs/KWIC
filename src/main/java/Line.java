import java.awt.Color;
import java.util.Random;

public class Line {
	public String val;
	public String color;
	
	public Line(String val) {
		this.val = val;
		
		Random rand = new Random();
		float r = rand.nextFloat();
		float g = rand.nextFloat();
		float b = rand.nextFloat();
		Color randomColor = new Color(r, g, b);
		
		this.color = colorToHex(randomColor);
	}
	
	public Line(String val, String color) {
		this.val = val;
		this.color = color;
	}
	
	private String colorToHex(Color color)
	{
	        String hex = Integer.toHexString(color.getRGB() & 0xffffff);
	        
	        if(hex.length() < 6) 
	        {
	            if(hex.length() == 5)
	                hex = "0" + hex;
	            
	            if(hex.length() == 4)
	                hex = "00" + hex;
	            
	            if(hex.length() == 3)
	                hex = "000" + hex;
	        }
	        
	        hex = "#" + hex;
	        
	        return hex;
	}
}