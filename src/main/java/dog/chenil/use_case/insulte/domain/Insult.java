package dog.chenil.use_case.insulte.domain;

public class Insult {
  private final InsulteId id;

  public Insult(InsulteId id) {
    this.id = id;
  }

  public InsulteId getId() {
    return id;
  }
}
