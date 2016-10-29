package com.budgetmaster.budgetmaster;

/**
 * Created by scinerio on 10/28/2016
 * An Inquiry will be an object that edits the total budet
 * AKA an income OR expense
 */

public class Inquiry {

    /**
     * May be positive or negative depending on income or expense
     */
    private double amount;

    /**
     * The title of the Inquiry
     */
    private String title;

    /**
     * An optional field that may be used to describe the Inquiry
     */
    private String description;

    /**
     * Boolean to determine if the Inquiry will happen again
     */
    private boolean isReccurent;

    /**
     * An integer that will represent how many days will pass until the Inquiry reccurs
     */
    private int reccurence;

    /**
     * Creates an Inquiry object with null fields
     */
    public Inquiry() {
    }

    /**
     * Creates an Inquiry with specified fields
     * @param amt The amount, may be positive or negative
     * @param titl The title
     * @param desc The optional description
     * @param isRec True if the Inquiry repeats
     * @param rec The amount of days to pass to repeat
     */
    public Inquiry(double amt, String titl, String desc, boolean isRec, int rec) {
        amount = amt;
        title = titl;
        description = desc;
        isReccurent = isRec;
        reccurence = rec;
    }

    /**
     * Returns the title
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Changes the title
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Returns the amount of the Inquiry
     * @return amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Changes the amount of the Inquiry
     * @param amount
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * Returns the description
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Changes description
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Returns true if the Inquiry repeats, false otherwise
     * @return
     */
    public boolean isReccurent() {
        return isReccurent;
    }

    /**
     * Changes the value of reccurent
     * @param reccurent
     */
    public void setReccurent(boolean reccurent) {
        isReccurent = reccurent;
    }

    /**
     * Returns the recurrence
     * @return
     */
    public int getReccurence() {
        return reccurence;
    }

    /**
     * Changes the reccurence
     * @param reccurence
     */
    public void setReccurence(int reccurence) {
        this.reccurence = reccurence;
    }
}
