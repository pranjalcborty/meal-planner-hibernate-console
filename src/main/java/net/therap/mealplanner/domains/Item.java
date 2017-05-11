package net.therap.mealplanner.domains;

/**
 * @author pranjal.chakraborty
 * @since 5/10/17
 */
public class Item {

    @Id
    @Column(name = "item_id")
    private int id;

    @Column(name = "item_name")
    private String name;

    public Item(int id, String name) {
        this.id = id;
        this.name = name;
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
}
