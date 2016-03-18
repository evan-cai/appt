package live.appt.appter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.CountDownLatch;

/**
 * AppterService
 * @author evan
 * @date 16/3/18
 */
public class AppterService {
    private static final Logger logger = LoggerFactory.getLogger(AppterService.class);

    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring/spring.xml");
        ctx.registerShutdownHook();
        ctx.start();
        logger.info("service is started");
        logger.info("java.library.path=" + System.getProperty("java.library.path"));
        CountDownLatch latch = new CountDownLatch(1);
        try {
            latch.await();
        } catch (InterruptedException ignored) {
        }
    }
}
