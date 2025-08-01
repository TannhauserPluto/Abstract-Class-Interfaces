public class Task implements ISyncable {

  private String desc;
  private int day;
  private int month;
  private int year;
  private boolean isDone;

  public Task() {
  }

  public Task(String desc, int day, int month, int year) {
    this.desc = desc;
    this.day = day;
    this.month = month;
    this.year = year;
  }

  public void setDone(boolean status) {
    isDone = status;
  }

  // implements ISyncable interface
  public String getCode() {
    return "T";
  }

  // implements ISyncable interface 
  public String encode() {
    String str = String.format("%s|%d|%d|%d|%d", 
        desc, day, month, year, isDone ? 1 : 0);

    System.out.println("Task encoded successfully.");

    return str;
  }

  public void decode(String str) {
    String[] parts = str.split("\\|");

    if (parts.length != 5) {
      System.out.println("Incorrect Task format. Decode unsuccessful.");
      return;
    }

    desc = parts[0];
    day = Integer.valueOf(parts[1]);
    month = Integer.valueOf(parts[2]);
    year = Integer.valueOf(parts[3]);
    isDone = parts[4].equals("1") ? true : false;

    System.out.println("Task decoded successfully.");
  }
}
