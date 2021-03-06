package by.stqa.pft.lesson1;

/**
 * Created by artemr on 2/16/2017.
 */
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ExcelDataSource {
  String sheetname() default "";
  String value();
}