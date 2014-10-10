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
