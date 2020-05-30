import { Injectable } from '@angular/core';
import { HttpClient, HttpParams, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import * as moment from 'moment';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared/util/request-util';
import { IFilm } from 'app/shared/model/film.model';
import { IFilmWithRatings } from 'app/shared/model/filmwithratings.model';

type EntityResponseType = HttpResponse<IFilmWithRatings | IFilm>;
type EntityArrayResponseType = HttpResponse<IFilmWithRatings[] | IFilm[]>;

@Injectable({ providedIn: 'root' })
export class FilmService {
  public resourceUrl = SERVER_API_URL + 'api/films';

  constructor(protected http: HttpClient) {}

  create(film: IFilm): Observable<EntityResponseType> {
    const copy = this.convertDateFromClient(film);
    return this.http
      .post<IFilm>(this.resourceUrl, copy, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  update(film: IFilm): Observable<EntityResponseType> {
    const copy = this.convertDateFromClient(film);
    return this.http
      .put<IFilm>(this.resourceUrl, copy, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  find(id: number): Observable<EntityResponseType> {
    return this.http
      .get<IFilm>(`${this.resourceUrl}/${id}`, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  findWithRatings(id: number, rating: boolean): Observable<EntityResponseType> {
    const httpParams = new HttpParams().set('rating', String(rating));
    return this.http
      .get<IFilmWithRatings>(`${this.resourceUrl}/${id}`, { params: httpParams, observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http
      .get<IFilm[]>(this.resourceUrl, { params: options, observe: 'response' })
      .pipe(map((res: EntityArrayResponseType) => this.convertDateArrayFromServer(res)));
  }

  findByPersonId(personId: number): Observable<EntityArrayResponseType> {
    const httpParams = new HttpParams();
    httpParams.append('personId', String(personId));
    return this.http.get<IFilm[]>(this.resourceUrl, { params: httpParams, observe: 'response' });
  }

  delete(id: number): Observable<HttpResponse<{}>> {
    return this.http.delete(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  protected convertDateFromClient(film: IFilm): IFilm {
    const copy: IFilm = Object.assign({}, film, {
      releaseDate: film.releaseDate && film.releaseDate.isValid() ? film.releaseDate.toJSON() : undefined,
    });
    return copy;
  }

  protected convertDateFromServer(res: EntityResponseType): EntityResponseType {
    if (res.body) {
      res.body.releaseDate = res.body.releaseDate ? moment(res.body.releaseDate) : undefined;
    }
    return res;
  }

  protected convertDateArrayFromServer(res: EntityArrayResponseType): EntityArrayResponseType {
    if (res.body) {
      res.body.forEach((film: IFilm) => {
        film.releaseDate = film.releaseDate ? moment(film.releaseDate) : undefined;
      });
    }
    return res;
  }
}
