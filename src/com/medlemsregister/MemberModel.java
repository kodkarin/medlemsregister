package com.medlemsregister;

import java.util.ArrayList;

/**
 * Representerar medlemsregistret. Har en lista med
 * medlemmar och håller reda på vilket medlemsnummer en ny medlem ska få.
 * Avgör också vilken subklass till Member som en ny medlem ska tillhöra
 * baserat på medlemmens ålder.
 *
 * @author Karin Eriksson
 * @version 1.0
 * @since 2019-10-08
 */
public class MemberModel {

    private ArrayList<Member> members;
    private int counter; 

    
    public MemberModel(){
        members = new ArrayList<>();
        counter = 0;
    }

    public ArrayList<Member> getMembers() {
        return members;
    }


    /**
     * Lägger till en ny barnmedlem. Åldern måste vara mellan 0 och
     * 12 år för att en barnmedlem ska läggas till.
     *
     * @param name namnet på den nya medlemmen
     * @param age åldern på den nya medlemmen
     * @param parentalMemberNumber förälderns medlemsnummer
     * @return ett meddelande som visar att en ny medlem har lagts till
     */
    public String add (String name, int age, int parentalMemberNumber) {

        int memberNumber = counter+1;
        Member parent = findMember(parentalMemberNumber);
        String message;

        if ((age < 0) || (age > 12)){
            message = "En barnmedlem måste vara mellan 0 och 12 år";
        } else if (!(parent instanceof Adult)) {
            message = ("Kan ej hitta en godkänd förälder.\nIngen ny medlem skapad");
        } else {
            members.add(new Child(name, age, memberNumber, parent));
            message = ("Ny barnmedlem skapad.\nDitt medlemsnummer är " + memberNumber + "\nFörälder är " + parent.getName() + ", medlemsnummer " + parent.getMemberNumber());
            counter++;
        }
        return message;
    }

    /**
     * Lägger till en ny medlem. Om åldern är mellan 13 och 19 registreras
     * en ny ungdomsmedlem, om åldern är mellan 20 och 64 registreras en
     * ny vuxenmedlem och om åldern är mellan 65 och 120 registreras en
     * ny seniormedlem.
     *
     * @param name namnet på den nya medlemmen
     * @param age åldern på den nya medlemmen
     * @return ett meddelande som visar att en ny medlem har lagts till
     */
    public String add (String name, int age){
        
        int memberNumber = counter+1;
        String message;

        if ((age < 0) || (age > 120)) {
            message = "Felaktig ålder";
        } else if ((age <=12)) {
            message = "Det går inte att skapa en barnmedlem utan att ange en förälder";
        } else if (age <= 19) {
            members.add(new Junior(name, age, memberNumber));
            message = ("Ny ungdomsmedlem skapad.\nDitt medlemsnummer är " + memberNumber);
            counter++;
        } else if (age <= 64) {
            members.add(new Adult(name, age, memberNumber));
            message = ("Ny vuxenmedlem skapad.\nDitt medlemsnummer är " + memberNumber);
            counter++;
        } else {
            members.add(new Senior(name, age, memberNumber));
            message = ("Ny seniormedlem skapad.\nDitt medlemsnummer är " + memberNumber);
            counter++;
        }
        return message;
    }

    /**
     * Söker efter en viss medlem baserat på medlemsnummer
     *
     * @param memberNumber medlemsnumret på eftersökt medlem
     * @return medlemmen om den hittats, annars null
     */
    public Member findMember(int memberNumber){
        for (Member member : members){
            if (member.getMemberNumber() == memberNumber){
                return member;
            }
        }
        return null;
    }

    /**
     * Söker efter en viss medlem baserat på namn
     *
     * @param name namnet på eftersökt medlem
     * @return medlemmen om den hittats, annars null
     */
    public Member findMember(String name){
        for (Member member : members){
            if (member.getName().equalsIgnoreCase(name)){
                return member;
            }
        }
        return null;
    }

    /**
     * Gör en lista på alla medlemmar av en viss kategori. De
     * kategorier som kan visas är barn-, ungdoms-, vuxen-,
     * senior- och VIP-medlemmar.
     *
     * @param category kategorin av medlemmar som efterfrågas
     * @return en lista som innehåller alla medlemmar av rätt kategori
     */
    public ArrayList<Member> findCategoryOfMembers(int category){
        ArrayList<Member> selection = new ArrayList<>();

        switch (category){
            case 1:
                for (Member member : members){
                    if (member instanceof Child){
                        selection.add(member);
                    }
                }
                break;
            case 2:
                for (Member member : members){
                    if (member instanceof Junior){
                        selection.add(member);
                    }
                }
                break;
            case 3:
                for (Member member : members){
                    if (member instanceof Adult){
                        selection.add(member);
                    }
                }
                break;
            case 4:
                for (Member member : members){
                    if (member instanceof Senior) {
                       selection.add(member);
                    }
                }
                break;
            case 5:
                for (Member member : members){
                    if (member.isVip()){
                        selection.add(member);
                    }
                }
                break;
        }
        return selection;
    }
}
