import { Directive, ElementRef, HostListener } from '@angular/core';

@Directive({
  selector: '[appHoverColor]'
})
export class HoverColorDirective {

  constructor(private element : ElementRef) { } // ElementRef est la balise récupérée (html.getElementById)

  @HostListener('mouseenter')
  onMouseEnter(){
    this.element.nativeElement.style.backgroundColor = 'chartreuse';
  }

  @HostListener('mouseleave')
  onMouseLeave(){
    this.element.nativeElement.style.backgroundColor = null;
  }

}
