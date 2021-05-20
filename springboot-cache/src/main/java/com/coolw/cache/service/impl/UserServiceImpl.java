package com.coolw.cache.service.impl;

import com.coolw.cache.dao.UserMapper;
import com.coolw.cache.entity.User;
import com.coolw.cache.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @Description
 * @Author coolw
 * @Date 2020-03-05 15:51
 */
@Slf4j
// @CacheConfig(cacheNames="user") // 抽象公共的缓存配置
@Service
public class UserServiceImpl implements UserService {

    /*
    * @Cacheable:触发缓存写入。
    * @CacheEvict:触发缓存清除。
    * @CachePut:更新缓存(不会影响到方法的运行)。
    * @Caching:重新组合要应用于方法的多个缓存操作。
    * @CacheConfig:设置类级别上共享的一些常见缓存设置。
    */

    @Resource
    private UserMapper userMapper;

    /**
     * "@Cacheable"：将方法的结果进行缓存，以后在需要数据时，直接在缓存中获取，不会再调用方法
     *      1.cacheNames : 缓存的名字
     *      2.key : 该 cacheNames 缓存中的使用的key值，不指定时默认使用方法的参数，
     *          也可以使用 sepl 表达式来指定其值，比如：key="#id" 表示 queryEmp 方法的参数 id 的值，
     *          同时 "#id" 等价于 "#"a0、"#p0"、#root.args[0]
     *      3.keyGenerator : 指定key的生成器。key / keyGenerator 二选一使用，不要同时使用
     *      4.cacheManager : 指定从哪个缓存管理器中取，比如在 RedisCache 还是ConcurrentMapCache 中取值
     *      5.condition : 指定缓存条件，满足某些条件后才缓存方法结果，也可以是 spel 表达式,
     *          比如：condition = "#id > 0"，当第一个参数值大于1时才缓存
     *      6.unless : 否定缓存，当 unless 指定的条件返回 true 是，方法结果就不会被缓存,
     *          比如：unless = "#result == null" 意思是方法返回结果为空，不进行缓存
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Cacheable(value = "user", key = "#id")
    public User queryUserById(Integer id) {
        return userMapper.queryUserById(id);
    }

    /**
     * "@CachePut"：调用注解的方法，又去更新缓存数据。
     * 使用场景，修改数据库的某些数据的同时更新缓存数据。这个注解的运行时机先运行目标方法，再将结果缓存起来。
     */
    @Override
    @CachePut(value = "user", key = "#user.id")
    public Integer updateUserById(User user) {
        return userMapper.updateUserById(user);
    }

    /**
     * "@CacheEvict"：清除缓存中的数据
     *      key：指定要清除的数据
     *      allEntries = true：指定清除这个缓存中所有的数据
     *      beforeInvocation = false：缓存的清除是否在方法之前执行,
     *          默认代表缓存清除操作是在方法执行之后执行;如果出现异常缓存就不会清除
     *      beforeInvocation = true：代表清除缓存操作是在方法运行之前执行，无论方法是否出现异常，缓存都清除
     */
    @Override
    @CacheEvict(value = "user", beforeInvocation = true) /* key = "#id" */
    public Integer deleteUserById(Integer id) {
        log.info("id={}", id);
        return userMapper.deleteUserById(id);
    }

    /**
     * "@Caching"：定义复杂的缓存规则
     * 根据username查询的结果会放到缓存中，同时也会以id，email为key来缓存数据的。
     * 在使用username查询时，方法还是会执行，因为使用@CachePut注解，这个注解要求目标方法一定要执行的
     */
    @Override
    @Caching(
        cacheable = {
            @Cacheable(value = "user", key = "#username")
        },
        put = {
            @CachePut(value = "user", key = "#result.id"),
            @CachePut(value = "user", key = "#result.password")
        }
    )
    public User queryUserByName(String username) {
        log.info("username={}", username);
        return userMapper.queryUserByName(username);
    }
}
