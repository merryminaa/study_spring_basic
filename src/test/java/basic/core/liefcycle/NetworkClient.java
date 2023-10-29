package basic.core.liefcycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import javax.security.auth.DestroyFailedException;

public class NetworkClient {

    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출, url = " + url);
        connect();
        call("초기화 연결 메시지");
    }

    public void setUrl(String url) {
        this.url = url;
    }

    // 서비스 시작시 호출
    public void connect() {
        System.out.println("connect: " + url);
    }

    public void call(String msg) {
        System.out.println("call: " + url + " msg: " + msg);
    }

    // 서비스 종료시 호출
    public void disconnect() {
        System.out.println("close: " + url);
    }

    @PostConstruct
    public void init() { // 의존관계 주입 후 실행
        System.out.println("NetworkClient.init");
        connect();
        call("초기화 연결 메시지");
    }

    @PreDestroy
    public void close() { // 빈 종료시 호출
        System.out.println("NetworkClient.close");
        disconnect();
    }
}
