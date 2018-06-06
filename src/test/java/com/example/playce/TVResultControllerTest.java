import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.Assert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.example.playce.Result;
import com.example.playce.ResultController;

@RunWith(SpringRunner.class)
public class TVResultControllerTest {

	@Test
	public void testGetPlayceResult1() {
	   ResultController r = new ResultController();
	   String playceName = "Firestone Grill";
	   
	   Result expected = new Result("Firestone Grill", 1, 4.5, 
	       "1001 Higuera St San Luis Obispo CA 93401 USA", 35.2811, -120.66, "restaurant");
	   
	   Assert.assertTrue(r.generatePlayceResult(playceName).isEqualTo(expected));
	}
	
	@Test
	public void testGetPlayceResult2() {
	   ResultController r = new ResultController();
	   String playceName = "Chick-fil-A";
   
	   Result expected = new Result("Chick-fil-A", 1, 5.0, 
	       "1 Grand Ave St San Luis Obispo CA 93407 USA", 35.3005, -120.658, "restaurant");
	   
	   Assert.assertTrue(r.generatePlayceResult(playceName).isEqualTo(expected));
	}
}
