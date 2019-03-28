import { Component, OnInit } from '@angular/core';
import { GetPlayService } from '../get-play.service';

@Component({
  selector: 'app-newplaylist',
  templateUrl: './newplaylist.component.html',
  styleUrls: ['./newplaylist.component.css']
})
export class NewplaylistComponent implements OnInit {

  newPlaylist: Playlist ={
    name: "",
    playlistId: 0
  };
  constructor(private getPlay: GetPlayService) { }

  ngOnInit() {
  }

  showNewPlayistId(){
    this.getPlay.newPlaylist("testing");
  }

}
