package com.example.callbacklearn;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.callbacklearn.callbackjk.Ricky;
import com.example.callbacklearn.callbackjk.Teacher;
import com.example.callbacklearn.callbackjk.XuSheng;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = 26549;
                int b = 16487;
                /**
                 * 小明通过自身的callHelp方法调用了小红（new SuperCalculator()）的add方法，
                 * 在调用的时候将自身的引用（this）当做参数一并传入，小红在使用计算器得出结果之后，
                 * 回调了小明的fillBlank方法，将结果填在了黑板上的空格里。
                 */
                Student s = new Student("小明");
                s.callHelp(a, b);

                int c = 26497;
                int d = 11256;
                Seller s2 = new Seller("老婆婆");
                s2.callHelp(c, d);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 1）老师调用学生接口的方法resolveQuestion，向学生提问
                //（2）学生解决完毕问题之后调用老师的回调方法tellAnswer
                // 这样一套流程，构成了一种双向调用的关系。
                XuSheng xuSheng = new Ricky();
                Teacher teacher = new Teacher(xuSheng);
                teacher.askQuestion();
            }
        });
        /*
    （1）将老师进行抽象

    将老师进行抽象之后，对于学生来说，就不需要关心到底是哪位老师询问我问题，只要我根据询问的问题，得出答案，
    然后告诉提问的老师就可以了，即使老师换了一茬又一茬，对我学生而言都是没有任何影响的

    （2）将学生进行抽象

    将学生进行抽象之后，对于老师这边来说就非常灵活，因为老师未必对一个学生进行提问，可能同时对Ricky、Jack、Lucy
    三个学生进行提问，这样就可以将成员变量Student改为List<Student>，这样在提问的时候遍历Student列表进行提问，
    然后得到每个学生的回答即可

    这个例子是一个典型的体现接口作用的例子，之所以这么说是因为我想到有些朋友可能不太明白接口的好处，不太明白接口好处的朋友可以重点看一下这个例子，多多理解。

总结起来，回调的核心就是回调方将本身即this传递给调用方，这样调用方就可以在调用完毕之后告诉回调方它想要知道的信息。回调是一种思想、是一种机制，至于具体如何实现，如何通过代码将回调实现得优雅、实现得可扩展性比较高，一看开发者的个人水平，二看开发者对业务的理解程度。



同步回调与异步回调

上面的例子，可能有人会提出这样的疑问：

这个例子需要用什么回调啊，使用同步调用的方式，学生对象回答完毕问题之后直接把回答的答案返回给老师对象不就好了？

这个问题的提出没有任何问题，可以从两个角度去理解这个问题。

首先，老师不仅仅想要得到学生的答案怎么办？可能这个老师是个更喜欢听学生解题思路的老师，在得到学生的答案之前，老师更想先知道学生姓名和学生的解题思路，当然有些人可以说，那我可以定义一个对象，里面加上学生的姓名和解题思路不就好了。这个说法在我看来有两个问题：

（1）如果老师想要的数据越来越多，那么返回的对象得越来越大，而使用回调则可以进行数据分离，将一批数据放在回调方法中进行处理，至于哪些数据依具体业务而定，如果需要增加返回参数，直接在回调方法中增加即可

（2）无法解决老师希望得到学生姓名、学生解题思路先于学生回答的答案的问题

因此我认为简单的返回某个结果确实没有必要使用回调而可以直接使用同步调用，但是如果有多种数据需要处理且数据有主次之分，使用回调会是一种更加合适的选择，优先处理的数据放在回调方法中先处理掉。

另外一个理解的角度则更加重要，就是标题说的同步回调和异步回调了。例子是一个同步回调的例子，意思是老师向Ricky问问题，Ricky给出答案，老师问下一个同学，得到答案之后继续问下一个同学，这是一种正常的场景，但是如果我把场景改一下：

老师并不想One-By-One这样提问，而是同时向Ricky、Mike、Lucy、Bruce、Kate五位同学提问，让同学们自己思考，哪位同学思考好了就直接告诉老师答案即可。

这种场景相当于是说，同学思考完毕完毕问题要有一个办法告诉老师，有两个解决方案：

（1）使用Future+Callable的方式，等待异步线程执行结果，这相当于就是同步调用的一种变种，因为其本质还是方法返回一个结果，即学生的回答

（2）使用异步回调，同学回答完毕问题，调用回调接口方法告诉老师答案即可。由于老师对象被抽象成了Callback接口，因此这种做法的扩展性非常好，就像之前说的，即使老师换了换了一茬又一茬，对于同学来说，只关心的是调用Callback接口回传必要的信息即可
         */

    }
}
