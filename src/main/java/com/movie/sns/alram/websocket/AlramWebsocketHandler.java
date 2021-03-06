package com.movie.sns.alram.websocket;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.movie.sns.alram.model.service.AlramService;
import com.movie.sns.alram.model.vo.Alram;
import com.movie.sns.member.model.vo.Member;

public class AlramWebsocketHandler extends TextWebSocketHandler {
	@Autowired
	private AlramService service;
	
	
	private Set<WebSocketSession> sessions = Collections.synchronizedSet(new HashSet<WebSocketSession>());

	// synchronizedSet : 동기화된 Set (HashSet)은 비동기
	// 왜? 멀티 쓰레드 환경에서 하나의 컬렉션 요소에 여러 쓰레드가 접근하면
	// 충돌 문제가 발생할 수 있으므로 , 동기화 시켜 줄을 세움.

	/*
	 * WebSocket - 브라우저와 웹서버간의 전이중통신을 지원하는 프로토콜이다 - HTML5버전부터 지원하는 기능이다. - 자바
	 * 톰캣7버전부터 지원했으나 8버전부터 본격적으로 지원한다. - spring4부터 웹소켓을 지원한다. (전이중 통신(Full Duplex):
	 * 두 대의 단말기가 데이터를 송수신하기 위해 동시에 각각 독립된 회선을 사용하는 통신 방식. 대표적으로 전화망, 고속 데이터 통신)
	 * 
	 * 
	 * 
	 * WebSocketHandler 인터페이스 : 웹소켓을 위한 메소드를 지원하는 인터페이스 -> WebSocketHandler 인터페이스를
	 * 상속받은 클래스를 이용해 웹소켓 기능을 구현
	 * 
	 * 
	 * WebSocketHandler 주요 메소드
	 * 
	 * void handlerMessage(WebSocketSession session, WebSocketMessage message) -
	 * 클라이언트로부터 메세지가 도착하면 실행
	 * 
	 * void afterConnectionEstablished(WebSocketSession session) - 클라이언트와 연결이 완료되고,
	 * 통신할 준비가 되면 실행
	 * 
	 * void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus)
	 * - 클라이언트와 연결이 종료되면 실행
	 * 
	 * void handleTransportError(WebSocketSession session, Throwable exception) -
	 * 메세지 전송중 에러가 발생하면 실행
	 * 
	 * ----------------------------------------------------------------------------
	 * 
	 * TextWebSocketHandler : WebSocketHandler 인터페이스를 상속받아 구현한 텍스트 메세지 전용 웹소켓 핸들러
	 * 클래스
	 * 
	 * handlerTextMessage(WebSocketSession session, TextMessage message) - 클라이언트로부터
	 * 텍스트 메세지를 받았을때 실행
	 * 
	 * 
	 */
	// 클라이언트 연결이 완료되고 , 통신 준비가 되면 실행
	

	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		// Established확립된
		// WebSoketSession : 서버간 전이중 통신 담당 객체
		// -> 웹 소켓 요청을 보낸 클라이언트와 통신할 수 있는 객체

		sessions.add(session);
		// 웹소켓 서버와 통신하는 클라이언트의 정보를 한 곳애 모아둠
		// (웹소켓 통신을 요청한 클라이언트들의 만남의 광장)
		System.out.println(session.getId() + "연결됨");
	}

	// 클라이언트로 부터 웹소켓 통신으로 텍스트 메세지를 전달 받은 경우 실행
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		// sessions : 웹소켓 요청을 보낸 모든 클라이언트의 세션 정보가 담겨있음

		
		/*
		 * ChatMessage temp = new ChatMessage(); temp.setMessage("테스트중"); for
		 * (WebSocketSession wss : sessions) {
		 * 
		 * wss.sendMessage(new TextMessage(new Gson().toJson(temp))); }
		 */
		 
		System.out.println("전달 받은 내용 :" + message.getPayload());

		// Jackson-databind 의 ObjectMapper 객체
		// - JSON 문자열의 모든 key 값이 특정 클래스의 필드와 모두 일치하면
		// 클래스를 이용해 새 객체를 만들고 ,
		// JSON 문자열을 읽어 같은 필드에 값을 대입함
		ObjectMapper objectMapper = new ObjectMapper();
//
		Alram alram = objectMapper.readValue(message.getPayload(),  Alram.class);
		
		System.out.println("변경된 alram : "+  alram);
		// takeNo
		// url
		// content
		// 시퀀스
		
		int result = service.insertAlram(alram); ; // insret 후 알람을 받아야되는 회원의 알람 목록 조회
						//-> 기존 알람 내용 화면에서 지우고 다시 만들기
		
		
		
		

		if (result >0) {

			for (WebSocketSession wss : sessions) {
				// WebSocketSession : 웹소켓서버 - 클라이언트 간의 통신을 가능하게 하는 객체
				// + HTTPSession을 가로채어 가지고있는객체

				/*
				 * ChatMessage temp = new ChatMessage(); temp.setMessage("테스트 중입니다.");
				 * wss.sendMessage(new TextMessage(new Gson().toJson(temp)));
				 */

				// sessions에 저장된 모든 클라이언트 세션 정보에서
				// chatRoomNo 속성을 얻어오는 구문
				int memberNo = ((Member)wss.getAttributes().get("loginMember")).getMemberNo();
				
				if(memberNo == alram.getAlramTakeMemberNo()) {
					wss.sendMessage(new TextMessage(message.getPayload()));
					wss.sendMessage(new TextMessage(new Gson().toJson(alram)));
					
				}


			}
		}

		super.handleTextMessage(session, message);
	}

	// 클라이언트와 연결이 종료되면 실행
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {

		// sessions에서 웹소켓 연결을 종료한 클라이언트 세션을 삭제
		sessions.remove(session);
		super.afterConnectionClosed(session, status);
	}


}
