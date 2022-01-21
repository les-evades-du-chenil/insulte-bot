package dog.chenil.use_case.insulte.exposition;

import java.time.ZonedDateTime;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import dog.chenil.use_case.insulte.domain.InsultRepository;
import dog.chenil.use_case.insulte.domain.User;
import dog.chenil.use_case.insulte.mock.InMemoryInsulteRepository;

class InsulteQueryTest {
  private final User swann;
  private final User gengu;
  private final InsultQueryHandler queryHandler;
  private final InsultRepository insultRepository;

  InsulteQueryTest() {
    swann = User.of("swann");
    gengu = User.of("gengu");
    insultRepository = new InMemoryInsulteRepository();
    queryHandler = new InsultQueryHandler(insultRepository);
  }

  @Test
  void test_gengu_insult_swann() {
    insultRepository.add("");
    var insulteQuery = new InsultQuery(swann, gengu, ZonedDateTime.now());
    var insult = queryHandler.handle(insulteQuery);

    assertThat(insult.textResponse).isNotBlank().contains("@swann");
    assertThat(insult.userCible).isEqualTo(swann);
  }

  @Test
  void test_swann_insult_gengu() {
    insultRepository.add("");
    var insultQuery = new InsultQuery(gengu, swann, ZonedDateTime.now());
    var insult = queryHandler.handle(insultQuery);

    assertThat(insult.textResponse).isNotBlank().contains("@gengu");
    assertThat(insult.userCible).isEqualTo(gengu);
  }

  @Test
  void test_gengu_insulte_swann_of_pokemon() {
    insultRepository.add("sale pokemon");
    var insultQuery = new InsultQuery(swann, gengu, ZonedDateTime.now());
    var insult = queryHandler.handle(insultQuery);
    assertThat(insult.textResponse).contains("sale pokemon");
  }

  @Test
  void test_gengu_insulte_swann_of_marmite() {
    insultRepository.add("sale marmite");
    var insultQuery = new InsultQuery(swann, gengu, ZonedDateTime.now());
    var insult = queryHandler.handle(insultQuery);
    assertThat(insult.textResponse).contains("sale marmite");
  }
}
