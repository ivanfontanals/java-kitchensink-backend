/*
 * This file was generated by the migration tool. Do not modify it manually.
 */

package com.mongodb.migration.kitchensink.infra.mongodb;

import static org.junit.jupiter.api.Assertions.*;

import com.mongodb.migration.kitchensink.domain.model.Member;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;

/** Unit tests for MongodbMemberRepository. */
@DataMongoTest
public class MongodbMemberRepositoryTest {

  @Autowired private MongoTemplate mongoTemplate;

  private MongodbMemberRepository repository;

  @BeforeEach
  public void setUp() {
    repository = new MongodbMemberRepository(mongoTemplate);
    mongoTemplate.dropCollection(Member.class);
  }

  @Test
  public void testSaveAndFindById() {
    Member member =
        Member.builder()
            .name("John Doe")
            .email("john.doe@example.com")
            .phoneNumber("1234567890")
            .build();

    Member savedMember = repository.save(member);
    Optional<Member> foundMember = repository.findById(savedMember.getId());

    assertTrue(foundMember.isPresent());
    assertEquals("John Doe", foundMember.get().getName());
  }

  @Test
  public void testFindByEmail() {
    Member member =
        Member.builder()
            .name("Jane Doe")
            .email("jane.doe@example.com")
            .phoneNumber("0987654321")
            .build();

    repository.save(member);
    Optional<Member> foundMember = repository.findByEmail("jane.doe@example.com");

    assertTrue(foundMember.isPresent());
    assertEquals("Jane Doe", foundMember.get().getName());
  }

  @Test
  public void testFindAllOrderedByName() {
    Member member1 =
        Member.builder().name("Alice").email("alice@example.com").phoneNumber("1111111111").build();

    Member member2 =
        Member.builder().name("Bob").email("bob@example.com").phoneNumber("2222222222").build();

    repository.save(member1);
    repository.save(member2);

    List<Member> members = repository.findAllOrderedByName();

    assertEquals(2, members.size());
    assertEquals("Alice", members.get(0).getName());
    assertEquals("Bob", members.get(1).getName());
  }

  @Test
  public void testDelete() {
    Member member =
        Member.builder()
            .name("Charlie")
            .email("charlie@example.com")
            .phoneNumber("3333333333")
            .build();

    Member savedMember = repository.save(member);
    repository.delete(savedMember.getId());

    Optional<Member> foundMember = repository.findById(savedMember.getId());
    assertFalse(foundMember.isPresent());
  }
}
