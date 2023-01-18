import java.util.*;
import java.util.function.*;

public interface Sendable <T> {
    String getFrom();
    String getTo();
    T getContent();
}

public static class MailMessage extends AbstractSendable <String> {

    public MailMessage(String from, String to, String content) {
        super();
    }
}
public static class Salary extends AbstractSendable <Integer> {

    public Salary (String from, String to, Integer content) {
        super();
    }
}

public static class MailService <T> implements Consumer<Sendable<T>> {
    private Map <String, List<T>> messages = new HashMap<>();

    public Map <String, List<T>> getMailBox(){
        return messages;
    }
    public List<T> get(String key) {
        return (containsKey(key)) ? (messages.getOrDefault(key, new LinkedList<T>())) : Collections.emptyList();
    }

    private boolean containsKey(String key) {
        return false;
    }

    @Override
    public void accept (Sendable<T> sendable) {
        messages.computeIfAbsent(sendable.getTo(), key -> new ArrayList<>()).add(sendable.getContent());
    }

}

// Почитайте про методы Map.computeIfAbsent() для переопределения метода Consumer'а,
// и Map.getOrDefault() для переопределения метода HashMap. Какие конкретно методы переопределять думаю поймете и так
//2021-01-12
