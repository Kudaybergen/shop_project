public class test {
    public static void main(String[] args) {
        for(int i = 0; i < 100; ++i){
            int price = i * 1000;
            System.out.println(Character.toString(65)); // A
            System.out.println(Character.toString(65 + 25)); // Z

            System.out.println(Character.toString(97)); // a
            System.out.println(Character.toString(97 + 25)); // z
        }

        for(int i = 65; i <= 97+25; ++i){
            if(!(65+25 < i && i < 97)){
                int id = i;
                int price = i * 1000;
                String artikul = "artikul" + Character.toString(i);
                String descr = "descr" + Character.toString(i);
                String file = null;
                String mesure = null;
                String name = "name" + Character.toString(i);
            }
        }
    }
}
