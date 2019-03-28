import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-adduser',
  templateUrl: './adduser.component.html',
  styleUrls: ['./adduser.component.css']
})
export class AdduserComponent implements OnInit {

  constructor(private userService: UserService) { }
  
  user: User;
  id: number = null; 
  ngOnInit() {
  }

  getUser(id: number){
    console.log(id);
    this.userService.getUser(id)
    .subscribe((user: User)=>{
      this.user = user;
      console.log(this.user);
    });
  }



}
