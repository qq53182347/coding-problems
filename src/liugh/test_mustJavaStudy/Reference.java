package liugh.test_mustJavaStudy;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
/*对于强引用，我们平时在编写代码时经常会用到。而对于其他三种类型的引用，使用得最多的就是软引用和弱引用.
假如有一个应用需要读取大量的本地图片，如果每次读取图片都从硬盘读取，则会严重影响性能，
但是如果全部加载到内存当中，又有可能造成内存溢出，此时使用软引用可以解决这个问题。

设计思路是：用一个HashMap来保存图片的路径 和 相应图片对象关联的软引用之间的映射关系，
在内存不足时，JVM会自动回收这些缓存图片对象所占用的空间，
从而有效地避免了OOM的问题。在Android开发中对于大量图片下载会经常用到。
*/
public class Reference {
	public static void main(String[] args) {
        new Reference().fun2();
    }
	/*强引用
	 当运行至Object[] objArr = new Object[1000];这句时，如果内存不足，
	 JVM会抛出OOM错误也不会回收object指向的对象。不过要注意的是，当fun1运行完之后，
	 object和objArr都已经不存在了，所以它们指向的对象都会被JVM回收。
	 
	  如果想中断强引用和某个对象之间的关联，可以显示地将引用赋值为null，这样一来的话，
	 JVM在合适的时间就会回收该对象。*/
    public void fun1() {
        Object object = new Object();
        Object[] objArr = new Object[1000];
    }
    
    
    /*软引用
           软引用是用来描述一些有用但并不是必需的对象，在Java中用java.lang.ref.SoftReference类来表示。
           对于软引用关联着的对象，只有在内存不足的时候JVM才会回收该对象。
           因此，这一点可以很好地用来解决OOM的问题，并且这个特性很适合用来实现缓存：比如网页缓存、图片缓存等。*/
    public void fun2() {
    	/*软引用可以和一个引用队列（ReferenceQueue）联合使用，
    	如果软引用所引用的对象被JVM回收，这个软引用就会被加入到与之关联的引用队列中。*/
    	SoftReference<String> sr = new SoftReference<String>(new String("hello"));
        System.out.println(sr.get());
        System.gc();  
        System.out.println(sr.get());
    }
    
    
    
   /* 弱引用（WeakReference）

  　　弱引用也是用来描述非必需对象的，当JVM进行垃圾回收时，无论内存是否充足，
         都会回收被弱引用关联的对象。在java中，用java.lang.ref.WeakReference类来表示。*/
    public void fun3() {
    	/*第二个输出结果是null，这说明只要JVM进行垃圾回收，被弱引用关联的对象必定会被回收掉。
    	 不过要注意的是，这里所说的被弱引用关联的对象是指只有弱引用与之关联，
    	 如果存在强引用同时与之关联，则进行垃圾回收时也不会回收该对象（软引用也是如此）。

　　          弱引用可以和一个引用队列（ReferenceQueue）联合使用，如果弱引用所引用的对象被JVM回收，
               这个软引用就会被加入到与之关联的引用队列中。*/
    	WeakReference<String> sr = new WeakReference<String>(new String("hello"));
        System.out.println(sr.get());
        System.gc();                //通知JVM的gc进行垃圾回收
        System.out.println(sr.get());
    }
    
    public void fun4() {
    	/*第二个输出结果是null，这说明只要JVM进行垃圾回收，被弱引用关联的对象必定会被回收掉。
    	 不过要注意的是，这里所说的被弱引用关联的对象是指只有弱引用与之关联，
    	 如果存在强引用同时与之关联，则进行垃圾回收时也不会回收该对象（软引用也是如此）。

　　          弱引用可以和一个引用队列（ReferenceQueue）联合使用，如果弱引用所引用的对象被JVM回收，
               这个软引用就会被加入到与之关联的引用队列中。*/
    	ReferenceQueue<String> queue = new ReferenceQueue<String>();
        PhantomReference<String> pr = new PhantomReference<String>(new String("hello"), queue);
        System.out.println(pr.get());
    }
}
