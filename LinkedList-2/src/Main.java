
import java.util.Scanner;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {

    public static void main(String[] args) {
        LinkedList<String> sehir = new LinkedList<String>();
        sirayla_ekle(sehir, "istanbul");
        sirayla_ekle(sehir, "Ankara");
        sirayla_ekle(sehir, "izmir");
        sirayla_ekle(sehir, "kars");

        gez(sehir);

        //bastir(sehir);
    }

    public static void sirayla_ekle(LinkedList<String> x, String yeni) {
        ListIterator<String> iterator = x.listIterator();

        while (iterator.hasNext()) {
            int karsilastir = 0;

            if (iterator.next().compareTo(yeni) > 0) {
                iterator.previous();
            }
            iterator.add(yeni);
            return;
        }

        iterator.add(yeni);
    }

    public static void gez(LinkedList<String> x) {
        ListIterator<String> iterator = x.listIterator();
        Scanner input = new Scanner(System.in);
        boolean cikis = false;
        boolean ileri = true;

        while (!cikis) {

            System.out.println("1-ileri git");
            System.out.println("2-geri git");
            System.out.println("0-programdan cik");

            System.out.print("islem seciniz: ");
            int islem = input.nextInt();

            if (islem == 1) {
                if (iterator.hasNext()) {
                    if (ileri == false) {
                        iterator.next();

                    }
                    System.out.println("bir ileri gidildi. Suanki konum: " + iterator.next());
                    ileri = true;

                } else {
                    System.out.println("gidilecek bir yer yok.");
                }

            } else if (islem == 2) {
                if (iterator.hasPrevious()) {
                    if (ileri == true) {
                        iterator.previous();

                    }
                    System.out.println("bir geri gidildi. Suanki konum: " + iterator.previous());
                    ileri = false;
                } else {
                    System.out.println("donulecek bir yer yok.");
                }

            } else if (islem == 0) {
                System.out.println("sistem kapatiliyor.");
                return;
            } else {
                System.out.println("yanlis rakam girisi.");
            }
        }
    }

    public static void bastir(LinkedList<String> x) {

        ListIterator<String> iterator = x.listIterator();

        while (iterator.hasNext()) {

            System.out.println(iterator.next());
        }

    }
}
