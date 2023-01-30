package be.technifutur.java.timairport.demo;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.METHOD})
// indique jusque quand la retention va exister:
// SOURCE   crée du code puis disparait
// RUNTIME  tout le temps
// COMPILE
@Retention(RetentionPolicy.SOURCE)
public @interface DemoAnnotation {

}
