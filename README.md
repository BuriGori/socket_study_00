# socket_study_00


## socket에 대해서 정리하고 실습

1. SocketHandler -Component
``` java
@Component
@Slf4j
public class SocketHandler extends TextWebSocketHandler {
    private final static Logger LOG = Logger.getGlobal();
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception{
        String input = message.getPayload();
        LOG.info(input);
        TextMessage textMessage = new TextMessage("hello test");
        session.sendMessage(textMessage);
    }
}
```
  - TextWebSocketHandler를 상속 받아서 사용한다.
  - 세션과 메세지를 받아오는데 메세지 값을 로그로 남겨주고 세션에게 텍스트 값을 답변하는 구조
  - 세션과 메세지를 받아오는 부분이라는 것을 기억해야한다.
  - 필요한 개선점
    - afterConnectionEstablished, afterConnectionClosed 등과 같은 WebSocketHandler을 구성할 필요가 있다.
    - WebSocketSession을 관리하는 sessionList가 필요하다.
    - CDN방식으로 SockJS 라이브러리 참조?

2. WebSocketConfig
``` java
@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {
    private final WebSocketHandler webSocketHandler;

    public WebSocketConfig(WebSocketHandler webSocketHandler){
        this.webSocketHandler=webSocketHandler;
    }

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry){
        registry.addHandler(webSocketHandler, "/ws/chat").setAllowedOrigins("*");
    }
}
```
  - 웹소켓을 설정하는 부분으로 WebSocketConfigurer를 구현하게 되어있다.
  - WebSocketConfig를 주입받는다.
  - WebSocketHandler를 Registry에 등록해주는 메소드가 있다.
  
