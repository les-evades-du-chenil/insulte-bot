package dog.chenil.use_case.insult.exposition;

import java.time.ZonedDateTime;
import java.util.Objects;

import dog.chenil.use_case.insult.domain.User;

public final class InsultQuery {
  User cible;
  User author;
  ZonedDateTime occurenceDate;

  public InsultQuery(User cible, User author, ZonedDateTime occurenceDate) {
    this.cible = Objects.requireNonNull(cible);
    this.author = Objects.requireNonNull(author);
    this.occurenceDate = Objects.requireNonNull(occurenceDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cible, author, occurenceDate);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    InsultQuery other = (InsultQuery) obj;
    return other.cible.equals(cible) && other.author.equals(author) && other.occurenceDate.equals(occurenceDate);
  }
}
