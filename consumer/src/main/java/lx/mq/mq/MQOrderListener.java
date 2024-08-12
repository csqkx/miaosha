package lx.mq.mq;


import com.alibaba.fastjson.JSON;
import lx.mq.domain.OperateIntergralVo;
import lx.mq.service.IIntegralService;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class MQOrderListener {
    @Autowired
    private IIntegralService iIntegralService;

    @RabbitListener(queuesToDeclare = @Queue("refund_queue"))
    public void comer(String msg){
        OperateIntergralVo vo = JSON.parseObject(msg, OperateIntergralVo.class);
        //加积分操作
        iIntegralService.incrIntergral(vo);
    }
}
