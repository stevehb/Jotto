import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class FreqCleaner {
    BufferedReader iList;
    BufferedReader iFreq;
    BufferedWriter oList;
    HashMap<String, Integer> freqMap;

    public FreqCleaner(String iListName, String iFreqName, String oListName) 
        throws IOException {
        iList = new BufferedReader(new FileReader(iListName));
        iFreq = new BufferedReader(new FileReader(iFreqName));
        oList = new BufferedWriter(new FileWriter(oListName));
        freqMap = new HashMap<String, Integer>();
    }

    public void augmentList() throws IOException {
        // read frequencies into a map
        System.out.println("Loading in the frequency list...");
        String line = iList.readLine();
        String[] pair;
        while(line != null) {
            pair = line.split("\t");
            freqMap.put(pair[1], Integer.valueOf(Integer.parseInt(pair[0])));
            System.out.println("mapping " + pair[1] + " to freq " + freqMap.get(pair[1]));
            line = iList.readLine();
        }


        /*

        boolean write = false;
        String line = iList.readLine();
        int freq = 0;
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
        */
        iList.close();
        iFreq.close();
        oList.close();
    }


    public static void main(String[] args) {
        if(args.length != 3) {
            System.out.println("USAGE: FreqCleaner [inputList] [inputFreq] [outputList]");
            return;
        }
        try {
            FreqCleaner fc = new FreqCleaner(args[0], args[1], args[3]);
            fc.augmentList();
        }
        catch(IOException e) {
            System.err.println("ERROR: " + e);
        }
    }
}
