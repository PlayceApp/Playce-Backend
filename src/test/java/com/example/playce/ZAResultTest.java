import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.Assert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.example.playce.Result;
import com.example.playce.ResultController;

@RunWith(SpringRunner.class)
public class ZATest {

	@Test
	public void testGetPlayceResult1() {
	   Result r1 = new Result("Big Sky Cafe", 2, 4.4, 
	       "1121 Broad St San Luis Obispo CA 93401 USA", 35.2784, -120.664, "restaurant");
	   
	   Result r2 = new Result("Woodstock's Pizza SLO", 2, 4.3, 
	       "1000 Higuera St San Luis Obispo CA 93401 USA", 35.2814, -120.661, "restaurant");
	   
	   Assert.assertTrue(r1.compare(r2) < 0);
	}
	
	@Test
	public void testGetPlayceResult2() {
	   Result r = new Result("Woodstock's Pizza SLO", 2, 4.3, 
	       "1000 Higuera St San Luis Obispo CA 93401 USA", 35.2814, -120.661, "restaurant");
	   
	   Assert.assertTrue(r.compare(r) == 0);
	}
}
