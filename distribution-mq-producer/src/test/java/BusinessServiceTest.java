import com.hxb.common.model.OrderPayMsgModel;
import com.hxb.mq.MqProducerApplication;
import com.hxb.mq.service.BusinessService;
import com.hxb.structure.util.SnowFlakesUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Created by huang xiao bao
 * @date 2019-04-17 15:47:52
 */
@SpringBootTest(classes = MqProducerApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class BusinessServiceTest {
    @Autowired
    private BusinessService businessService;
    @Test
    public void testSendMsg(){
        businessService.sendMsg(buildMsgModel());
    }

    /**
     * build a message model
     * @return
     */
    private OrderPayMsgModel buildMsgModel(){
        OrderPayMsgModel msgModel = new OrderPayMsgModel();
        msgModel.setOrderNo(SnowFlakesUtil.nextId());
        msgModel.setAmount(BigDecimal.ONE);
        msgModel.setPayTime(new Date());
        msgModel.setProductName("this is a test product");
        msgModel.setTotalPrice(1000000L);
        msgModel.setBuyerId(SnowFlakesUtil.nextId());
        return msgModel;
    }
}
