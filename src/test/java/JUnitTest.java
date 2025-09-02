import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class JUnitTest {

	@Test
	public void junitTest1() {
		String name1 = "홍길동";
		String name2 = "홍길동";
		String name3 = "홍길은";

		// check not null
		assertThat(name1).isNotNull();
		assertThat(name2).isNotNull();
		assertThat(name3).isNotNull();

		// check name1 equals name2
		assertThat(name1).isEqualTo(name2);

		// check name1 is not equal name3
		assertThat(name1).isNotEqualTo(name3);
	}
}
