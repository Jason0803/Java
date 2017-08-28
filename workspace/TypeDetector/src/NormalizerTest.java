import java.text.Normalizer;
//import org.junit.Test;


/*
 * This application is to test how 'Normalizer' works
 * and the printed output.
 * It's to be used to 'HangeulPostpositionTypoFinderView' class as they will
 * find post-position typo by checking the letter before it consists 'final (Jong-seong)'
 * by normalizing (NFD) the letter and checkiing whether final exists
 */
public class NormalizerTest {
    private void printIt(String string) {
        System.out.println(string);
        for (int i = 0; i < string.length(); i++) {
            System.out.print(String.format("%04X ", string.codePointAt(i)));
        }
        System.out.println();
    }
  

    public void test() {
        String han = "ㄱ 악";
        printIt(han);
          
        String nfd = Normalizer.normalize(han, Normalizer.Form.NFD);
        printIt(nfd);
          
        String nfc = Normalizer.normalize(nfd, Normalizer.Form.NFC);
        printIt(nfc);
    }
     
}
