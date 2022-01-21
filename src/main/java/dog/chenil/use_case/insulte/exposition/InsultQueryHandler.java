package dog.chenil.use_case.insulte.exposition;

import dog.chenil.use_case.insulte.domain.InsultRepository;

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
