package net.therap.mealplanner.dao;

import net.therap.mealplanner.domains.Item;
import net.therap.mealplanner.helper.Helper;
import net.therap.mealplanner.helper.HibernateHelper;
import org.hibernate.Session;

import org.hibernate.Query;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author pranjal.chakraborty
 * @since 5/11/17
 */
public class ItemDao {

    public void addItem(String itemName) throws SQLException {
        Item item = new Item();
        item.setName(itemName);

        Session session = HibernateHelper.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(item);
        session.getTransaction().commit();
        session.close();
    }

    public List<Item> generateItems() throws SQLException {
        Session session = HibernateHelper.getSessionFactory().openSession();
        Query query = session.createQuery("from Item ");

        List<Item> items = query.list();
        session.close();
        return items;
    }

    public List<Item> getItems(String [] tokens){
        List<Item> items = new ArrayList<>();

        for(String token: tokens){
            Session session = HibernateHelper.getSessionFactory().openSession();
            items.add ((Item) session.get(Item.class, Long.parseLong(token)));
        }
        return items;
    }
}
