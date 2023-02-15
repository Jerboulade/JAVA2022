import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'chrono'
})
export class ChronoPipe implements PipeTransform {

  transform(value: number): string {
    return `${Math.floor(value / 60)} minute(s) ${value % 60} seconde(s)`
  }

}
