package api.team.msa.component;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.SubscribableChannel;

@EnableBinding(MessageConsumer.joinSink.class)
public class MessageConsumer {

	@StreamListener(joinSink.join)
	public void joinHandler(String message) {

		//get team count service logic
		System.out.println("team count service : "+message);
	}


    public interface joinSink {
        String join = "join";

        @Input(join)
        SubscribableChannel join();
    }
}
