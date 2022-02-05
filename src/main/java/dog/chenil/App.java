package dog.chenil;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
// import javax.security.auth.login.LoginException;

import dog.chenil.exposition.discord.InsultListnener;
import io.quarkus.runtime.StartupEvent;
// import net.dv8tion.jda.api.JDABuilder;
// import net.dv8tion.jda.api.OnlineStatus;
// import net.dv8tion.jda.api.entities.Activity;

@ApplicationScoped
public final class App {
  @Inject
  ConfigDiscord configDiscord;

  @Inject
  InsultListnener insultListnener;

  void onStart(@Observes StartupEvent ev) {
    // try {
    // JDABuilder.createDefault(configDiscord.token())
    // .setActivity(Activity.watching("!test"))
    // .addEventListeners(insultListnener)
    // .setStatus(OnlineStatus.ONLINE).build();
    // } catch (LoginException e) {
    // // maybe in test
    // }
  }
}
