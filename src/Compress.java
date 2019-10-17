//Author: mshaikh52 StudentNumber: 250959996, Created 2018/02/05. Professor Roberto Solis-Oba
//compression algorithm, will take a text file and convert to binary and store in another file

public class Compress {

    // @SuppressWarnings("unused")
    //@SuppressWarnings("unused")
    public static void main(String[] args) {

        // read compreassion code file and make code pair objects and to list
        String inputFileName = args[0];
        String codeFilName = args[1];

        // declare CodePair objects and Array object
        CodePair newPair;
        ArrayCode list = null;

        list = new ArrayCode(20);

        // declare textFiles and asssign values and construct them
        TextFile codeFile = new TextFile(args[1], "read");
        // @SuppressWarnings("unused")
        TextFile readFile = new TextFile(args[0], "read");
        CompressedFile outFile = null;

        // get output file name
        String outputName = args[0].substring(0, args[0].length() - 3) + "zzz";
        // initialize output file name
        outFile = new CompressedFile(outputName, "write");

        // runs through file and add each code and character
        // read a character and make list of codes
        char codeChar = codeFile.readChar();
        String codeNumber = null;
        do {

            char codeCharacter = codeChar;
            codeNumber = codeFile.readLine();

            newPair = new CodePair(codeCharacter, codeNumber);
            list.add(newPair);
            codeChar = codeFile.readChar();

        } while (codeChar != 0);

        //compress the file
        char textChar = readFile.readChar();
        String code = null;
        do {

            // find position of character we are trying to find
            int findPosition = list.findCharacter(textChar);
            if (findPosition != -1) {
                // next get the corresponding compression code
                code = list.getCode(findPosition);
                // System.out.println(code);

                // write to output file
                for (int i = 0; i < code.length(); i++) { //.length -1 :(
                    if (code.charAt(i) != 0) {
                        char bit = code.charAt(i);
                        outFile.writeBit(bit);
                        // System.out.println(bit);
                    }
                }
            }
            // read next Char
            textChar = readFile.readChar();
        } while (textChar != 0);

        // close the files
        outFile.close();
        readFile.close();
        codeFile.close();
    }
}
