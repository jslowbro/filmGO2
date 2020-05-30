import { Pipe, PipeTransform } from '@angular/core';
import { Moment } from 'moment';

@Pipe({
  name: 'dateformatter',
})
export class DateformatterPipe implements PipeTransform {
  transform(value: Moment | undefined | null): string {
    if (value === undefined || value === null) {
      return '';
    }
    return value.format('YYYY/MM/DD');
  }
}
