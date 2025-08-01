public class Program {
  public static void main(String[] args) {
    SyncEngine syncEng = new SyncEngine();

    System.out.println("** Adding to SyncEngine...");

    // add contact
    syncEng.add(new Contact("Jeremy", "90111222", "jeremy@door.com"));
    syncEng.add(new Task("Do Homework", 1, 8, 2024));

    Task task = new Task("Call Girlfriend", 1, 8, 2024);
    task.setDone(true);
    syncEng.add(task);

    // sync test
    System.out.println("\n** SyncEngine test...");
    syncEng.testSync();
  }
}
