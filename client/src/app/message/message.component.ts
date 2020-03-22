import {Component, OnInit} from '@angular/core';
import {MessageService} from '../shared/services/message.service';
import {NgForm} from '@angular/forms';

@Component({
  selector: 'app-message',
  templateUrl: './message.component.html',
  styleUrls: ['./message.component.css']
})
export class MessageComponent implements OnInit {

  constructor(public messageService: MessageService) {
  }

  ngOnInit(): void {
  }

  onSubmit(f: NgForm) {
    const message = f.value.message;
    this.messageService.createMessage(message).subscribe(
      response => console.log(response),
      err => console.log(err)
    );
  }
}
