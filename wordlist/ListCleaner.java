import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ListCleaner {
    BufferedReader ifile;
    BufferedWriter ofile;

    public ListCleaner(String ifname, String ofname) throws IOException {
        ifile = new BufferedReader(new FileReader(ifname));
        ofile = new BufferedWriter(new FileWriter(ofname));
    }

    public void cleanList() throws IOException {
        boolean write = false;
        String line = ifile.readLine();
        char[] carr;
        while(line != null) {
            write = true;
            line = line.toLowerCase();
            if(line.length() < 3 || line.length() > 6) {
                write = false;
            } else {
                for(int i = 0; i < line.length()-1; i++) {
                    if(line.substring(i+1).contains(Character.toString(line.charAt(i)))) {
                        write = false;
                        break;
                    }
                }
            }
            if(write)
                ofile.write(line + "\n");
            line = ifile.readLine();
        }
        ifile.close();
        ofile.flush();
        ofile.close();
    }


    public static void main(String[] args) {
        if(args.length != 2) {
            System.out.println("USAGE: ListCleaner [inputList] [outputList]");
            return;
        }
        try {
            ListCleaner lc = new ListCleaner(args[0], args[1]);
            lc.cleanList();
        }
        catch(IOException e) {
            System.err.println("ERROR: " + e);
        }
    }
}
