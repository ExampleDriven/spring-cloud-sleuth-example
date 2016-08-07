package org.exampledriven.sleuth.rest;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * Created by Peter_Szanto on 8/6/2016.
 */
@RestController
public class SleepController {

    Logger logger = LoggerFactory.getLogger(SleepController.class);

    @RequestMapping(value = "/sleep", method = RequestMethod.POST)
    public SleepResponse test(@RequestBody SleepRequest sleepRequest) {

        try {
            Thread.sleep(sleepRequest.getSleepInMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        logger.debug(sleepRequest.getMessage());

        return new SleepResponse(sleepRequest.getMessage(), new Date());

    }

}
