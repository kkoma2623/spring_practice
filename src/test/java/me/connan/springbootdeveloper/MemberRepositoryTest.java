package me.connan.springbootdeveloper;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

@DataJpaTest
class MemberRepositoryTest {

	@Autowired
	MemberRepository memberRepository;

	@Sql("/insert-members.sql")
	@Test
	void getAllMembers() {
		// when
		List<Member> members = memberRepository.findAll();

		// then
		assertThat(members.size()).isEqualTo(3);
	}

	@Sql("/insert-members.sql")
	@Test
	void getMemberById() {
		// when
		Member member = memberRepository.findById(2L)
			.orElse(null);

		// then
		assert member != null;
		assertThat(member.getName()).isEqualTo("B");
	}

	@Sql("/insert-members.sql")
	@Test
	void getMemberByName() {
		// when
		Member member = memberRepository.findByName("B")
			.orElse(null);

		// then
		assert member != null;
		assertThat(member.getId()).isEqualTo(2L);
	}

	@Test
	void saveMember() {
		// given
		Member member = new Member(1L, "A");

		// when
		memberRepository.save(member);
		Member foundMember = memberRepository.findById(1L)
			.orElse(null);

		// then
		assert (foundMember != null);
		assertThat(foundMember.getId()).isEqualTo(member.getId());
	}

	@Test
	void saveMembers() {
		// given
		List<Member> members = List.of(new Member(2L, "B"), new Member(3L, "C"));

		// when
		memberRepository.saveAll(members);

		// then
		assertThat(memberRepository.count()).isEqualTo(2);
	}

	@Sql("/insert-members.sql")
	@Test
	void deleteMemberById() {
		// when
		memberRepository.deleteById(2L);
		Member deletedMember = memberRepository.findById(2L).orElse(null);

		// then
		assertThat(deletedMember).isNull();
	}

	@Sql("/insert-members.sql")
	@Test
	void deleteAllMembers() {
		// when
		memberRepository.deleteAll();

		// then
		assertThat(memberRepository.count()).isEqualTo(0);
	}
}
