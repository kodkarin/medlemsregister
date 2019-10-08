package com.medlemsregister;


/**
 * Subklass av member. Representerar medlemmar mellan 20 och 64 år.
 *
 * @author Karin Eriksson
 * @version 1.0
 * @since 2019-10-08
 */
public class Adult extends Member {

    public Adult(String name, int age, int memberNumber) {
        super(name, age, memberNumber);
    }

    @Override
    public String getInfo() {
        return (super.getInfo() + "\nÄr vuxenmedlem");
    }

    @Override
    public String makeVisit() {
        String message = super.makeVisit();
        if (getNumberOfVisits() == 20){
            message += (upgradeToVip() + "\nDu får gratis kaffe när du besöker oss!");
        }
        return message;
    }
}
