import { Component, OnInit } from '@angular/core';
import  { GetPlayService } from '../get-play.service';
import { ActivatedRoute } from '@angular/router';


@Component({
  selector: 'app-track-component',
  templateUrl: './track-component.component.html',
  styleUrls: ['./track-component.component.css']
})
export class TrackComponentComponent implements OnInit {

  currentTrack: Track = {
    trackId: "",
    album: [],
    name: []

  };


  constructor(private getPlay: GetPlayService, private route: ActivatedRoute) { }

  ngOnInit() {
    this.route.params.subscribe(param=>{
      this.currentTrack.name = param['track'];
      this.getTrack(this.currentTrack.trackId);
    })
  }

  getTrack(nameParam: string){
    this.getPlay.getTrack(nameParam).subscribe((response)=>{
      this.currentTrack = response;
    })
    
  }

}
