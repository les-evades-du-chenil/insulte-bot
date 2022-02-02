package dog.chenil.exposition.web;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

import dog.chenil.use_case.insult.exposition.InsultUseCase;

@Path("/insult")
public final class InsultController {
  final InsultUseCase insultUseCase;

  public InsultController(InsultUseCase insultUseCase) {
    this.insultUseCase = insultUseCase;
  }

  @POST
  public void addInsult(String insult) {
    insultUseCase.addInsult(insult);
  }
}
