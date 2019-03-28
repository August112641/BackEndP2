import { Component, OnInit } from '@angular/core';
import { GetPlayService } from '../get-play.service';
import { DomSanitizer } from '@angular/platform-browser';
import { SafeUrl } from '@angular/platform-browser' 

@Component({
  selector: 'app-newplaylist',
  templateUrl: './newplaylist.component.html',
  styleUrls: ['./newplaylist.component.css']
})
export class NewplaylistComponent implements OnInit {

  name: string = 'lu';

fullLink: string = 'https://open.spotify.com/embed/user/1244653463/playlist/7sStwRbTGePw8Lo6OZxlY9'


  PlaylistHref: string = "https://open.spotify.com/embed/user/1244653463/playlist/"

  curply: string = "7sStwRbTGePw8Lo6OZxlY9";

  currentPlaylist: Playlist = {
    name: "7sStwRbTGePw8Lo6OZxlY9",
    description: "",
    public: false
  }
  
  constructor(private getPlay: GetPlayService, private sanitize: DomSanitizer) { 
    this.sanitize = sanitize;
  }

  ngOnInit() {
   
  }
  link: string = `https://open.spotify.com/embed/user/1244653463/playlist/${this.currentPlaylist.name}`

  cleanUrl(){
   return this.sanitize.bypassSecurityTrustResourceUrl(this.fullLink)
  }

  playlistLink: string = this.PlaylistHref + this.currentPlaylist.name;
  showNewPlayistId(){
    
    this.getPlay.newPlaylist().subscribe((data: Playlist)=> this.currentPlaylist ={   
       name: data['id'],
       description: data['description'],
       public: data['public']


  }); 
  


  }

}
