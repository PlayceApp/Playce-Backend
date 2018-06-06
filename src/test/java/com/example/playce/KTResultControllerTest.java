import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.Assert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.example.playce.Result;
import com.example.playce.ResultController;

@RunWith(SpringRunner.class)
public class KTResultControllerTest {

	@Test
	public void testGetPlayceResult1() {
	   ResultController r = new ResultController();
	   String playceName = "San Diego Museum Of Arts";
	   
	   Result expected = new Result("San Diego Museum Of Arts", 0, 0.0, 
	       "San Luis Obispo CA 93401 USA", 35.2828, -120.66, "recreation");
	   
	   Assert.assertTrue(r.generatePlayceResult(playceName).isEqualTo(expected));
        }

	@Test
	public void testGetPlayceResult2() {
	   ResultController r = new ResultController();
	   String playceName = "Sidecar";
	   
	   Result expected = new Result("Sidecar", 0, 4.4, 
	       "1127 Broad St San Luis Obispo CA 93401 USA", 35.2784, -120.664, "restaurant");
	   
	   Assert.assertTrue(r.generatePlayceResult(playceName).isEqualTo(expected));
        }
}
