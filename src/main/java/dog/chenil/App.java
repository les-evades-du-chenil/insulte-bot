package dog.chenil;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.security.auth.login.LoginException;

import io.quarkus.runtime.StartupEvent;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

@ApplicationScoped
public class App {
  @Inject
  private ConfigDiscord configDiscord;

  void onStart(@Observes StartupEvent ev) throws LoginException {
    JDABuilder.createDefault(configDiscord.token())
        .setActivity(Activity.watching("!test"))
        .setStatus(OnlineStatus.ONLINE).build();
  }
}
