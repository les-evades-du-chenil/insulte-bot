package dog.chenil.use_case.insulte.domain;

public interface InsultRepository {

  String findInsultRandomly();

  void add(String string);

}
