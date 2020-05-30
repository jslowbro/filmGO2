import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IPerson } from 'app/shared/model/person.model';
import { FilmService } from 'app/entities/film/film.service';
import { IFilm } from 'app/shared/model/film.model';
import { HttpResponse } from '@angular/common/http';

@Component({
  selector: 'jhi-person-detail',
  templateUrl: './person-detail.component.html',
})
export class PersonDetailComponent implements OnInit {
  person: IPerson | null = null;
  films: IFilm[] | null = null;

  constructor(protected activatedRoute: ActivatedRoute, protected filmService: FilmService) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ person }) => {
      this.person = person;
      this.filmService.findByPersonId(person.id).subscribe((res: HttpResponse<IFilm[]>) => (this.films = res.body || null));
    });
  }

  previousState(): void {
    window.history.back();
  }

  test(): void {
    console.log(this.films);
  }
}
