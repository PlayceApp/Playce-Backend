import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.Assert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.example.playce.Result;

@RunWith(SpringRunner.class)
public class KMResultTest {

	@Test
	public void testCompareResults1() {
	   Result r1 = new Result("Raku Ramen", 2, 3.5,
                "1308 Montery St San Luis Obispo CA 93401", 35.2846, -120.657, "restaurant");
           Result r2 = new Result("Urbane Cafe", 1, 4.5, 
	       "952 Higuera St San Luis Obispo CA 93401", 35.2809, -120.662, "restaurant");
	   
	   Assert.assertTrue(r1.compare(r2) < 0);
	}
	
	@Test
	public void testCompareResult2() {
	   Result r = new Result("Raku Ramen", 2, 3.5, 
	       "1308 Monterey St San Luis Obispo CA 93401", 35.2846, -120.657, "restaurant");
	   
	   Assert.assertTrue(r.compare(r) == 0);
	}
}
