import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.Assert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.example.playce.Result;
import com.example.playce.ResultController;

@RunWith(SpringRunner.class)
public class TVResultTest {

	@Test
	public void testGetPlayceResult1() {
	   Result r1 = new Result("Firestone Grill", 1, 4.5, 
	       "1001 Higuera St San Luis Obispo CA 93401 USA", 35.2811, -120.66, "restaurant");
	   
	   Result r2 = new Result("Chick-fil-A", 1, 5.0, 
	       "1 Grand Ave San Luis Obispo CA 93407", 35.3005, -120.658, "restaurant");
	   
	   Assert.assertTrue(r1.compare(r2) > 0);
	}
	
	@Test
	public void testGetPlayceResult2() {
	   Result r = new Result("Chick-fil-A", 1, 5.0, 
	       "1 Grand Ave San Luis Obispo CA 93407", 35.3005, -120.658, "restaurant");
	   
	   Assert.assertTrue(r.compare(r) == 0)
	}
}
