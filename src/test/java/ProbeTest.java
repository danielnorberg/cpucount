import com.sun.management.OperatingSystemMXBean;

import org.junit.Test;

import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import static java.lang.System.out;
import static java.nio.file.Files.list;

public class ProbeTest {

  @Test
  public void probe() throws Exception {
    out.println("Runtime.getRuntime().availableProcessors(): " +
                Runtime.getRuntime().availableProcessors());

    out.println("ManagementFactory.getOperatingSystemMXBean().getAvailableProcessors(): " +
                ManagementFactory.getOperatingSystemMXBean().getAvailableProcessors());

    final OperatingSystemMXBean operatingSystemMXBean =
        (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();

    out.println("operatingSystemMXBean.getTotalPhysicalMemorySize(): " +
                operatingSystemMXBean.getTotalPhysicalMemorySize());

    out.println("operatingSystemMXBean.getFreePhysicalMemorySize(): " +
                operatingSystemMXBean.getFreePhysicalMemorySize());

    out.println("operatingSystemMXBean.getTotalSwapSpaceSize(): " +
                operatingSystemMXBean.getTotalSwapSpaceSize());

    try {
      out.println();
      out.println("$ ls /dev");
      list(Paths.get("/dev")).forEach(out::println);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
