package dog.chenil.use_case.insult.application;

import net.dv8tion.jda.api.entities.User;

public class UserMapper {
  public dog.chenil.use_case.insult.domain.User mapDiscordUserToDomainUser(User discordUser) {
    return dog.chenil.use_case.insult.domain.User.of("Tmp Name", discordUser.getId(), discordUser.getName());
  }
}
