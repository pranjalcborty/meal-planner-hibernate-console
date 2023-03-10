package net.therap.mealplanner.domains;

import javax.persistence.*;

/**
 * @author pranjal.chakraborty
 * @since 5/10/17
 */
@Entity
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id", unique = true, nullable = false)
    private long id;

    @Column(name = "item_name")
    private String name;


    public long getId() {
        return id;
    }

    public void setId(long item_id) {
        this.id = item_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
