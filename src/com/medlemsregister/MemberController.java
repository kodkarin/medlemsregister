package com.medlemsregister;

/**
 * Programmet simulerar en simhall med olika typer av medlemmar.
 * Användaren kan välja att lägga till nya medlemmar, besöka
 * anläggningen, söka efter medlemmar och visa info på
 * olika sätt. Den här klassen är den som håller samman programmet
 * och ser till att andra klasser anropas vid behov.
 *
 * @author Karin Eriksson
 * @version 1.0
 * @since 2019-10-08
 */

public class MemberController {

    private MemberModel members;
    private MemberView view;

    public MemberController() {
        members = new MemberModel();
        view = new MemberView();
    }

    /**
     * Metoden som kör själva programmet. Visar menyn och
     * anropar olika metoder enligt användarens val tills
     * användaren väljer att avsluta programmet.
     */
    public void run() {

        boolean quit = false;
        view.showMessage("Välkommen till simhallen!");
        view.showMenu();
        while (!quit){

            int choice = view.getMenuInput();

            switch (choice){
                case 0:
                    view.showMenu();
                    break;
                case 1:
                    addMember();
                    break;
                case 2:
                    showMembers();
                    break;
                case 3:
                    showInfo();
                    break;
                case 4:
                    showMemberCategory();
                    break;
                case 5:
                    search();
                    break;
                case 6:
                    makeVisit();
                    break;
                case 7:
                    quit = true;
                    break;
                default:
                    view.showMessage("Felaktig inmatning\nFörsök igen");
            }
        }
    }

    /**
     * Lägger till en ny medlem. Frågar användaren om namn
     * och ålder. Om medlemmen är under 13 år efterfrågas också
     * en förälders medlemsnummer.
     */
    public void addMember() {

        String name = view.getNameInput();
        int age = view.getAgeInput();

        if (age <= 12) {
            int  parentalMemberNumber = view.getParentalInput();
            addMember(name, age, parentalMemberNumber);
        } else {
            addMember(name, age);
        }
    }

    /**
     * Lägger till en ny medlem
     *
     * @param name namn på ny medlem
     * @param age ålder på ny medlem
     */
    public void addMember(String name, int age) {

        view.showMessage(members.add(name, age));

    }

    /**
     * Lägger till en ny barnmedlem
     *
     * @param name namn på ny medlem
     * @param age ålder på ny medlem
     * @param parentalMemberNumber förälders medlemsnummer
     */
    public void addMember(String name, int age, int parentalMemberNumber) {

        view.showMessage(members.add(name, age, parentalMemberNumber));

    }

    private Member findMember(int memberNumber) {

        return members.findMember(memberNumber);

    }

    /**
     * Visar en lista med alla medlemmar
     */
    public void showMembers() {

        view.showMembers(members.getMembers());

    }

    /**
     * Visar info om en specifik medlem. Frågar användaren
     * om medlemsnumret på den medlem man vill se info om.
     */
    public void showInfo() {

        int memberNumber = view.getMemberNumberInput();
        Member memberToShow = findMember(memberNumber);
        view.showInfo(memberToShow);

    }

    /**
     * Registrerar ett besök för en medlem. Frågar användaren
     * om medlemsnummer för den medlem som ska göra besöket.
     *
     */
    public void makeVisit() {

        makeVisit(view.getMemberNumberInput());

    }

    /**
     * Registrerar ett besök för en medlem.
     *
     * @param memberNumber medlemsnummer för den medlem som
     *                     ska göra besöket
     */
    public void makeVisit(int memberNumber) {

        Member memberVisiting = findMember(memberNumber);
        if (memberVisiting != null) {
            view.showMessage(memberVisiting.makeVisit());
        } else {
            view.showMessage("Det finns ingen medlem med det medlemsnumret");
        }
    }

    /**
     * Användaren får mata in ett namn. Metoden söker sedan
     * igenom medlemsregistret för att se om det finns
     * någon medlem med det namnet.
     */
    public void search() {

        String name = view.getNameInput();
        Member memberToFind =  members.findMember(name);
        view.showSearchResult(memberToFind);

    }


    /**
     * Visar en lista med en kategori av medlemmar.
     * Användaren får ange vilken kategori som ska
     * visas.
     */
    public void showMemberCategory() {

        int category = view.getCategoryInput();
        view.showMemberCategory(members.findCategoryOfMembers(category), category);
    }

}
