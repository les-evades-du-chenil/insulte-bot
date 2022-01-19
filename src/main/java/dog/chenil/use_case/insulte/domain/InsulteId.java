package dog.chenil.use_case.insulte.domain;

import java.util.Objects;
import java.util.UUID;

public class InsulteId {
  private final UUID id;

  private InsulteId(UUID id) {
    this.id = Objects.requireNonNull(id);
  }

  public static InsulteId of(UUID id) {
    return new InsulteId(id);
  }

  public static InsulteId of(String id) throws IllegalArgumentException {
    return new InsulteId(UUID.fromString(id));
  }

  public static InsulteId generate() {
    return new InsulteId(UUID.randomUUID());
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
    InsulteId other = (InsulteId) obj;
    return id.equals(other.id);
  }

}
