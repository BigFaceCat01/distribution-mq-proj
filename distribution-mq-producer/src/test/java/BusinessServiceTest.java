import com.hxb.common.model.mq.OrderPayMsgModel;
import com.hxb.mq.MqProducerApplication;
import com.hxb.mq.service.SendService;
import com.hxb.structure.util.Md5Utils;
import com.hxb.structure.util.SnowFlakesUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

/**
 * @author Created by huang xiao bao
 * @date 2019-04-17 15:47:52
 */
@SpringBootTest(classes = MqProducerApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class BusinessServiceTest {
    @Autowired
    private SendService sendService;
    @Test
    public void testSendMsg(){
        sendService.sendMessage(buildMsgModel());
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

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            System.out.println(SnowFlakesUtil.nextId());
        }
        System.out.println(Md5Utils.md5("admin"));
    }
}
