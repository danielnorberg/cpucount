package cpucout;

import org.junit.Test;

import static java.lang.System.out;

public class CpuCountTest {

  @Test
  public void test() throws Exception {
    out.println("availableProcessors: " + Runtime.getRuntime().availableProcessors());
  }
}
