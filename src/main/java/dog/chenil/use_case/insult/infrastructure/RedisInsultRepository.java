package dog.chenil.use_case.insult.infrastructure;

import java.util.List;

import dog.chenil.use_case.insult.domain.InsultRepository;
import io.quarkus.redis.client.RedisClient;

public final class RedisInsultRepository implements InsultRepository {
  private final RedisClient redisClient;

  public RedisInsultRepository(RedisClient redisClient) {
    this.redisClient = redisClient;
  }

  @Override
  public String findInsultRandomly() {
    return redisClient.get(redisClient.randomkey().toString()).toString();
  }

  @Override
  public void add(String insult) {
    redisClient.set(List.of(insult));
  }
}
