package dog.chenil.use_case.insult.mock;

import java.util.ArrayList;

import java.util.List;

import dog.chenil.kernel.Repository;
import dog.chenil.use_case.insult.domain.InsultRepository;

@Repository
public class InMemoryInsultRepository implements InsultRepository {

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
