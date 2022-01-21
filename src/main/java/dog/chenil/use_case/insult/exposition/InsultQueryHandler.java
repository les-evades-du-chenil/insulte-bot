package dog.chenil.use_case.insult.exposition;

import dog.chenil.use_case.insult.domain.InsultRepository;

public class InsultQueryHandler {
  private final InsultRepository insulteRepositry;

  public InsultQueryHandler(InsultRepository insulteRepositry) {
    this.insulteRepositry = insulteRepositry;
  }

  InsultResponse handle(InsultQuery command) {
    String insultBody = insulteRepositry.findInsultRandomly();
    return new InsultResponse("@" + command.cible.getFirstname() + " " + insultBody, command.cible);
  }
}
