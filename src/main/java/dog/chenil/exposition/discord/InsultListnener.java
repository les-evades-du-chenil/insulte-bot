package dog.chenil.exposition.discord;

import java.time.ZonedDateTime;

import dog.chenil.use_case.insult.application.UserMapper;
import dog.chenil.use_case.insult.exposition.InsultQuery;
import dog.chenil.use_case.insult.exposition.InsultQueryHandler;
import net.dv8tion.jda.api.MessageBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class InsultListnener extends ListenerAdapter {
  private final InsultQueryHandler insultHandler;
  private final UserMapper userMapper;

  public InsultListnener(InsultQueryHandler insultHandler, UserMapper userMapper) {
    this.insultHandler = insultHandler;
    this.userMapper = userMapper;
  }

  @Override
  public void onSlashCommand(SlashCommandEvent event) {
    throw new UnsupportedOperationException();
  }

  @Override
  public void onMessageReceived(MessageReceivedEvent event) {
    var message = event.getMessage();
    var author = userMapper.mapDiscordUserToDomainUser(event.getAuthor());
    if (!message.getContentRaw().contains("insulte")) {
      return;
    }
    for (Member user : message.getMentionedMembers()) {
      var cible = userMapper.mapDiscordUserToDomainUser(event.getAuthor());
      var insult = insultHandler.handle(new InsultQuery(author, cible, ZonedDateTime.now()));
      MessageChannel channel = event.getChannel();
      var messageBuilder = new MessageBuilder();
      messageBuilder.mentionUsers(user.getAsMention());
      messageBuilder.append(" " + insult.toString());
      channel.sendMessage(messageBuilder.build());
    }
  }
}
