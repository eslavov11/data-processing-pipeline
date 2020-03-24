import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders, HttpResponse} from '@angular/common/http';
import * as Stomp from 'stompjs';
import * as SockJS from 'sockjs-client';
import {Observable} from 'rxjs';

@Injectable()
export class MessageService {
  private serverUrl = /*process.env.API_URL ||*/ 'http://localhost:8083/';
  private stompClient;
  public messages;

  constructor(private http: HttpClient) {
    this.messages = [];
    this.connectWebSocket();
  }

  public createMessage(message): Observable<any> {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type':  'application/json'
      })
    };

    return this.http.post(this.serverUrl + 'api/messages', message, httpOptions);
  }

  private connectWebSocket() {
    const ws = new SockJS(this.serverUrl + 'socket');
    this.stompClient = Stomp.over(ws);
    const self = this;
    this.stompClient.connect({}, (frame) => {
      self.stompClient.subscribe('/topic/message', (message) => {
        if (message.body) {
          self.messages.push(message.body);
        }
      });
    });
  }
}
