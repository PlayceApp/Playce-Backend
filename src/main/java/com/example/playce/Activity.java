import java.util.List;

public class Activity {

    private final String name;
    private final int price;
    private final double rating;
    private final List<String> categories;
    
    public class Activity(
            final String name,
            final int price,
            final double rating,
            final List<String> categories) {
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.categories = categories;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public double getRating() {
        return rating;
    }

    public boolean isInCategory(String category) {
        return categories.contains(category);
    }
}
