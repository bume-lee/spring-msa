package vntg.api.user.msa.component;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

@EnableBinding(MessageProducer.JoinSource.class)
public class MessageProducer {

    public interface JoinSource {
        String join = "join";

        @Output(join)
        MessageChannel join();
    }
}
