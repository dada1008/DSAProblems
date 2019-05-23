package com.opensource.dada.problems.hackerrank;

/**
 * Problem:
 * https://www.hackerrank.com/challenges/bigger-is-greater/problem
 */
public class BiggerIsGreater {
    public static void main(String[] args) {
        /*test1();
        test2();
        test3();
        test4();
        test5();
        test6();
        test7();
        test8();
        test9();
        test10();
        test11();*/
        //test12();
        test();
    }

    static void test() {
        String w = "ehdegnmorgafrjxvksc";
        System.out.println("Input:" + w + " Output:" + biggerIsGreater3(w));//ehdegnmorgafrjxvsck
    }

    static void test1() {
        String w = "ab";
        System.out.println("Input:" + w + " Output:" + biggerIsGreater(w));//ba
    }

    static void test2() {
        String w = "bb";
        System.out.println("Input:" + w + " Output:" + biggerIsGreater(w));//no answer
    }

    static void test3() {
        String w = "hefg";
        System.out.println("Input:" + w + " Output:" + biggerIsGreater(w));//hegf
    }

    static void test4() {
        String w = "dhck";
        System.out.println("Input:" + w + " Output:" + biggerIsGreater(w));//dhkc
    }

    static void test5() {
        String w = "dkhc";
        System.out.println("Input:" + w + " Output:" + biggerIsGreater(w));//hcdk
    }

    static void test6() {
        String w = "lmno";
        System.out.println("Input:" + w + " Output:" + biggerIsGreater(w));//lmon
    }

    static void test7() {
        String w = "dcba";
        System.out.println("Input:" + w + " Output:" + biggerIsGreater(w));//no answer
    }

    static void test8() {
        String w = "dcbb";
        System.out.println("Input:" + w + " Output:" + biggerIsGreater(w));//no answer
    }

    static void test9() {
        String w = "abdc";
        System.out.println("Input:" + w + " Output:" + biggerIsGreater(w));//acbd
    }

    static void test10() {
        String w = "abcd";
        System.out.println("Input:" + w + " Output:" + biggerIsGreater(w));//abdc
    }

    static void test11() {
        String w = "fedcbabcd";
        System.out.println("Input:" + w + " Output:" + biggerIsGreater(w));//fedcbabdc
    }

    static void test12() {
        String output = "imllmmcslslkyoegyoam\n" +
                "fvincndjrurhf\n" +
                "rtglgzzqxnuflitnlyti\n" +
                "mhtvaqofxtyzr\n" +
                "zalqxykemvzzgkaa\n" +
                "wjjulziszbqqdcpdnhod\n" +
                "japjbvjlxzkgietmk\n" +
                "jqczvgqywydkunmwj\n" +
                "ehdegnmorgafrjxvsck\n" +
                "tydwixlwghlomq\n" +
                "wddnwjneaxbwhwarm\n" +
                "pnimbesirfbixlv\n" +
                "mijamkzpiiniveki\n" +
                "qxtwpdpwexuje\n" +
                "qtcshorwykc\n" +
                "xoojiggdcyjrurp\n" +
                "vcjmvngcdyabcmzj\n" +
                "xildrrpach\n" +
                "rrcntnbqchsfhvjhi\n" +
                "kmotatmrabtcoum\n" +
                "bnfcejmyotwv\n" +
                "dnppdkpywiaxddoxq\n" +
                "tmowsxkrodmkrak\n" +
                "jfkaehlegowfggh\n" +
                "ttylsiegnttymxty\n" +
                "kyetllczuyibdkwyiqhr\n" +
                "xdhqbvlbtmmtshejff\n" +
                "kpdpzzohihzwgdgbfz\n" +
                "kuywptftpaaa\n" +
                "qfqpegznnyludvr\n" +
                "ufwogufbzaboaepsliqk\n" +
                "jfejqapjvbdcxtkyr\n" +
                "sypjbvatgiodddxy\n" +
                "wdpfyqjcpnc\n" +
                "baabpjckkyturd\n" +
                "uvwurzjyzbhcqmryprqa\n" +
                "kvtwtmqygksbmi\n" +
                "ivsjycnooeodwtp\n" +
                "zqyxjnnitzawipsmq\n" +
                "blmrzavodtfzyezp\n" +
                "bmqlhqndavc\n" +
                "phvauobwkrcfwdedcs\n" +
                "vpygyqubqywkndhwpz\n" +
                "yikanhdrwjx\n" +
                "vnpblfxmvwkflqokbr\n" +
                "pserilwzxwyorldsxlks\n" +
                "qymbqaehnyzhfqpqrlpp\n" +
                "fcakwzuqlzglnidbkmq\n" +
                "jkscckttaeifiksgkxmx\n" +
                "dkbllravwnhhfjjrec\n" +
                "imzsyrykfvtj\n" +
                "tvogoocldlukwfcajvxi\n" +
                "cvnagtypozljprajglv\n" +
                "hwcmacxvsmu\n" +
                "rhrzcpprqcfc\n" +
                "clppxvwtaktchqrfdi\n" +
                "qwusnlldnolqh\n" +
                "yitverajov\n" +
                "arciyxaxtvmfgqwbu\n" +
                "pzbxvxdjuuvvu\n" +
                "nxfowilpdxwltp\n" +
                "swzsaynxbytyttqq\n" +
                "qyrogefletey\n" +
                "iotjgthvslvmjpcchufh\n" +
                "knfpyjtzqf\n" +
                "tmtbfayantwkm\n" +
                "asxwzygnngw\n" +
                "rmwiwrurutb\n" +
                "bhmpfwhgqfcqfldlsh\n" +
                "yhbidtewppg\n" +
                "jwwbeuiklpodziiv\n" +
                "anjhprmkwieb\n" +
                "lpwhqaebrm\n" +
                "dunecynelymcpyonqj\n" +
                "hblfldireuivzekegti\n" +
                "uryygzpwifrriecgvw\n" +
                "kzuhaysegaxtwqtxv\n" +
                "kvarmrbpoxxujhvgwp\n" +
                "hanhaggqzdpunkugzmqh\n" +
                "gnwqwsylqeurq\n" +
                "qzkjbnyvclrkmtcd\n" +
                "argsnaqbqvu\n" +
                "obbnlkoaklxc\n" +
                "ojiilqieycsasvqosyuc\n" +
                "qhlgiwsmtxbffjtsx\n" +
                "vvrvnmndeopgy\n" +
                "ibeqzyeuvzbf\n" +
                "sajpyegttujyxx\n" +
                "zmdjphzogfldlkgbchtn\n" +
                "tbanvjmwixrx\n" +
                "gmdhdlmopzyvddeyajjq\n" +
                "yxvmvedubzdcp\n" +
                "soygdzhbckkfu\n" +
                "gkbekyrhwcc\n" +
                "wevzqpnqwtpuf\n" +
                "rbobquotbysufwqjoe\n" +
                "bpgqfwoyntuhkwov\n" +
                "schtabphairewhfpm\n" +
                "rlmrahlisggguykue\n" +
                "fjtfrmlqvseqk";

        String input = "imllmmcslslkyoegymoa\n" +
                "fvincndjrurfh\n" +
                "rtglgzzqxnuflitnlyit\n" +
                "mhtvaqofxtyrz\n" +
                "zalqxykemvzzgaka\n" +
                "wjjulziszbqqdcpdnhdo\n" +
                "japjbvjlxzkgietkm\n" +
                "jqczvgqywydkunmjw\n" +
                "ehdegnmorgafrjxvksc\n" +
                "tydwixlwghlmqo\n" +
                "wddnwjneaxbwhwamr\n" +
                "pnimbesirfbivxl\n" +
                "mijamkzpiiniveik\n" +
                "qxtwpdpwexuej\n" +
                "qtcshorwyck\n" +
                "xoojiggdcyjrupr\n" +
                "vcjmvngcdyabcmjz\n" +
                "xildrrhpca\n" +
                "rrcntnbqchsfhvijh\n" +
                "kmotatmrabtcomu\n" +
                "bnfcejmyotvw\n" +
                "dnppdkpywiaxddoqx\n" +
                "tmowsxkrodmkkra\n" +
                "jfkaehlegohwggf\n" +
                "ttylsiegnttymtyx\n" +
                "kyetllczuyibdkwyihrq\n" +
                "xdhqbvlbtmmtshefjf\n" +
                "kpdpzzohihzwgdfzgb\n" +
                "kuywptftapaa\n" +
                "qfqpegznnyludrv\n" +
                "ufwogufbzaboaepslikq\n" +
                "jfejqapjvbdcxtkry\n" +
                "sypjbvatgidyxodd\n" +
                "wdpfyqjcpcn\n" +
                "baabpjckkytudr\n" +
                "uvwurzjyzbhcqmrypraq\n" +
                "kvtwtmqygksbim\n" +
                "ivsjycnooeodwpt\n" +
                "zqyxjnnitzawipqsm\n" +
                "blmrzavodtfzyepz\n" +
                "bmqlhqndacv\n" +
                "phvauobwkrcfwdecsd\n" +
                "vpygyqubqywkndhpzw\n" +
                "yikanhdrjxw\n" +
                "vnpblfxmvwkflqobrk\n" +
                "pserilwzxwyorldsxksl\n" +
                "qymbqaehnyzhfqpqprpl\n" +
                "fcakwzuqlzglnibqmkd\n" +
                "jkscckttaeifiksgkmxx\n" +
                "dkbllravwnhhfjjrce\n" +
                "imzsyrykfvjt\n" +
                "tvogoocldlukwfcajvix\n" +
                "cvnagtypozljpragvlj\n" +
                "hwcmacxvmus\n" +
                "rhrzcpprqccf\n" +
                "clppxvwtaktchqrdif\n" +
                "qwusnlldnolhq\n" +
                "yitveovrja\n" +
                "arciyxaxtvmfgquwb\n" +
                "pzbxvxdjuuvuv\n" +
                "nxfowilpdxwlpt\n" +
                "swzsaynxbytytqtq\n" +
                "qyrogefleeyt\n" +
                "iotjgthvslvmjpcchhuf\n" +
                "knfpyjtzfq\n" +
                "tmtbfayantmwk\n" +
                "asxwzygngwn\n" +
                "rmwiwrurubt\n" +
                "bhmpfwhgqfcqfldlhs\n" +
                "yhbidtewpgp\n" +
                "jwwbeuiklpodvzii\n" +
                "anjhprmkwibe\n" +
                "lpwhqaebmr\n" +
                "dunecynelymcpyonjq\n" +
                "hblfldireuivzekegit\n" +
                "uryygzpwifrricwvge\n" +
                "kzuhaysegaxtwqtvx\n" +
                "kvarmrbpoxxujhvgpw\n" +
                "hanhaggqzdpunkugzmhq\n" +
                "gnwqwsylqeuqr\n" +
                "qzkjbnyvclrkmdtc\n" +
                "argsnaqbquv\n" +
                "obbnlkoaklcx\n" +
                "ojiilqieycsasvqosycu\n" +
                "qhlgiwsmtxbffjsxt\n" +
                "vvrvnmndeogyp\n" +
                "ibeqzyeuvfzb\n" +
                "sajpyegttujxyx\n" +
                "zmdjphzogfldlkgbchnt\n" +
                "tbanvjmwirxx\n" +
                "gmdhdlmopzyvddeqyjja\n" +
                "yxvmvedubzcpd\n" +
                "soygdzhbckfuk\n" +
                "gkbekyrhcwc\n" +
                "wevzqpnqwtpfu\n" +
                "rbobquotbysufwqjeo\n" +
                "bpgqfwoyntuhkvwo\n" +
                "schtabphairewhfmp\n" +
                "rlmrahlisggguykeu\n" +
                "fjtfrmlqvsekq";

        String[] inputArr = input.split("\n");
        String[] outputArr = output.split("\n");
        for (int i = 0; i < inputArr.length; i++) {
            String result = biggerIsGreater2(inputArr[i]);
            System.out.println("Input:" + inputArr[i] + " expected output:"
                    + outputArr[i] + " actual output:" + result);
            if (!result.equals(outputArr[i])) {
                break;
            }
        }
    }

    //My solution, which failed for test()
    static String biggerIsGreater(String w) {
        if (w == null || w.isEmpty()) {
            return "no answer";
        }
        char[] chars = w.toCharArray();
        int index = chars.length - 1;
        int index2 = -1;
        boolean isCharChanged = false;
        while (index > 0) {
            index2 = index - 1;
            while (index2 >= 0) {
                if (chars[index] > chars[index2]) {
                    char temp = chars[index];
                    chars[index] = chars[index2];
                    chars[index2] = temp;
                    isCharChanged = true;
                    break;
                }
                index2--;
            }
            if (isCharChanged) {
                break;
            }
            index--;
        }
        if (isCharChanged) {
            index = index2 + 1;
            while (index < chars.length - 1) {
                index2 = index + 1;
                while (index2 < chars.length) {
                    if (chars[index] > chars[index2]) {
                        char temp = chars[index];
                        chars[index] = chars[index2];
                        chars[index2] = temp;
                    }
                    index2++;
                }
                index++;
            }

            return new String(chars);
        }
        return "no answer";
    }

    static String biggerIsGreater3(String w) {
        if (w == null || w.isEmpty()) {
            return "no answer";
        }
        char[] chars = w.toCharArray();
        int index = chars.length - 1;
        int index2 = -1;
        while (index > 0) {
            index2 = index - 1;
                if (chars[index] > chars[index2]) {
                    break;
                }
            index--;
        }

        //if our only increasing is at point 0 then we are in the last permuation of our string
        if (index == 0) {
            return "no answer";
        }

        //index2
        //Determine the right most char greater than the pivot in index and in lexo
        for (int j = index; j < w.length(); j++) {
            boolean condition2 = w.charAt(j) > w.charAt(index - 1);

            if (condition2) {
                index2 = j;
            }
        }

        //Swap the index with index2
        char temp = chars[index-1];
        chars[index-1] = chars[index2];
        chars[index2] = temp;

        //Reverse starting at the element to the right of the pivot
        int left = index;
        int right = chars.length - 1;
        while (left < right) {
            //swap left with right
            char tmp = chars[left];
            chars[left] = chars[right];
            chars[right] =  tmp;
            left++;
            right--;
        }
        return new String(chars);
    }

    static String biggerIsGreater2(String word) {
        int maxLexoC1 = 0; //The max lexocographical according to condition 1
        int maxLexoC2 = 0; //The max lexocographical according to condition 2

        //Find the largest index char that is weakly increasing such as g in hefg
        for (int j = 1; j < word.length(); j++) {
            boolean condition1 = word.charAt(j) > word.charAt(j - 1);

            if (condition1) {
                maxLexoC1 = (j > maxLexoC1) ? j : maxLexoC1;
            }
        }

        //if our only increasing is at point 0 then we are in the last permuation of our string
        if (maxLexoC1 == 0) {
            return "no answer";
        }

        //maxLexoC2
        //Determine the right most char greater than the pivot in index and in lexo
        for (int j = maxLexoC1; j < word.length(); j++) {
            boolean condition2 = word.charAt(j) > word.charAt(maxLexoC1 - 1);

            if (condition2) {
                maxLexoC2 = j;
            }
        }

        StringBuilder wordSB = new StringBuilder(word);

        //Swap the pivot with maxLexoC2
        char tmp = wordSB.charAt(maxLexoC1 - 1);
        wordSB.setCharAt(maxLexoC1 - 1, wordSB.charAt(maxLexoC2));
        wordSB.setCharAt(maxLexoC2, tmp);


        //Reverse starting at the element to the right of the pivot
        int left = maxLexoC1;
        int right = wordSB.length() - 1;
        while (left < right) {
            //swap left with right
            tmp = wordSB.charAt(left);
            wordSB.setCharAt(left, wordSB.charAt(right));
            wordSB.setCharAt(right, tmp);
            left++;
            right--;
        }
        return wordSB.toString();
    }
}
