/*
 * This file was generated by the migration tool. Do not modify it manually.
 */

package com.mongodb.migration.kitchensink.infra.mongodb;

import com.mongodb.migration.kitchensink.domain.model.Member;
import com.mongodb.migration.kitchensink.domain.ports.outgoing.MemberRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

/** MongoDB implementation of the MemberRepository. */
@Repository
public class MongodbMemberRepository implements MemberRepository {

  private final MongoTemplate mongoTemplate;

  public MongodbMemberRepository(MongoTemplate mongoTemplate) {
    this.mongoTemplate = mongoTemplate;
  }

  @Override
  public Member save(Member member) {
    return mongoTemplate.save(member);
  }

  @Override
  public Optional<Member> findById(String id) {
    return Optional.ofNullable(mongoTemplate.findById(id, Member.class));
  }

  @Override
  public Optional<Member> findByEmail(String email) {
    Query query = new Query();
    query.addCriteria(Criteria.where("email").is(email));
    return Optional.ofNullable(mongoTemplate.findOne(query, Member.class));
  }

  @Override
  public List<Member> findAllOrderedByName() {
    Query query = new Query();
    query.with(Sort.by(Sort.Direction.ASC, "name"));
    return mongoTemplate.find(query, Member.class);
  }

  @Override
  public void delete(String id) {
    mongoTemplate.remove(new Query(Criteria.where("id").is(id)), Member.class);
  }
}
