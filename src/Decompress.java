//Author: mshaikh52 StudentNumber: 250959996, Created 2018/02/05. Professor Roberto Solis-Oba
//compression algorithm, will take a text file and convert to binary and store in another file

public class Decompress {

    public static void main(String[] args) {
        String inputFileName = args[0];
        String codeFilename = args[1];


        // declare codepair and array objects
        CodePair newPair;
        ArrayCode list = null;

        list = new ArrayCode(20);
        String inputName = args[0].substring(0, args[0].length() - 3) + "dec";

        // declare files and asssign values and construct the
        CompressedFile readFile = new CompressedFile(args[0], "read");
        TextFile codeFile = new TextFile(args[1], "read");
        TextFile outFile = new TextFile(inputName, "write");

        // make list of code objects
        char codeChar = codeFile.readChar();
        String codeNumber = null;
        do {

            char codeCharacter = codeChar;
            codeNumber = codeFile.readLine();

            newPair = new CodePair(codeCharacter, codeNumber);
            list.add(newPair);
            codeChar = codeFile.readChar();

        } while (codeChar != 0);


        //convert the binary code to letters.
        boolean flag = false;
        char newBit = 0;
        char bit = readFile.readBit();
        String code = Character.toString(bit);
        do {
            flag = false;

            for (int a = 0; a < list.getNumPairs(); a++) {
                if (code.equals(list.getCode(a))) {
                    //System.out.println(list.getCharacter(a));
                    flag = true;
                    outFile.writeChar(list.getCharacter(a));
                }

            }
            if (flag == false) {
                newBit = readFile.readBit();
                code = code + newBit;
            } else if (flag == true) {
                code = null;
                code = Character.toString(readFile.readBit());
                continue;
            }
        } while (newBit == '0' || newBit == '1');

        outFile.close();
        readFile.close();
        codeFile.close();

    }

}
