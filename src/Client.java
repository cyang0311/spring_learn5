import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import pojo.User;
import redis.clients.jedis.*;


import java.util.*;

public class Client {

    //主从模式  哨兵
    private static ShardedJedis shard;
    //集群
    private static ShardedJedisPool pool;


    public static void main(String[] args) {
        Set<HostAndPort> jedisClusterNode = new HashSet<>();
        jedisClusterNode.add(new HostAndPort("192.0.0.0.1",7001));
        jedisClusterNode.add(new HostAndPort("192.0.0.0.1",7001));
        jedisClusterNode.add(new HostAndPort("192.0.0.0.1",7001));
        JedisPoolConfig cfg = new JedisPoolConfig();
        JedisCluster jc = new JedisCluster(jedisClusterNode,6000,100,cfg);


        Jedis j = new Jedis("127.0.0.1",6379);
        Map<String,String> map = new HashMap<>();

        String id1 = UUID.randomUUID().toString();
        User user1 = new User(id1,"z1","123");

        String id2 = UUID.randomUUID().toString();
        User user2 = new User(id2,"z2","123");

        String id3 = UUID.randomUUID().toString();
        User user3 = new User(id3,"z3","123");



        map.put(id1,user1.toString());
        map.put(id2,user2.toString());
        map.put(id2,user3.toString());
//        j.hmset("User",map);


        String result="";

        ObjectMapper mapper1 = new ObjectMapper();
        try {
            result = mapper1.writeValueAsString(map);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        System.out.println(result);
        System.out.println(map);

        j.hmset("USER_TABLE",map);
    }
}
