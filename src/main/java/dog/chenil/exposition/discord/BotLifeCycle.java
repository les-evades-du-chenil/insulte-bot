package dog.chenil.exposition.discord;

import org.jboss.logging.Logger;

import net.dv8tion.jda.api.events.ShutdownEvent;
import net.dv8tion.jda.api.events.DisconnectEvent;
import net.dv8tion.jda.api.events.ExceptionEvent;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.events.ReconnectedEvent;
import net.dv8tion.jda.api.events.ResumedEvent;
import net.dv8tion.jda.api.events.StatusChangeEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class BotLifeCycle extends ListenerAdapter {
  private final Logger logger;

  public BotLifeCycle(Logger logger) {
    this.logger = logger;
  }

  @Override
  public void onReady(ReadyEvent event) {
    logger.info("bot is ready");
  }

  @Override
  public void onResumed(ResumedEvent event) {
    logger.info("bot is resumed with response " + event.getResponseNumber());
  }

  @Override
  public void onReconnected(ReconnectedEvent event) {
    logger.info("bot reconnected with response " + event.getResponseNumber());
  }

  @Override
  public void onDisconnect(DisconnectEvent event) {
    StringBuilder builder = new StringBuilder();
    builder.append("bot is disconected ");
    if (event.isClosedByServer()) {
      builder.append("by server ");
    }
    builder.append(event.getTimeDisconnected().toString());
    logger.info(builder.toString());
  }

  @Override
  public void onShutdown(ShutdownEvent event) {
    logger.info("bot is shutdown");
  }

  @Override
  public void onStatusChange(StatusChangeEvent event) {
    logger.info("bot status change oldStatus:" + event.getOldStatus().toString() + " new Status:"
        + event.getNewStatus().toString());
  }

  @Override
  public void onException(ExceptionEvent event) {
    logger.info("bot fail with exception message " + event.getCause().getMessage());
  }
}