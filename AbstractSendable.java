public class AbstractSendable<T> implements Sendable<T> {
    private String from, to;
    private T content;

    protected AbstractSendable() {
        this.from = from;
        this.to = to;
        this.content = content;
    }

    @Override
    public String getFrom() {
        return from;
    }

    @Override
    public String getTo() {
        return to;
    }

    @Override
    public T getContent() {
        return content;
    }
}
