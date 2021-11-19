package temp;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class AnnotationLimit<T extends Annotation> implements Limit{
    private Class annotationClass;

    public AnnotationLimit() {
        Class clazz=getClass();
        Type supertype=clazz.getGenericSuperclass();
        ParameterizedType parameterizedType = (ParameterizedType) supertype;
        annotationClass = (Class<? extends Annotation>) parameterizedType.getActualTypeArguments()[0];
    }

    @Override
    public String getPackage() {
        return annotationClass.getName();
    }

    @Override
    public String name() {
        return "@"+annotationClass.getSimpleName();
    }
}
