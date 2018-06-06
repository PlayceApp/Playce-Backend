import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.Assert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.example.playce.Result;
import com.example.playce.ResultController;

@RunWith(SpringRunner.class)
public class KTResultTest {

	@Test
	public void testCompareResults1() {
	   Result r1 = new Result("San Diego Museum Of Arts", 0, 0.0, 
	       "San Luis Obispo CA 93401 USA", 35.2828, -120.66, "recreation");
	   
	   Result r2 = new Result("Sidecar", 0, 4.4, 
	       "1127 Broad St San Luis Obispo CA 93401 USA", 35.2784, -120.664, "restaurant");
	   
	   Assert.assertTrue(r1.compare(r2) < 0);
        }

	@Test
	public void testCompareResults2() {
	   Result r = new Result("Sidecar", 0, 4.4, 
	       "1127 Broad St San Luis Obispo CA 93401 USA", 35.2784, -120.664, "restaurant");
	   
	   Assert.assertTrue(r.compare(r) == 0);
        }
}
