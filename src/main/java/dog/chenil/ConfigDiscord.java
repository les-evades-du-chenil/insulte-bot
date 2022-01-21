package dog.chenil;

import io.quarkus.runtime.annotations.StaticInitSafe;
import io.smallrye.config.ConfigMapping;

@StaticInitSafe
@ConfigMapping(prefix = "discord")
public interface ConfigDiscord {
  String token();
}
