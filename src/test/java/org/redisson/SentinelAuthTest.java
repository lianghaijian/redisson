package org.redisson;

import org.junit.Test;

import java.util.List;

/**
 * Created by lianghaijian on 2014-07-11.
 */
public class SentinelAuthTest {

    @Test
    public void testSentinelWithAuth() {
        Config config = new Config();
        config.useSentinelConnection().setPassword("foobared")
                .setMasterName("mymaster")
                .addSentinelAddress("192.168.27.111:26379", "192.168.27.112:26379");
        Redisson redisson = Redisson.create(config);
        List<String> list = redisson.getList("cms_list");
        list.add("haijian");
        redisson.shutdown();
    }
}
