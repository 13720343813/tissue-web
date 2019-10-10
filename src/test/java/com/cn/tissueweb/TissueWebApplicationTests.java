package com.cn.tissueweb;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TissueWebApplicationTests {

    @Test
    public void df(){
        BigDecimal bigDecimal = new BigDecimal(0.711458);
        System.out.println(bigDecimal.setScale(4,BigDecimal.ROUND_HALF_DOWN).doubleValue());
        System.out.println(bigDecimal.setScale(4,BigDecimal.ROUND_HALF_UP).doubleValue());
    }

}
