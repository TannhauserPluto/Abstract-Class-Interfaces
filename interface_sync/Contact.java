public class Contact implements ISyncable {
  private String name;
  private String mobile;
  private String email;

  public Contact() {
  }

  public Contact(String name, String mobile, String email) {
    this.name = name;
    this.mobile = mobile;
    this.email = email;
  }

  // implements ISyncable interface
  public String getCode() {
    return "C";
  }

  // implements ISyncable interface
  public String encode() {
    String str = String.format("%s|%s|%s", name, mobile, email);

    System.out.println("Contact encoded successfully.");

    return str;
  }

  public void decode(String str) {
    // split() takes in a regular expression "\\|" to escape
    // the "|", which is a OR in regular expression. 
    // "\\|" transforms OR to a raw "|" character.
    String[] parts = str.split("\\|");

    if (parts.length != 3) {
      System.out.println("Incorrect Contact format. Decode unsuccessful.");
      return;
    }

    name = parts[0];
    mobile = parts[1];
    email = parts[2];

    System.out.println("Contact decoded successfully.");
  }
}
