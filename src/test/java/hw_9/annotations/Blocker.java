package hw_9.annotations;

import org.junit.jupiter.api.Tag;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)//Эту анатацию сможет прочитать джеюнит в рантайм
@Target(ElementType.METHOD)//Эту анатацию можно ставить над методом
@Tag("BLOCKER")//Пишем название своей анатации
public @interface Blocker {
}
