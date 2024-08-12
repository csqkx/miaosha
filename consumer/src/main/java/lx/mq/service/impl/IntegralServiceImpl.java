package lx.mq.service.impl;


import lx.mq.domain.OperateIntergralVo;
import lx.mq.mapper.UsableIntegralMapper;
import lx.mq.service.IIntegralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class IntegralServiceImpl implements IIntegralService {
    @Autowired
    private UsableIntegralMapper usableIntegralMapper;
    @Override
    @Transactional
    public void incrIntergral(OperateIntergralVo operateIntergralVo) {
        usableIntegralMapper.addIntergral(operateIntergralVo.getUserId(),operateIntergralVo.getValue());
    }
}
