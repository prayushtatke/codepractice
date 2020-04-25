import java.util.*;

public class Test {

    public static void main(String args[]) throws Exception {
//   linkedHashMapAsLRU();

        try {
            int c = 1/0;
        } catch (Exception e) {
            System.out.println("E");
        } finally {
            System.out.println("F");
        }
    }


    public static int versionCompare(String v1, String v2) {
        if ( v1 == null && v2 != null )
        return -1;

        if ( v1 != null && v2 == null )
            return 1;

        if (v1 == null && v2 == null )
            throw new RuntimeException("No versions to compare");

        if (v1.equals(v2))
            return 0;

        String [] sa1 = v1.split("\\.");
        String [] sa2 = v2.split("\\.");

        int max = Math.max(sa1.length, sa2.length);
        for (int i = 0 ; i < max; i++) {
            int i1 = Integer.valueOf(sa1[i]);
            int i2 = Integer.valueOf(sa2[i]);

            if ( i1 > i2 )
                return 1;

            if ( i1 < i2 )
                return -1;
        }
        return 0;

    }
    public static boolean isPrime(int n) {
        return n == 0 || n == 1 ? false
                : ! java.util.stream.IntStream.rangeClosed(2, n/2).anyMatch(i -> n % i == 0 );
    }

    /**
     *
     * https://briangordon.github.io/2014/09/covariance-and-contravariance.html
     * https://www.javaworld.com/article/3172592/java-language/type-dependency-in-java-part-1.html
     */
    public static void coContraVariancetest() {
        class Super {
            Object doSomething(Object p) {
                System.out.println("Super.doSomething");
                return  null;
            }
        }

        class Sub extends Super {
            @Override
            String doSomething(Object p){
                System.out.println("Sub.doSomething");
                return null;
            }
        }        Super sup = new Super();
        Sub sub = new Sub();
        sup = (Super)sub; // OK (Up-Cast)

        // TODO: here it is supposed to give error but it is not
        // https://briangordon.github.io/2014/09/covariance-and-contravariance.html
        Sub sub2 = (Sub) sup;

        Super[] suparr = new Super[3];
        suparr[0] = new Sub(); // Arrays covariant in type they hold.
        Super[] suparr2 = new Sub[3];
        suparr2[0] = new Sub();

        // generics
//        Unless bounds are involved, generic types are invariant with respect to the parameterized type. So you can’t do covariant ArrayLists like this:
        // List<Super> s = new ArrayList<Sub>(); //  error
        List<? extends Super> s = new ArrayList<Sub>(); //  ok

    }
    private static void change(int x){
        x = x /2 ;
        System.out.println("Test.change "+x);
    }

    private static void linkedHashMapAsLRU() {
        int CAPACITY = 2;
        LinkedHashMap<Integer,String> lru = new LinkedHashMap<>(CAPACITY) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                System.out.println("Test.removeEldestEntry, size:"+size()+", capacity:"+CAPACITY+", Head: "+eldest.getKey());
                return size() > CAPACITY ? true : false;
            }
        };
        lru.put(0,"zero" );
        System.out.println(lru);
        lru.put(1,"one" );
        System.out.println(lru);
        lru.put(2,"two" );
        System.out.println(lru);
        lru.put(3,"three" );
        System.out.println(lru);
    }

    private  static void minHeapTest() {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>( );
        Random random = new Random();
        Iterator<Integer> nxtInt = random.ints(1, 50).iterator();
//        int [] arr = new int[50];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 20; i++)
            set.add(nxtInt.next());

        System.out.println(set);
        for( int a : set)
            minHeap.add(a);

        System.out.println(minHeap);
    }

    private static Integer remap(Integer key,Integer val) {
        System.out.println(key +", "+val);
        return val + 1;
    }

    //        ExecutorService executorService = Executors.newFixedThreadPool(5);
//        IntStream.range(0,100).forEach(i -> executorService.submit(() -> display(i)));
//    public static void display(int i) {
//        System.out.println(Thread.currentThread().getName()+ ": " +i);
//    }

}
