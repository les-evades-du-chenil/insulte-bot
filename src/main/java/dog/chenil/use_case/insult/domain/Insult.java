package dog.chenil.use_case.insult.domain;

public final class Insult {
  private final InsultId id;

  public Insult(InsultId id) {
    this.id = id;
  }

  public InsultId getId() {
    return id;
  }
}
