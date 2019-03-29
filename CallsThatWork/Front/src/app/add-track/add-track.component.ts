import { Component, OnInit } from '@angular/core';
import { GetPlayService } from '../get-play.service';


@Component({
  selector: 'app-add-track',
  templateUrl: './add-track.component.html',
  styleUrls: ['./add-track.component.css']
})
export class AddTrackComponent implements OnInit {

  currentTrack: Track = {
      trackId: "",
      album: [],
      name: []

  }

  constructor(private getPlay: GetPlayService) { }

  ngOnInit() {
  }

  addATrack(playlist:string, track:string){
    this.getPlay.addTrack(playlist, track).subscribe((data: Track)=>this.currentTrack={
      trackId: data['id'],
      album: data['album'],
      name: data['name']
    })
  }


}
