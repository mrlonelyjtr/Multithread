package activeobject;

class Proxy implements ActiveObject {
    private final SchedulerThread scheduler;
    private final Servant servant;

    public Proxy(SchedulerThread scheduler, Servant servant) {
        this.scheduler = scheduler;
        this.servant = servant;
    }

    @Override
    public Result<String> add(String x, String y) {
        FutureResult<String> future = new FutureResult<String>();
        scheduler.invoke(new AddRequest(servant, future, x, y));
        return future;
    }
}
