package net.therap.mealplanner.helper;

import net.therap.mealplanner.dao.ItemDao;
import net.therap.mealplanner.dao.MealDao;
import net.therap.mealplanner.domains.Item;
import net.therap.mealplanner.domains.Meal;
import net.therap.mealplanner.enums.Day;
import net.therap.mealplanner.enums.Type;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * @author pranjal.chakraborty
 * @since 5/10/17
 */
public class MealHelper {

    private static final String MSG1 = "*********Meal planner*********\n";
    private static final String MSG2 = "1\t See current meal plan\n";
    private static final String MSG3 = "2\t View current items\n";
    private static final String MSG4 = "3\t Create custom meal plan\n";
    private static final String MSG5 = "4\t Add item\n";
    private static final String MSG6 = "Insert item name";
    private static final String MSG7 = "Desired day...";
    private static final String MSG8 = "Desired type...";
    private static final String MSG9 = "Currently available items...";
    private static final String MSG10 = "Enter desired food ids, separated by space";
    private static final String SPACE = " ";
    private static final String TAB = "\t ";
    private static final String COMMA = ", ";

    private MealDao mealDao;
    private ItemDao itemDao;

    public MealHelper() {
        mealDao = new MealDao();
        itemDao = new ItemDao();
    }

    public Day daySelect() {
        Iterator iterator = Helper.getDayMap().entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry pair = (Map.Entry) iterator.next();
            System.out.println(pair.getKey() + " = " + pair.getValue());
        }
        int daySelected = Integer.parseInt(new Scanner(System.in).nextLine());

        return Helper.getDay(daySelected);
    }

    public Type typeSelect() {
        Iterator iterator = Helper.getTypeMap().entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry pair = (Map.Entry) iterator.next();
            System.out.println(pair.getKey() + " = " + pair.getValue());
        }
        int typeSelected = Integer.parseInt(new Scanner(System.in).nextLine());

        return Helper.getType(typeSelected);
    }

    public void welcomeMessage() {
        System.out.println(MSG1 + MSG2 + MSG3 + MSG4 + MSG5);
    }

    public void showMealPlans() throws SQLException {
        for (Meal meal : mealDao.getMeals()) {
            System.out.print(meal.getDay() + TAB + meal.getType() + TAB);
            printItems(meal.getItems());
        }
    }

    public void addPlan() throws SQLException {
        System.out.println(MSG7);
        Day day = daySelect();
        System.out.println(MSG8);
        Type type = typeSelect();
        System.out.println(MSG9);
        showMenuItems();
        System.out.println(MSG10);

        List<Item> items = itemDao.getItems(new Scanner(System.in).nextLine().split(SPACE));

        mealDao.addItemsToMeal(day, type, items);
    }

    public void addItem() throws SQLException {
        System.out.println(MSG6);
        itemDao.addItem(new Scanner(System.in).nextLine());
    }

    public void showItems() throws SQLException {
        List<Item> items = itemDao.generateItems();
        System.out.println("********************");
        for (Item item : items) {
            System.out.println(item.getName());
        }
    }

    public void showMenuItems() throws SQLException {
        List<Item> items = itemDao.generateItems();
        System.out.println("********************");
        for (Item item : items) {
            System.out.println(item.getId() + TAB + item.getName());
        }
    }

    public void printItems(List<Item> items) {
        for (Item item : items) {
            System.out.print(item.getName() + COMMA);
        }
        if (items.size() == 0) {
            System.out.println("No records");
        }
        System.out.println();
    }

    public void invalidMessage() {
        System.out.println("Invalid input. Please try again.");
    }
}
