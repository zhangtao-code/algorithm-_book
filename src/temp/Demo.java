package temp;

import java.util.List;

public class Demo extends AnnotationLimit<Override>{
    @Override
    public List<UseType> getUseFiled() {
        return null;
    }

    @Override
    public String getTip(Object o) {
        return null;
    }

    public static void main(String[]args){
        Demo demo=new Demo();
        System.out.println(demo.getPackage());
        System.out.println(demo.name());
    }
}
