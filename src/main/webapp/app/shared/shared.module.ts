import { NgModule } from '@angular/core';
import { FilmGoSharedLibsModule } from './shared-libs.module';
import { AlertComponent } from './alert/alert.component';
import { AlertErrorComponent } from './alert/alert-error.component';
import { LoginModalComponent } from './login/login.component';
import { HasAnyAuthorityDirective } from './auth/has-any-authority.directive';
import { DateformatterPipe } from './dateformatter.pipe';
import { LowercasePipe } from 'app/shared/lowercase.pipe';

@NgModule({
  imports: [FilmGoSharedLibsModule],
  declarations: [AlertComponent, AlertErrorComponent, LoginModalComponent, HasAnyAuthorityDirective, DateformatterPipe, LowercasePipe],
  entryComponents: [LoginModalComponent],
  exports: [
    FilmGoSharedLibsModule,
    AlertComponent,
    AlertErrorComponent,
    LoginModalComponent,
    HasAnyAuthorityDirective,
    DateformatterPipe,
    LowercasePipe,
  ],
})
export class FilmGoSharedModule {}
