import com.vincent.julie.bean.VersionBean;
import com.vincent.julie.dao.VersionMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @author chenpy-1072
 * @desc TODO
 * @date 2018/3/23 9:50
 * @see
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = { "classpath*:spring/spring-*.xml" })
@WebAppConfiguration("src/main/resources")
public class VersionMapperTest {

	@Autowired
	private VersionMapper versionMapper;

	@Test
	public void testGetLatestVersion() {
		System.out.println("start....");
		VersionBean latestVersion = versionMapper.getLatestVersion();
		System.out.println(latestVersion);
	}
}
