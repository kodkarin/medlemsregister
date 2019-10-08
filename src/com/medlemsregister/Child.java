package com.medlemsregister;


/**
 * Subklass av member. Representerar medlemmar under 13 år.
 * Har ett extra fält parent som representerar en förälder
 * till barnmedlemmen.
 *
 * @author Karin Eriksson
 * @version 1.0
 * @since 2019-10-08
 */
public class Child extends Member {

    private Member parent;

    public Child(String name, int age, int memberNumber, Member parent){
        super(name, age, memberNumber);
        this.parent = parent;
    }

    public Member getParent() {
        return parent;
    }



    @Override
    public String getInfo() {
        return (super.getInfo() + "\nNamn på förälder: " + parent.getName());
    }

    @Override
    public String makeVisit() {
        String message = super.makeVisit();
        if (getNumberOfVisits() == 20){
            message += (upgradeToVip() + "\nDu får halva priset på simlektioner!");
        }
        return message;
    }
}
