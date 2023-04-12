public class ScaryListTest {
    public static void main(String [] args) {
        System.out.println("\033[0;31mL\033[0;32mi\033[0;33mg\033[0;34mm\033[0;35ma\033[0;36m b\033[0;37ma\033[0;31ml\033[0;32ml\033[0;33m\033[0;34ms");

        LinkMe2 list = new LinkMe2();

        list.buildScaryList();
    }
}