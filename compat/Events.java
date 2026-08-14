package community.krynet.compat;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public final class Events {

    private static final BlockingQueue<Event> QUEUE =
        new LinkedBlockingQueue<>();

    private Events() {}

    public static void post(Event event) {
        if (event == null) {
            return;
        }

        QUEUE.offer(event);
    }

    public static Event poll() {
        return QUEUE.poll();
    }

    public static void pump() {
        Event event;

        while ((event = QUEUE.poll()) != null) {
            event.dispatch();
        }

        Thread.yield();
    }

    public interface Event {
        void dispatch();
    }
}
