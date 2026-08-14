package community.krynet.compat;

public abstract class Application {

    private boolean running;

    public final boolean launch() {
        if (!Compat.initialize()) {
            return false;
        }

        if (!init()) {
            Compat.shutdown();
            return false;
        }

        running = true;

        int result = run();

        shutdown();

        return result == 0;
    }

    protected boolean init() {
        return true;
    }

    protected int run() {
        while (running) {
            Events.pump();
        }

        return 0;
    }

    protected void stop() {
        running = false;
    }

    protected void shutdown() {
        Compat.shutdown();
    }

    public boolean running() {
        return running;
    }
}
