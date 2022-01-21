package dog.chenil.use_case.insult.domain;

public class User {
  private final String firstname;

  private User(String firstname) {
    this.firstname = firstname;
  }

  public static User of(String firstname) {
    return new User(firstname);
  }

  public String getFirstname() {
    return firstname;
  }
}
