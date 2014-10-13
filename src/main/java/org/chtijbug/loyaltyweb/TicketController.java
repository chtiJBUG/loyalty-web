/*
 * Copyright 2014 Pymma Software
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.chtijbug.loyaltyweb;

import loyalty.service.IServiceCalculate;
import loyalty.service.Ticket;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by IntelliJ IDEA.
 * Date: 08/10/14
 * Time: 10:37
 * To change this template use File | Settings | File Templates.
 */
@RestController
@RequestMapping("/ticket")
public class TicketController {
    @Resource
    private IServiceCalculate serviceCalculate;


    @RequestMapping(value = "/calculate", method = RequestMethod.PUT)
    public Ticket storeTicket(@RequestBody Ticket ticket) {
        Ticket response = null;
        try {
            response = serviceCalculate.calculate(ticket);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;

    }
}
