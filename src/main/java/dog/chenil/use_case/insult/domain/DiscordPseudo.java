package dog.chenil.use_case.insult.domain;

import java.util.Objects;

public final class DiscordPseudo {
  public final String name;

  public DiscordPseudo(String name) {
    this.name = Objects.requireNonNull(name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    DiscordPseudo other = (DiscordPseudo) obj;
    return name.equals(other.name);
  }
}
