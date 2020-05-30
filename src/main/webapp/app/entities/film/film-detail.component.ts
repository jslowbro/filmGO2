import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { FilmService } from 'app/entities/film/film.service';
import { IFilmWithRatings } from 'app/shared/model/filmwithratings.model';
import { HttpResponse } from '@angular/common/http';

@Component({
  selector: 'jhi-film-detail',
  templateUrl: './film-detail.component.html',
})
export class FilmDetailComponent implements OnInit {
  film: IFilmWithRatings | null = null;

  constructor(protected activatedRoute: ActivatedRoute, protected filmService: FilmService) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ film }) => {
      this.filmService.findWithRatings(film.id, true).subscribe((res: HttpResponse<IFilmWithRatings>) => (this.film = res.body || null));
    });
    //    this.filmService.query().subscribe((res: HttpResponse<IFilm[]>) => (this.films = res.body || []));
  }

  previousState(): void {
    window.history.back();
  }

  test(): void {
    console.log(this.film);
  }
}
