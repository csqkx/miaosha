package lx.mq.mapper;


import lx.mq.domain.AccountLog;


public interface AccountLogMapper {
    /**
     * 插入日志
     * @param accountLog
     */
    void insert(AccountLog accountLog);
}
