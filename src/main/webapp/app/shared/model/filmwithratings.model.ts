import { Moment } from 'moment';
import { Film, IFilm } from 'app/shared/model/film.model';

export interface IFilmWithRatings extends IFilm {
  id?: number;
  title?: string;
  description?: string;
  releaseDate?: Moment;
  audienceRating?: number;
  criticsRating?: number;
}

export class FilmWithRatings extends Film implements IFilmWithRatings {
  constructor(
    public id?: number,
    public title?: string,
    public description?: string,
    public releaseDate?: Moment,
    public audienceRating?: number,
    public criticsRating?: number
  ) {
    super(id, title, description, releaseDate);
    this.audienceRating = audienceRating;
    this.criticsRating = criticsRating;
  }
}
