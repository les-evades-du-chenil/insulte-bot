package dog.chenil.use_case.insult.exposition;

import dog.chenil.use_case.insult.domain.InsultRepository;

public class InsultCommandHandler implements InsultUseCase {
  private final InsultRepository insultRepository;

  public InsultCommandHandler(InsultRepository insultRepository) {
    this.insultRepository = insultRepository;
  }

  @Override
  public void addInsult(String insult) {
    insultRepository.add(insult);
  }
}
