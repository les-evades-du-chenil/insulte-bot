package dog.chenil.use_case.insult.domain;

import java.util.Objects;
import java.util.UUID;

public class InsultId {
  private final UUID id;

  private InsultId(UUID id) {
    this.id = Objects.requireNonNull(id);
  }

  public static InsultId of(UUID id) {
    return new InsultId(id);
  }

  public static InsultId of(String id) throws IllegalArgumentException {
    return new InsultId(UUID.fromString(id));
  }

  public static InsultId generate() {
    return new InsultId(UUID.randomUUID());
  }

  public UUID getId() {
    return id;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null || getClass() != obj.getClass())
      return false;
    InsultId other = (InsultId) obj;
    return id.equals(other.id);
  }

}
