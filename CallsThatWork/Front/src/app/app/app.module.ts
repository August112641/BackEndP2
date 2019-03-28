import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule, HttpClient } from '@angular/common/http'; 

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TrackComponentComponent } from './track-component/track-component.component';
import { NewplaylistComponent } from './newplaylist/newplaylist.component';



@NgModule({
  declarations: [
    AppComponent,
    TrackComponentComponent,
    NewplaylistComponent
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
