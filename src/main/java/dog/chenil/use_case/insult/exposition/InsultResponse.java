package dog.chenil.use_case.insult.exposition;

import java.util.Objects;

import dog.chenil.use_case.insult.domain.User;

public final class InsultResponse {
  public final String textResponse;
  public final User userCible;

  public InsultResponse(String textResponse, User userCible) {
    this.textResponse = Objects.requireNonNull(textResponse);
    this.userCible = Objects.requireNonNull(userCible);
  }
}
