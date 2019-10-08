package com.medlemsregister;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Klassen som sköter all in- och utmatning i programmet.
 * Använder Scanner för att ta emot användarens inmatningar.
 *
 * @author Karin Eriksson
 * @version 1.0
 * @since 2019-10-08
 */
public class MemberView {

    private Scanner scanner;

    public MemberView() {
        scanner = new Scanner(System.in);
    }

    /**
     * Ber användaren mata in ett namn
     *
     * @return namnet som användaren matar in
     */
    public String getNameInput() {

        System.out.print("Namn: ");
        return scanner.nextLine();
    }

    /**
     * Ber användaren mata in ålder. Frågar om igen tills
     * användaren matar in en ålder mellan 0 och 120 år.
     *
     * @return åldern som användaren matar in
     */
    public int getAgeInput() {

        int age = -1;
        while ((age < 0) || (age > 120)) {
            System.out.print("Ålder: ");
            try {
                age = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Felaktig inmatning");
                System.out.println("Försök igen");
            }

            if ((age < 0) || (age > 120)) {
                System.out.println("Åldern måste vara mellan 0 och 120");
            }
            scanner.nextLine();
        }
        return age;
    }

    /**
     * Frågar användaren om medlemsnummer på en förälder vid
     * registrering av ny barnmedlem.
     *
     * @return förälderns medlemsnummer
     */
    public int getParentalInput() {

        System.out.print("Ange förälders medlemsnummer: ");
        int parentalMemberNumber = -1;
        while (parentalMemberNumber < 0) {
            try {
                parentalMemberNumber = scanner.nextInt();

            } catch (InputMismatchException e) {
                System.out.println("Felaktig inmatning");
                System.out.print("Ange förälders medlemsnummer:");
            }
            scanner.nextLine();
        }
        return parentalMemberNumber;
    }

    /**
     * Frågar användaren efter ett medlemsnummer
     *
     * @return medlemsnumret som användaren matar in
     */
    public int getMemberNumberInput() {

        int memberNumber = -1;
        while (memberNumber < 0) {
            System.out.print("Ange medlemsnummer: ");
            try {
                memberNumber = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Felaktig inmatning");
                System.out.println("Försök igen");
            }
            scanner.nextLine();
        }
        return memberNumber;
    }

    /**
     * Visar användaren en meny med olika kategorier av
     * medlemmar. Användaren får sedan välja kategori genom
     * att mata in ett nummer.
     *
     * @return numret på den kategori som användaren väljer
     */
    public int getCategoryInput() {

        int category = -1;
        while ((category < 1) || (category > 5)) {
            showMemberCategoryMenu();
            try {
                category = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Felaktig inmatning");
                System.out.println("Försök igen");
            }
            scanner.nextLine();
        }
        return category;
    }

    /**
     * Tar emot ett tal som användaren matar in. Talet representerar vad
     * användaren väljer att göra härnäst i programmet enligt olika
     * alternativ i huvudmenyn.
     *
     * @return användarens val i form av ett heltal
     */
    public int getMenuInput() {

        int choice = 0;
        System.out.print("Ange ditt val: ");
        try {
            choice = scanner.nextInt();
        } catch (InputMismatchException e){
            System.out.println("Felaktig inmatning");
            System.out.println("Försök igen");
        }
        scanner.nextLine();
        return choice;
    }

    /**
     * Visar en lista med namn och medlemsnummer
     * för alla medlemmar
     *
     * @param list listan med medlemmar
     */
    public void showMembers(ArrayList<Member> list) {

        for (Member member : list){
            System.out.println("Medlemsnummer " + member.getMemberNumber() + ", " + member.getName());
        }
    }

    /**
     * Visar information om en medlem
     *
     * @param member medlemmen som ska visas
     */
    public void showInfo(Member member) {

        if (member != null) {
            System.out.println(member.getInfo());
        } else {
            System.out.println("Felaktigt medlemsnummer");
        }
    }

    /**
     * Visar resultatet av en sökning efter en viss medlem. Om
     * medlemmen finns visas namn och medlemsnummer, annars visas
     * ett meddelande om att medlemmen inte hittats.
     *
     * @param member den eftersökta medlemmen
     */
    public void showSearchResult(Member member) {

        if (member != null) {
            System.out.println(member.getName() + " har medlemsnummer " + member.getMemberNumber());
        } else {
            System.out.println("Det finns ingen medlem med det namnet");
        }
    }

    /**
     * Visar en kategori av medlemmar. De kategorier som kan visas är
     * barn-, ungdoms-, vuxen-, senior- eller VIP-medlemmar.
     *
     * @param list listan med de medlemmar som ska visas
     * @param category ett heltal som visar vilken kategori av
     *                 medlemmar det rör sig om
     */
    public void showMemberCategory(ArrayList<Member> list, int category) {

        switch (category){
            case 1:
                System.out.println("Barnmedlemmar: ");
                showMembers(list);

                if (list.size() == 0) {
                    System.out.println("Det finns inga registrerade barnmedlemmar");
                }
                break;
            case 2:
                System.out.println("Ungdomsmedlemmar: ");
                showMembers(list);

                if (list.size() == 0) {
                    System.out.println("Det finns inga registrerade ungdomsmedlemmar");
                }
                break;
            case 3:
                System.out.println("Vuxenmedlemmar: ");
                showMembers(list);

                if (list.size() == 0) {
                    System.out.println("Det finns inga registrerade vuxenmedlemmar");
                }
                break;
            case 4:
                System.out.println("Seniormedlemmar: ");
                showMembers(list);

                if (list.size() == 0) {
                    System.out.println("Det finns inga registrerade seniormedlemmar");
                }
                break;
            case 5:
                System.out.println("VIP-medlemmar: ");
                showMembers(list);

                if (list.size() == 0) {
                    System.out.println("Det finns inga registrerade VIP-medlemmar");
                }
                break;
            default:
                System.out.println("Felaktigt val");
        }
    }

    /**
     * Visar huvudmenyn för programmet
     */
    public void showMenu() {

        System.out.println("\t0. Visa meny");
        System.out.println("\t1. Registrera ny medlem");
        System.out.println("\t2. Visa medlemmar");
        System.out.println("\t3. Visa info om en medlem");
        System.out.println("\t4. Visa kategorier av medlemmar");
        System.out.println("\t5. Sök efter medlem");
        System.out.println("\t6. Registrera besök");
        System.out.println("\t7. Avsluta");
    }

    /**
     * Visar en meny med olika kategorier av medlemmar
     */
    public void showMemberCategoryMenu() {
        System.out.println("Visa lista med: ");
        System.out.println("\t1. Barnmedlemmar");
        System.out.println("\t2. Ungdomsmedlemmar");
        System.out.println("\t3. Vuxenmedlemmar");
        System.out.println("\t4. Seniormedlemmar");
        System.out.println("\t5. VIP-medlemmar");
        System.out.print("Ange val: ");
    }

    /**
     * Visar ett meddelande
     *
     * @param message meddelandet som ska visas
     */
    public void showMessage(String message) {
        System.out.println(message);
    }
}
