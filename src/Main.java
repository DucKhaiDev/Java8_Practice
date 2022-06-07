import java.time.LocalDateTime;
import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

class Hosting {
    private int id;
    private String name;
    private long websites;

    public Hosting(int id, String name, long websites) {
        this.id = id;
        this.name = name;
        this.websites = websites;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getWebsites() {
        return websites;
    }

    public void setWebsites(long websites) {
        this.websites = websites;
    }
}

public class Main {
    public static void main(String[] args) {
        //UnaryOperator
        UnaryOperator<String> unaryOperator = String::toUpperCase;
        System.out.println(unaryOperator.apply("abc"));

        //BinaryOperator
        BinaryOperator<Double> binaryOperator = Math::pow;
        System.out.println(binaryOperator.apply(2.0, 3.0));

        //Function
        Function<Integer, String> function = Integer::toBinaryString;
        System.out.println(function.apply(10));

        //Predicate
        Predicate<Character> predicate = Character::isDigit;
        System.out.println(predicate.test('3'));

        //Supplier
        Supplier<LocalDateTime> supplier = LocalDateTime::now;
        System.out.println(supplier.get());

        //Consumer
        Consumer<String> consumer = System.out::println;
        consumer.accept("Kai");

        //forEach
        List<String> list = Arrays.asList("Do", "Duc", "Khai");
        list.forEach(element -> System.out.print(element + " "));
        System.out.println();

        //List to Map
        List<Hosting> hostings = Arrays.asList(
                new Hosting(1, "liquidweb.com", 80000),
                new Hosting(2, "linode.com", 90000),
                new Hosting(3, "digitalocean.com", 120000),
                new Hosting(4, "aws.amazon.com", 200000),
                new Hosting(5, "mkyong", 1),
                new Hosting(6, "linode.com", 100000)
        );

        Map<String, Long> map = hostings.stream().collect(
                Collectors.toMap(
                    Hosting::getName,
                    Hosting::getWebsites,
                    (oldValue, newValue) -> newValue,
                    LinkedHashMap::new
                )
        );

        System.out.println(map);

        //Array to List
        Hosting[] hosting = {
                new Hosting(1, "liquidweb.com", 80000),
                new Hosting(2, "linode.com", 90000),
                new Hosting(3, "digitalocean.com", 120000),
                new Hosting(4, "aws.amazon.com", 200000),
                new Hosting(5, "mkyong", 1),
                new Hosting(6, "linode.com", 100000)
        };

        List<Hosting> hostingList = Arrays.stream(hosting).collect(Collectors.toList());
        System.out.println(hostingList);

        Set<String> set = new HashSet<>(Arrays.asList(null, null, "haha"));
        System.out.println(set);
    }
}
