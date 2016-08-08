package org.exampledriven.sleuth.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.Span;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * Created by Peter_Szanto on 8/6/2016.
 */
@RestController
public class SleepController {

    private Logger logger = LoggerFactory.getLogger(SleepController.class);

    @Autowired
    private Tracer tracer;

    @RequestMapping(value = "/sleep", method = RequestMethod.POST)
    public SleepResponse sleep(@RequestBody SleepRequest sleepRequest) {

        logger.info(sleepRequest.getMessage());

        sleep(sleepRequest.getSleepInMillis() / 2);
        sleep(sleepRequest.getSleepInMillis() / 2);

        return new SleepResponse(sleepRequest.getMessage(), new Date());

    }

    private void sleep(int sleepInMillis) {

        Span span = tracer.createSpan("This span was created programmatically, sleep " + sleepInMillis);

        try {

            span.tag("sleepInMillis", "" + sleepInMillis);
            logger.info("sleepInMillis " + sleepInMillis);

            try {
                Thread.sleep(sleepInMillis);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        } finally {
            tracer.close(span);
        }


    }

}
