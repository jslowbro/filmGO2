import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { FilmGoTestModule } from '../../../test.module';
import { FilmDetailComponent } from 'app/entities/film/film-detail.component';
import { Film } from 'app/shared/model/film.model';

describe('Component Tests', () => {
  describe('Film Management Detail Component', () => {
    let comp: FilmDetailComponent;
    let fixture: ComponentFixture<FilmDetailComponent>;
    const route = ({ data: of({ film: new Film(123) }) } as any) as ActivatedRoute;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [FilmGoTestModule],
        declarations: [FilmDetailComponent],
        providers: [{ provide: ActivatedRoute, useValue: route }],
      })
        .overrideTemplate(FilmDetailComponent, '')
        .compileComponents();
      fixture = TestBed.createComponent(FilmDetailComponent);
      comp = fixture.componentInstance;
    });

    describe('OnInit', () => {
      it('Should load film on init', () => {
        // WHEN
        comp.ngOnInit();

        // THEN
        expect(comp.film).toEqual(jasmine.objectContaining({ id: 123 }));
      });
    });
  });
});
