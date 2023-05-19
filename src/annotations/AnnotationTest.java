package annotations;

import java.lang.annotation.*;

public class AnnotationTest {
    public static void main(String[] args) {
        Class iphoneClass = Iphone.class;
        SmartPhone smartPhone = (SmartPhone) iphoneClass.getAnnotation(SmartPhone.class);
        System.out.println("Annotation info from Iphone class: "
                + smartPhone.os()
                + " , "
                + smartPhone.yearOfCompanyCreation());
    }
}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface SmartPhone{
    String os() default "Android";
    int yearOfCompanyCreation();
}

@SmartPhone(os = "iOS", yearOfCompanyCreation = 1976)
class Iphone{
    String name;
    String price;
}
