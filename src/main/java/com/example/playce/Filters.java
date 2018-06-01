public class Filters {

    private final String category;
    private final String occasion;
    private final double money;
    private final int age;

    public Filters(
            final String category,
            final String occasion,
            final double money,
            final int age) {
        this.category = category;
        this.occasion = occasion;
        this.money = money;
        this.age = age;
    }

    public getCategory() {
        return category;
    }

    public getOccasion() {
        return occasion;
    }

    public getMoney() {
        return money;
    }

    public getAge() {
        return age;
    }
}
