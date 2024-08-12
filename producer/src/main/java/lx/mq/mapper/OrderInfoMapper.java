package lx.mq.mapper;


import lx.mq.domain.OrderInfo;
import org.apache.ibatis.annotations.Param;


public interface OrderInfoMapper {
    OrderInfo select(String orderNo);
    int changeRefundStatus(@Param("orderNo") String orderNo,@Param("status") int status);
}
