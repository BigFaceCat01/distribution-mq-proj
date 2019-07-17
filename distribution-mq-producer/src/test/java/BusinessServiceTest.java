import com.hxb.common.model.mq.OrderPayMsgModel;
import com.hxb.common.model.request.UserSaveReq;
import com.hxb.mq.MqProducerApplication;
import com.hxb.mq.service.AbstractUserService;
import com.hxb.mq.service.BusinessService;
import com.hxb.mq.service.CacheClient;
import com.hxb.mq.service.SendService;
import com.hxb.mq.service.impl.TempService;
import com.hxb.structure.util.Md5Utils;
import com.hxb.structure.util.SnowFlakesUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Iterator;
import java.util.ServiceLoader;

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
    @Autowired
    private AbstractUserService abstractUserService;

    @Autowired
    private RedisTemplate redisTemplate;
    @Test
    public void testRedis(){
        UserSaveReq saveReq = UserSaveReq.builder().userName("test cglib transcation 2").password("asdkjlj2oijej").build();
        abstractUserService.insertUser(saveReq);
        System.out.println();
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
        TempService tempService = new TempService();
        try {
            Method say = TempService.class.getDeclaredMethod("say",new Class<?>[]{String.class});
            say.invoke(tempService,"hello");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
