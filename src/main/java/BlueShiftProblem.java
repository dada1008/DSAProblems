public class BlueShiftProblem {
    /**
     * //String of letters, integer k times need to rotate that string
     * //e.g. input String is "string", k is 3
     * //output should be: "ingstr"
     * <p>
     * string length 6, k=15,
     * 15%6= 3, that's why I'll rotate string 3 times.
     */

    public static void main(String[] args) {
        System.out.println("OutPut:" + rotateString("string", 551));

    }

    static String rotateString(String input, int rotations) {
        if (rotations < 0) {
            throw new RuntimeException("Rotation should be positive value");
        }
        if (input == null || input.isEmpty()) {
            throw new RuntimeException("Invalid input");
        }
        int lengthOfString = input.length();
        int k =  rotations % lengthOfString;
        char[] inputArr = input.toCharArray();
        char[] rotatedChars = new char[k];

        for (int i = 0; i < k; i++) {
            rotatedChars[i] = inputArr[i + lengthOfString - k];
        }

        for (int i = lengthOfString-1; i >= k; i--) {
            inputArr[i] = inputArr[i -k];
        }
        for (int i = 0; i < k; i++) {
            inputArr[i] = rotatedChars[i];
        }
        return new String(inputArr);
    }
}
