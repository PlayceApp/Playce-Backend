import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.Assert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.example.playce.Result;
import com.example.playce.ResultController;

@RunWith(SpringRunner.class)
public class ZAResultControllerTest {

	@Test
	public void testGetPlayceResult1() {
	   ResultController r = new ResultController();
	   String playceName = "Big Sky Cafe";
	   
	   Result expected = new Result("Big Sky Cafe", 2, 4.4, 
	       "1121 Broad St San Luis Obispo CA 93401", 35.2784, -120.664, "restaurant");
	   
	   Assert.assertTrue(r.generatePlayceResult(playceName).isEqualTo(expected));
	}
	
	@Test
	public void testGetPlayceResult2() {
	   ResultController r = new ResultController();
	   String playceName = "Woodstock's Pizza SLO";
   
	   Result expected = new Result("Woodsotck's Pizza SLO", 2, 4.3, 
	       "1000 Higuera St San Luis Obispo CA 93401 USA", 35.2814, -120.661, "restaurant");
	   
	   Assert.assertTrue(r.generatePlayceResult(playceName).isEqualTo(expected));
	}
}
