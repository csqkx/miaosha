package lx.mq.service;


import lx.mq.domain.OperateIntergralVo;

/**
 * Created by lanxw
 */
public interface IIntegralService {
    /**
     * 增加积分
     * @param operateIntergralVo
     * @return 变化后的用户积分
     */
    void incrIntergral(OperateIntergralVo operateIntergralVo);
}
