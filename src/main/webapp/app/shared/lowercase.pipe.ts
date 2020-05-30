import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'lowercase',
})
export class LowercasePipe implements PipeTransform {
  transform(value: string | undefined | null): string {
    if (value === undefined || value === null) {
      return '';
    }
    return value.charAt(0).toUpperCase() + value.slice(1, value.length).toLowerCase();
  }
}
