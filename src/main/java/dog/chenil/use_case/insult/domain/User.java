package dog.chenil.use_case.insult.domain;

import java.util.Objects;

public final class User {
  private final String firstname;
  private final DiscordId discordId;
  private final DiscordPseudo discordPseudo;

  private User(String firstname, DiscordId discordId, DiscordPseudo discordPseudo) {
    this.firstname = Objects.requireNonNull(firstname);
    this.discordId = discordId;
    this.discordPseudo = discordPseudo;
  }

  public static User of(String firstname, String discordId, String discordPseudo) {
    return new User(firstname, new DiscordId(discordId), new DiscordPseudo(discordPseudo));
  }

  public String getFirstname() {
    return firstname;
  }

  public DiscordId getDiscordId() {
    return discordId;
  }

  public DiscordPseudo getDiscordPseudo() {
    return discordPseudo;
  }
}
