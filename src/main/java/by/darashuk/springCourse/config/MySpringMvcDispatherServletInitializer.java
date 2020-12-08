package by.darashuk.springCourse.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//этот К. с ЭТИМ Абстракт К. дают возможность настройки нашего конфига
public class MySpringMvcDispatherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {//не используем
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {SpringConfig.class};//говорим где находятся настройки нашего приложения
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"}; //говорит что ВСЕ запросы отправлять на Dispather
    }
}
