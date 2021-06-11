/*
 * Copyright 2016 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file except in compliance
 * with the License. A copy of the License is located at
 *
 * http://aws.amazon.com/apache2.0/
 *
 * or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES
 * OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions
 * and limitations under the License.
 */
package com.amazonaws.serverless.transfer.core.controller;



import com.amazonaws.serverless.transfer.core.Transfer;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.security.Principal;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;


@RestController
@EnableWebMvc
public class TransferCoreController {
    @RequestMapping(path = "/verifysms/{smsId}", method = RequestMethod.GET)
    public String verifySms(@PathVariable String smsId) {
        if(smsId.equalsIgnoreCase("234567")){
            return "valid";
        }
        return "invalid";
    }

    @RequestMapping(path = "/verify/transfer", method = RequestMethod.POST)
    public String verifyTransfer(@RequestBody Transfer transfer) {
        boolean isValid = true;
        if(!transfer.getFromAccount().equalsIgnoreCase("1234")) {
            isValid = false;
        }
        if(!transfer.getToAccount().equalsIgnoreCase("3456")) {
            isValid = false;
        }
        return isValid ? "valid" : "invalid";
    }

    @RequestMapping(path = "/confirm/transfer", method = RequestMethod.POST)
    public String confirmTransfer(@RequestBody Transfer transfer) {
        Random random = new Random();
        String transferReference = String.format("%04d", random.nextInt(10000));
        return "DF"+transferReference;
    }

    @RequestMapping(path = "/healthcheck", method = RequestMethod.GET)
    public String verifySms() {
        return "succesfull";
    }
}
