import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import './vendor';
import { FilmGoSharedModule } from 'app/shared/shared.module';
import { FilmGoCoreModule } from 'app/core/core.module';
import { FilmGoAppRoutingModule } from './app-routing.module';
import { FilmGoHomeModule } from './home/home.module';
import { FilmGoEntityModule } from './entities/entity.module';
// jhipster-needle-angular-add-module-import JHipster will add new module here
import { MainComponent } from './layouts/main/main.component';
import { NavbarComponent } from './layouts/navbar/navbar.component';
import { FooterComponent } from './layouts/footer/footer.component';
import { PageRibbonComponent } from './layouts/profiles/page-ribbon.component';
import { ErrorComponent } from './layouts/error/error.component';

@NgModule({
  imports: [
    BrowserModule,
    FilmGoSharedModule,
    FilmGoCoreModule,
    FilmGoHomeModule,
    // jhipster-needle-angular-add-module JHipster will add new module here
    FilmGoEntityModule,
    FilmGoAppRoutingModule,
  ],
  declarations: [MainComponent, NavbarComponent, ErrorComponent, PageRibbonComponent, FooterComponent],
  bootstrap: [MainComponent],
})
export class FilmGoAppModule {}
