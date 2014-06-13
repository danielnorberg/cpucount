import com.google.common.io.ByteStreams;

import com.sun.management.OperatingSystemMXBean;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.nio.file.Paths;

import static com.google.common.io.BaseEncoding.base16;
import static java.lang.System.out;
import static java.nio.file.Files.exists;
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

    out.println();
    out.println("/dev/urandom exists: " + exists(Paths.get("/dev/urandom")));

    final FileInputStream urandom = new FileInputStream("/dev/urandom");
    final byte[] blurb = new byte[4];
    ByteStreams.readFully(urandom, blurb);
    out.println("blurb: " + base16().lowerCase().encode(blurb));
  }
}
