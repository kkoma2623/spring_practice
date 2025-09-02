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

	@Test
	public void junitTest2() {
		int number1 = 15;
		int number2 = 0;
		int number3 = -5;

		// check number1 is positive
		assertThat(number1).isPositive();

		// check number2 is zero
		assertThat(number2).isZero();

		// check number3 is negative
		assertThat(number3).isNegative();

		// check number1 is greater than number2
		assertThat(number1).isGreaterThan(number2);

		// check number3 is less than number2
		assertThat(number3).isLessThan(number2);
	}
}
