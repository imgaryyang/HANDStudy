## Java基础(深入了解概念为主)
### 匿名类

#### 定义
Java匿名类很像局部或内联系，只是没有明细。我们可以利用匿名类，同时定义并实例化一个类。只有局部类仅被使用一次时才应该这么做。

匿名类不能有显式定义的构造函数，相反，每一个匿名类都隐含定义了一个匿名构造函数

#### 创建匿名类
`理解代码的最好方法就是先阅读，所以我们首先来看看代码。`
- 扩展已有的类(可以是抽象类，也可以是具体类)

- 创建接口

```
interface Football {
    void kick();
}


class AnnonymousClass {
	public static Football football = new Football() {
        @Override
        public void kick() {
            System.out.println("Nested Anonymous Class.");
        }
    };
    public static void main(String[] args)
    {
        // anomynous class inside the method
      Football footballObject = new Football()
      {
          @Override
         public void kick()
          {
              System.out.println("Anonymous Class");
          }
      };
      footballObject.kick();

        AnnonymousClass.football.kick();
    } 
}
```

匿名类可以在类和函数代码块中中创建。匿名类可以用接口来创建，也可以通过扩展抽象或具体的类来创建。上面的例子中先创建了一个接口Football，然后在类的作用域和main()  方法内实现了匿名类。Football也可以是抽象类，也可以是与interface并列的顶层类。

`Football可以是抽象类，请看下面的代码。`
```
public abstract class Football { 
    abstract void kick();
}
```

`匿名类不仅可以是抽象类,还可以是具体类`

```
// normal or concrete class
public class Football {        
	public void kick(){}
}
// end of class scope.
```

如果Football类没有不带参数的构造方法怎么办？我们可以在匿名类中访问类变量吗？我们需要在匿名类中重载所有方法吗？

```
// normal or concrete class
public class Football {
    protected int score;

    public Football(int score) {
        this.score = score;
    }
    public void score(){
        System.out.println("Score "+score);
    };
    public void kick(){}
    public static void main(String[] args) {
        Football football = new Football(7){
            @Override
            public void score() {
                System.out.println("Anonymous class inside the method "+score);
            }

        };
        football.score();
    }
}
// end of class scope.
```

- 创建匿名类时可以使用任何构造方法。注意这里也使用构造方法的参数
- 匿名类可以扩展顶层类，并实现抽象类或接口。所以，访问控制的规则依然适用。我们可以访问protected变量，而改成private就不能访问了。
- 由于上述代码中扩展了Football类，我们需要重载所有的方法。但是，如果它是个抽象类或者接口，那么必须为所有未实现的方法提供实现。
- 匿名类中不能定义静态初始方法或成员接口。
- 匿名类可以有静态成员变量，但它们必须是常量


#### 匿名类的用途
- `更清晰的项目结构`：通常我们在需要随时改变某个类的某些方法的实现时使用匿名类。这样做就不需要在项目中添加新的 *.java 文件来定义顶层类了。特别是在顶层类之只被使用一次时，这种方法非常好用。
- `UI事件监听器`：在图形界面的应用程序中，匿名类最常见的用途就是创建各种事件处理器。


我们创建了一个匿名类，实现了setOnClickListener接口。当用户点击按钮时会触发它的onClick方法。
```
button.setOnClickListener(new View.OnClickListener() {
    public void onClick(View v) {
        // your handler code here
    }
});
```

### 多线程

Java中的多线程能够同时执行多个线程。线程是轻量级的子进程，也是处理的最小单位。使用多线程的主要目的是最大化CPU的使用率。我们使用多线程而不是多进程，因为线程更轻量化，也可以共享一个进程内的内存空间。多线程用来实现多任务。