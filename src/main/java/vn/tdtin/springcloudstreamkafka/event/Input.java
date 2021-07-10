package vn.tdtin.springcloudstreamkafka.event;

public interface Input {
    void sendMessage(String message);
}
