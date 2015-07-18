import java.util.Hashtable;

public class Hashtables {

  public static void expect(final boolean v) {
    if (!v) throw new RuntimeException();
  }

  public static void testClone() {

    final Hashtable<String, String> original = new Hashtable<String,String>();
    expect(original.isEmpty());

    final Hashtable<String,String> emptyClone = original.clone();
    expect(original != emptyClone);
    expect(emptyClone.isEmpty());
    expect(original.isEmpty());

    emptyClone.put("fundar", "blurp");
    expect(emptyClone.size() == 1);
    expect(original.size() == 0);

    final Hashtable<String,String> newClone = emptyClone.clone();
    expect(emptyClone.size() == 1);
    expect(newClone != emptyClone);
    expect("blurp".equals(emptyClone.get("fundar")));
    expect(newClone.size() == 1);
    expect("blurp".equals(newClone.get("fundar")));

  }

  public static void main(String[] args) {
    testClone();
  }

}
