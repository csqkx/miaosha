package lx.mq.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;


@Setter@Getter
public class UsableIntegral implements Serializable {
    private Long userId;//用户id
    private Date gmtCreated;//创建时间
    private Date gmtModified;//更新时间
    private Long amount;//目前可用积分
    private Long freezedAmount;//冻结金额
    public Long getUsableAmount(){
        return amount-freezedAmount;
    }
}
