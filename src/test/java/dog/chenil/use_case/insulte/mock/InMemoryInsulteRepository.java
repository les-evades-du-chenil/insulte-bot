package dog.chenil.use_case.insulte.mock;

import java.util.ArrayList;

import java.util.List;
import dog.chenil.use_case.insulte.domain.InsultRepository;

public class InMemoryInsulteRepository implements InsultRepository {

  private List<String> insults = new ArrayList<>();
  private int index = 0;

  @Override
  public String findInsultRandomly() {
    return insults.get(index++);
  }

  @Override
  public void add(String insult) {
    insults.add(insult);
  }
}
