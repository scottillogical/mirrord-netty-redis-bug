package zipcar;

import org.redisson.Redisson;
import org.redisson.api.RSet;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

public class Bootstrap {

    public void install() {
        // Install cheetah from scratch cheetah (not run in PRODUCTION)
    }

    public void beforeLaunch() throws Exception {
    }

    public void reset() {
        // Reset the state between every test
    }

    public static void main(String[] args) {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://cheetah-redis-master.scott1.svc.cluster.local:6379");
        //  config.useSingleServer().setAddress("redis://localhost:6379");
        RedissonClient redisson = Redisson.create(config);
        RSet<String> set = redisson.getSet("mySet");
        set.add("1");
        redisson.shutdown();
    }
}
