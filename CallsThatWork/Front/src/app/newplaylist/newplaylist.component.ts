import { Component, OnInit } from '@angular/core';
import { GetPlayService } from '../get-play.service';
import { DomSanitizer } from '@angular/platform-browser';
import { SafeUrl } from '@angular/platform-browser' 
import { AddTrackComponent } from '../add-track/add-track.component';


//  var val:string = (<HTMLInputElement>document.getElementById("fi")).value;


@Component({
  selector: 'app-newplaylist',
  templateUrl: './newplaylist.component.html',
  styleUrls: ['./newplaylist.component.css']
})
export class NewplaylistComponent implements OnInit {
 
  name: string = 'lu';

fullLink: string = 'https://open.spotify.com/embed/user/1244653463/playlist/0ugR4wxPu1IUQ3r8P7vCLk'


  PlaylistHref: string = "https://open.spotify.com/embed/user/1244653463/playlist/"

  curply: string = "7sStwRbTGePw8Lo6OZxlY9";

  currentPlaylist: Playlist = {
    name: "",
    description: "",
    public: false
  }
  
  constructor(private getPlay: GetPlayService, private sanitize: DomSanitizer) { 
    this.sanitize = sanitize;
  }

  ngOnInit() {
   
  }
  
  
  playlistLink: string = this.PlaylistHref + this.currentPlaylist.name;
  showNewPlayistId(){
   
     this.getPlay.newPlaylist().subscribe((data: Playlist)=> this.currentPlaylist ={

       name: data['id'],
       description: data['description'],
       public: data['public']
     

  }); 
  }

  

  link: string = 'https://open.spotify.com/embed/user/1244653463/playlist/';
  
  cleanUrl(append: string){
   return this.sanitize.bypassSecurityTrustResourceUrl(this.link + append)
  }
  
}
