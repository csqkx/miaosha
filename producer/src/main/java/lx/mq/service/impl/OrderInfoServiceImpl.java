package lx.mq.service.impl;


import com.alibaba.fastjson.JSON;
import lx.mq.domain.OperateIntergralVo;
import lx.mq.domain.OrderInfo;
import lx.mq.mapper.OrderInfoMapper;
import lx.mq.service.IOrderInfoService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderInfoServiceImpl implements IOrderInfoService {
//    @Autowired
//    private RocketMQTemplate rocketMQTemplate;
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private OrderInfoMapper orderInfoMapper;
    @Override
    @Transactional
    public String refund(String orderNo) {
        OrderInfo orderInfo = orderInfoMapper.select(orderNo);
        OperateIntergralVo vo = new OperateIntergralVo();
        vo.setUserId(orderInfo.getUserId());
        vo.setValue(orderInfo.getIntergral());
        //发送消息
        rabbitTemplate.convertAndSend("","refund_queue",JSON.toJSONString(vo));
        //修改退款状态
        orderInfoMapper.changeRefundStatus(orderNo, OrderInfo.STATUS_REFUND);
        return "退款成功";
    }
}
