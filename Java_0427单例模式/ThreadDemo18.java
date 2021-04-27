package Java_0427单例模式;

public class ThreadDemo18 {
    //懒汉模式来实现，Singleton类被加载的时候，不会立刻实例化
    //等到第一次使用这个实例的时候再实例化
    static class Singleton{
        private Singleton(){

        }
        //加volatile保持内存可见性
        private  volatile static Singleton instance = null;

        /**
         * 类加载的时候，没有立即实例化
         * 第一次调用getInstance的时候，才真的实例化。
         * 如果要是代码一整场都没有调用getInstance
         * 此时实例化的过程也就被省略掉了
         *
         * "延时加载"
         *
         * 我们一般认为"懒汉模式"比"饿汉模式"效率更高
         * 懒汉模式有很大的可能是"实例用不到"，此时就节省了实例化的开销
         *
         */
        public static Singleton getInstance(){
            //懒汉模式是线程不安全的，这样加锁可以保证线程安全，或者加在当前方法之前
            //虽然两种写法都ok，认为写在里面的写法，粒度更小，写在方法之前，锁粒度更大
            //粒度：锁中包含的代码越多，就认为粒度越大
            //一般写代码的时候，都希望锁粒度小一点比较好
            //锁的粒度越大，说明这段代码的并发能力就越受限
            if (instance == null) {
                synchronized (Singleton.class) {
                    if(instance == null){
                        instance = new Singleton();
                    }
                }
            }
            return instance;
        }
    }
}
