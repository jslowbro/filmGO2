import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { FilmService } from 'app/entities/film/film.service';
import { IFilmWithRatings } from 'app/shared/model/filmwithratings.model';
import { HttpResponse } from '@angular/common/http';
import { IReview, Review } from 'app/shared/model/review.model';
import { ReviewService } from 'app/entities/review/review.service';
import { PersonContainerService } from 'app/entities/person-container/person-container.service';
import { IRoleList } from 'app/shared/model/person-container.model';
import { AccountService } from 'app/core/auth/account.service';
import { RatingService } from 'app/entities/rating/rating.service';
import { IRating, Rating } from 'app/shared/model/rating.model';

@Component({
  selector: 'jhi-film-detail',
  templateUrl: './film-detail.component.html',
})
export class FilmDetailComponent implements OnInit {
  film: IFilmWithRatings | null = null;
  reviews: IReview[] | null = null;
  roleListings: IRoleList[] | null = null;
  reviewTitle = '';
  reviewText = '';
  reviewValue: number | undefined = undefined;

  constructor(
    protected activatedRoute: ActivatedRoute,
    protected filmService: FilmService,
    protected reviewService: ReviewService,
    protected personContainerService: PersonContainerService,
    protected accountService: AccountService,
    protected ratingService: RatingService
  ) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ film }) => {
      this.filmService.findWithRatings(film.id, true).subscribe((res: HttpResponse<IFilmWithRatings>) => (this.film = res.body || null));
      this.reviewService.findByFilmId(film.id).subscribe((res: HttpResponse<IReview[]>) => (this.reviews = res.body || null));
      this.personContainerService
        .findRoleListForFilm(film.id)
        .subscribe((res: HttpResponse<IRoleList[]>) => (this.roleListings = res.body || null));
    });
  }

  previousState(): void {
    window.history.back();
  }

  test(): void {
    console.log(this.film);
    console.log(this.film?.releaseDate?.format('YYYY/MM/DD'));
    console.log(this.reviews);
    console.log(this.roleListings);
  }

  getStarsForReview(review: IReview): number[] {
    return Array(review.value).fill(0);
  }
  addRating(value: number): void {
    this.accountService.identity(true).subscribe(account => {
      if (account !== null) {
        const rating = new Rating(undefined, value, this.film?.id, account.login, undefined);
        this.ratingService.create(rating).subscribe((response: HttpResponse<IRating>) => {
          console.log(response.body);
        });
      }
    });
  }
  addReview(): void {
    this.accountService.identity(true).subscribe(account => {
      if (account !== null) {
        const review = new Review(undefined, this.reviewTitle, this.reviewText, this.reviewValue, this.film?.id, account.login, undefined);
        console.log(review);
        this.reviewService.create(review).subscribe((res: HttpResponse<IReview>) => console.log(res.body));
      }
    });
  }

  setReviewRating(value: number): void {
    this.reviewValue = value;
    console.log(this.reviewValue);
  }
}
