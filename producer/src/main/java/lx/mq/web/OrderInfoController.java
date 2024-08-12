package lx.mq.web;


import lx.mq.service.IOrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/orderInfo")
public class OrderInfoController {
    @Autowired
    private IOrderInfoService orderInfoService;

    @RequestMapping("/refund")
    public String refund(String orderNo){
        return orderInfoService.refund(orderNo);
    }
}
