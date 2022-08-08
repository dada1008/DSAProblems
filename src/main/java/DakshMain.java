public class DakshMain {

    public static void main(String[] args) {
        long val = 10_000;
        int loop = 5;
        for (int i = 1; i < loop; i++) {
            val+=10_000;
        }
        System.out.println("Result:"+val);

    }
}

