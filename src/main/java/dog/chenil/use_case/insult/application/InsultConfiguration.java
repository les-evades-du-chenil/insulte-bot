package dog.chenil.use_case.insult.application;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;

import dog.chenil.exposition.discord.InsultListnener;
import dog.chenil.exposition.web.InsultController;
import dog.chenil.use_case.insult.domain.InsultRepository;
import dog.chenil.use_case.insult.exposition.InsultCommandHandler;
import dog.chenil.use_case.insult.exposition.InsultQueryHandler;
import dog.chenil.use_case.insult.exposition.InsultUseCase;
import dog.chenil.use_case.insult.infrastructure.RedisInsultRepository;
import io.quarkus.redis.client.RedisClient;

@Dependent
public class InsultConfiguration {
  @Produces
  public InsultUseCase insultUseCase() {
    return new InsultCommandHandler(insultRepository());
  }

  @Produces
  public InsultRepository insultRepository() {
    return new RedisInsultRepository(redisClient());
  }

  @Produces
  public RedisClient redisClient() {
    return RedisClient.createClient();
  }

  @Produces
  public InsultQueryHandler insultQueryHandler() {
    return new InsultQueryHandler(insultRepository());
  }

  @Produces
  public InsultListnener insultListnener() {
    return new InsultListnener(insultQueryHandler(), userMapper());
  }

  @Produces
  private UserMapper userMapper() {
    return new UserMapper();
  }

  @Produces
  public InsultController insultController() {
    return new InsultController(insultUseCase());
  }
}
