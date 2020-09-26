package automation;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.*;
import javax.imageio.ImageIO;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
public class Selenium_Image_retrival {
public static void main(String[] args)
{
	System.setProperty("webdriver.chrome.driver","C:\\bin\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.get("https://en.wikipedia.org/wiki/Flower");
	List<WebElement> kanth=driver.findElements(By.tagName("img"));
	System.out.println("No of images"+kanth.size());
	int k=1;
	for(int i=0;i<kanth.size();i++)
	{
		if(!kanth.get(i).getAttribute("src").contentEquals("")&&!(kanth.get(i).getAttribute("src")==null))
		{	
			System.out.println(kanth.get(i).getAttribute("src"));
			try {
			String s1=kanth.get(i).getAttribute("src");
			URL imageurl=new URL(s1);
			BufferedImage bf=ImageIO.read(imageurl);
			String li="flowerimages"+Integer.toString(k)+".png";
			ImageIO.write(bf,"png",new File(li));
			k++;
		}
			catch(Exception e)
			{
		}
	}
	
}
}
}