package dog.chenil.use_case.insult.domain;

import java.util.Objects;

public class DiscordId {
  public final String id;

  public DiscordId(String id) {
    this.id = id;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    DiscordId other = (DiscordId) obj;
    return id.equals(other.id);
  }
}
