//: generics/NonCovariantGenerics.java
// {CompileTimeError} (Won't compile)
package generics;

import java.util.ArrayList;
import java.util.List;

public class NonCovariantGenerics {

    // Compile Error: incompatible types:
    // List<Fruit> flist = new ArrayLIst<Apple>();
    List<Fruit> flist = new ArrayList<>();
}
