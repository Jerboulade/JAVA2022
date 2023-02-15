import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'temp'
})
export class TempPipe implements PipeTransform {

//il faut declarer les pipes dans les modules pour pouvoir s'en servir

  transform(value: number, inUnity : string, outUnity  : string): number {
    if (inUnity === 'c'){
      if (outUnity === 'k')
        return value + 273.15
      else if (outUnity === 'c')
        return value
    }
    else if (inUnity === 'k'){
      if (outUnity === 'c')
        return value - 273.15
      else if (outUnity === 'k')
        return value
    }
    return 0;
  }

}
