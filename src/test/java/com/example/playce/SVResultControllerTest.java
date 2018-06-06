import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.Assert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.example.playce.Result;
import com.example.playce.ResultController;

@RunWith(SpringRunner.class)
public class SVResultControllerTest {

	@Test
	public void testGetPlayceResult1() {
	   ResultController r = new ResultController();
	   String playceName = "Eureka! San Luis Obispo";
	   
	   Result expected = new Result("Eureka! San Luis Obispo", 2, 4.4, 
	       "1141 Chorro St San Luis Obispo CA 93401", 35.2791, -120.662, "restaurant");
	   
	   Assert.assertTrue(r.generatePlayceResult(playceName).isEqualTo(expected));
	}
	
	@Test
	public void testGetPlayceResult2() {
	   ResultController r = new ResultController();
	   String playceName = "Koberl At Blue";
   
	   Result expected = new Result("Koberl At Blue", 2, 4.4, 
	       "998 Monterey St San Luis Obispo CA 93401", 35.2818, -120.662, "restaurant");
	   
	   Assert.assertTrue(r.generatePlayceResult(playceName).isEqualTo(expected));
	}
}
