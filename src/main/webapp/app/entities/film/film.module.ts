import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { FilmGoSharedModule } from 'app/shared/shared.module';
import { FilmComponent } from './film.component';
import { FilmDetailComponent } from './film-detail.component';
import { FilmUpdateComponent } from './film-update.component';
import { FilmDeleteDialogComponent } from './film-delete-dialog.component';
import { filmRoute } from './film.route';

@NgModule({
  imports: [FilmGoSharedModule, RouterModule.forChild(filmRoute)],
  declarations: [FilmComponent, FilmDetailComponent, FilmUpdateComponent, FilmDeleteDialogComponent],
  entryComponents: [FilmDeleteDialogComponent],
})
export class FilmGoFilmModule {}
