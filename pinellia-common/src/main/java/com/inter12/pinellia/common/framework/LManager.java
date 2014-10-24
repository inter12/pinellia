package com.inter12.pinellia.common.framework;

import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import com.inter12.pinellia.common.util.CommonServiceLocator;

public class LManager {

    private final Logger           logger                 = LoggerFactory.getLogger(LManager.class.getName());

    private static final int       MAX_WAIT_TIME          = 5;

    private ThreadPoolTaskExecutor threadPoolTaskExecutor = CommonServiceLocator.getThreadPools();

    public void execute(final LDefaultContext context) throws Exception {

        if (context.getTotalCount() == 0) {
            return;
        }

        final CountDownLatch countDownLatch = new CountDownLatch(context.getTotalCount());

        Iterator<LProcessor> iterator = context.processorsIterator();

        while (iterator.hasNext()) {
            final LProcessor processor = iterator.next();

            threadPoolTaskExecutor.execute(new Runnable() {

                @Override
                public void run() {
                    try {
                        processor.handle(context);
                    } catch (Exception e) {

                    } finally {
                        countDownLatch.countDown();
                    }

                }
            });
        }

        countDownLatch.await(MAX_WAIT_TIME, TimeUnit.SECONDS);
    }

    public void executeUnlimit(final LDefaultContext context) throws Exception {

        if (context.getTotalCount() == 0) {
            return;
        }

        final CountDownLatch countDownLatch = new CountDownLatch(context.getTotalCount());

        Iterator<LProcessor> iterator = context.processorsIterator();

        while (iterator.hasNext()) {
            final LProcessor processor = iterator.next();

            threadPoolTaskExecutor.execute(new Runnable() {

                @Override
                public void run() {
                    try {
                        processor.handle(context);
                    } catch (Exception e) {

                    } finally {
                        countDownLatch.countDown();
                    }

                }
            });
        }

        countDownLatch.await();
    }

}
