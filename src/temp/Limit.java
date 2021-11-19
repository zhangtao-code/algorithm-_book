package temp;

import java.util.List;

public interface  Limit<T> {
     List<UseType>  getUseFiled();
     String getPackage();
     String getTip(T t);
     String name();
}
