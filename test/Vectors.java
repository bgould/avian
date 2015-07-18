import java.util.Vector;
import java.util.NoSuchElementException;
import java.util.Arrays;

public class Vectors {

  private static void expect(boolean v) {
    if (!v) throw new RuntimeException();
  }

  private static void testLastElement() {

    final Vector<String> v = new Vector<String>();
    
    v.add("happy");
    expect("happy".equals(v.lastElement()));
    expect(v.size() == 1);

    v.add("joy");
    expect("joy".equals(v.lastElement()));
    expect(v.size() == 2);

    v.add(null);
    expect(v.lastElement() == null);
    expect(v.size() == 3);

    try {
      v.clear();
      expect(v.size() == 0);
      v.lastElement();
      expect(false);
    } catch (final NoSuchElementException e) {
      expect(true);
    }

  }

  private static void testSetSize() {

    System.out.println("Entering Vectors.testSetSize()");

    final Vector<String> v = new Vector<String>();
    System.out.printf("  Initial vector: %s%n", v);

    v.setSize(10);
    System.out.printf("  Vector after setSize(10): %s%n", v);
    expect(v.size() == 10);
    for (int i = 0; i < 10; i++) {
      expect(v.get(i) == null);
    }

    v.clear();
    System.out.printf("  Vector cleared: %s%n", v);
    expect(v.size() == 0);

    v.addAll(Arrays.asList(new String[] { "1", "2", "3", "4" }));
    System.out.printf("  Vector populated: %s%n", v);
    expect(v.size() == 4);

    v.setSize(2);
    System.out.printf("  Vector after setSize(2): %s%n", v);
    expect("1".equals(v.get(0)));
    expect("2".equals(v.get(1)));
    expect(v.size() == 2);

    v.setSize(4);
    expect("1".equals(v.get(0)));
    System.out.printf("  Vector after setSize(4): %s%n", v);
    expect("1".equals(v.get(0)));
    expect("2".equals(v.get(1)));
    expect(null == (v.get(2)));
    expect(null == (v.get(3)));

    System.out.println("Exiting Vectors.testSetSize()");
  
  }

  public static void main(String[] args) {

    testLastElement();
    testSetSize();
  
  }

}
