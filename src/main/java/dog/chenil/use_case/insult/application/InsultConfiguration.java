package dog.chenil.use_case.insult.application;

import javax.enterprise.context.ApplicationScoped;

import dog.chenil.exposition.discord.InsultListnener;
import dog.chenil.exposition.web.InsultController;
import dog.chenil.use_case.insult.domain.InsultRepository;
import dog.chenil.use_case.insult.exposition.InsultCommandHandler;
import dog.chenil.use_case.insult.exposition.InsultQueryHandler;
import dog.chenil.use_case.insult.exposition.InsultUseCase;
import dog.chenil.use_case.insult.infrastructure.RedisInsultRepository;
import io.quarkus.redis.client.RedisClient;

@ApplicationScoped
public class InsultConfiguration {
  @ApplicationScoped
  public InsultUseCase insultUseCase() {
    return new InsultCommandHandler(insultRepository());
  }

  @ApplicationScoped
  public InsultRepository insultRepository() {
    return new RedisInsultRepository(redisClient());
  }

  @ApplicationScoped
  public RedisClient redisClient() {
    return RedisClient.createClient();
  }

  @ApplicationScoped
  public InsultQueryHandler insultQueryHandler() {
    return new InsultQueryHandler(insultRepository());
  }

  @ApplicationScoped
  public InsultListnener insultListnener() {
    return new InsultListnener(insultQueryHandler(), userMapper());
  }

  @ApplicationScoped
  private UserMapper userMapper() {
    return new UserMapper();
  }

  @ApplicationScoped
  public InsultController insultController() {
    return new InsultController(insultUseCase());
  }
}
