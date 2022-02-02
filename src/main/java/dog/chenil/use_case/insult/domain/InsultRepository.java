package dog.chenil.use_case.insult.domain;

public interface InsultRepository {

  String findInsultRandomly();

  void add(String insult);

}
