package com.coody.springbootrabbitmq.config.fanout;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Classname FanoutRabbitConfig
 * @Description 扇型交换机(广播模式)
 * @Author lw
 * @Date 2020-02-26 15:12
 */
@Configuration
public class FanoutRabbitConfig {

    /**
     * 1.创建三个队列：fanout.A、fanout.B、fanout.C
     * 2.将三个队列都绑定在交换机 fanoutExchange 上
     * 3.因为是扇型交换机, 路由键无需配置,配置也不起作用
     */

    /**
     * 创建队列：fanout.A
     *
     * @return
     */
    @Bean
    public Queue queueA() {
        return new Queue("fanout.A");
    }

    /**
     * 创建队列：fanout.B
     *
     * @return
     */
    @Bean
    public Queue queueB() {
        return new Queue("fanout.B");
    }

    /**
     * 创建队列：fanout.C
     *
     * @return
     */
    @Bean
    public Queue queueC() {
        return new Queue("fanout.C");
    }

    /**
     * 创建交换机：fanoutExchange
     *
     * @return
     */
    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange("fanoutExchange");
    }

    /**
     * 将队列fanout.A和交换机fanoutExchange绑定
     *
     * @return
     */
    @Bean
    Binding bindingExchangeA() {
        return BindingBuilder.bind(queueA()).to(fanoutExchange());
    }

    /**
     * 将队列fanout.B和交换机fanoutExchange绑定
     *
     * @return
     */
    @Bean
    Binding bindingExchangeB() {
        return BindingBuilder.bind(queueB()).to(fanoutExchange());
    }

    /**
     * 将队列fanout.C和交换机fanoutExchange绑定
     *
     * @return
     */
    @Bean
    Binding bindingExchangeC() {
        return BindingBuilder.bind(queueC()).to(fanoutExchange());
    }
}
