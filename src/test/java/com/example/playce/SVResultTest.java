import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.Assert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.example.playce.Result;
import com.example.playce.ResultController;

@RunWith(SpringRunner.class)
public class SVResultTest {

	@Test
	public void testCompareResults1() {
	   Result r1 = new Result("Eureka! San Luis Obispo", 2, 4.4, 
	       "1141 Chorro St San Luis Obispo CA 93401 USA", 35.2791, -120.662, "restaurant");
	   
	   Result r2 = new Result("Koberl At Blue", 2, 4.4, 
	       "998 Monterey St San Luis Obispo CA 93401 USA", 35.2818, -120.662, "restaurant");
	   
	   Assert.assertTrue(r1.compare(r2) < 0);
	}
	
	@Test
	public void testCompareResults2() {
	   Result r = new Result("Koberl At Blue", 2, 4.4, 
	       "998 Monterey St San Luis Obispo CA 93401 USA", 35.2818, -120.662, "restaurant");
	   
	   Assert.assertTrue(r.compare(r) == 0);
	}
}
