package cpucout;

import com.sun.management.OperatingSystemMXBean;

import org.junit.Test;

import java.lang.management.ManagementFactory;

import static java.lang.System.out;

public class CpuCountTest {

  @Test
  public void test() throws Exception {
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
  }
}
