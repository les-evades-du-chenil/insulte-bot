package dog.chenil.use_case.insulte.exposition;

import java.util.Objects;

import dog.chenil.use_case.insulte.domain.User;

public class InsultResponse {
  public final String textResponse;
  public final User userCible;

  public InsultResponse(String textResponse, User userCible) {
    this.textResponse = Objects.requireNonNull(textResponse);
    this.userCible = Objects.requireNonNull(userCible);
  }
}
