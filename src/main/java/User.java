import sun.misc.Contended;

import java.io.Serializable;

public class User implements Serializable {

    static  final long serialVersionUID = 6423105896338122262L;

    private String name ="zs";
    @Contended
    private int age = 18;

    private String emial ="123";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
