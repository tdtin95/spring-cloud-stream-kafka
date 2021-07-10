package vn.tdtin.springcloudstreamkafka.event;

import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

@Component
@ApplicationScope
public class InputFactory {

    private ApplicationContext context;

    public InputFactory(ApplicationContext context) {
        this.context = context;
    }

    public Input getInput(String channelName) {
        try {
            return context.getBean(channelName, Input.class);
        } catch (NoSuchBeanDefinitionException e) {
            return context.getBean(Producer.NAME, Input.class);
        }
    }
}
