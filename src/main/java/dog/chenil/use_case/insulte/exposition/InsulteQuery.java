package dog.chenil.use_case.insulte.exposition;

import java.time.ZonedDateTime;

import dog.chenil.use_case.insulte.domain.InsulteId;
import dog.chenil.use_case.insulte.domain.User;

public class InsulteQuery {
  User cible;
  User author;
  ZonedDateTime occurenceDate;
  InsulteId id;
}
