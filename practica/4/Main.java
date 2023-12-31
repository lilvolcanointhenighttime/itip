import java.util.*;
import java.util.stream.Collectors;


public class Main {

    public static void main(String[] args) {
    //Task1
        String input1 = "abracadabra";
        String input2 = "paparazzi";
        System.out.println("Task1");
        System.out.println(nonRepeatable(input1));
        System.out.println(nonRepeatable(input2));
     	
    //Task2
        System.out.println("Task2");
        System.out.println(generateBrackets(1));
        System.out.println(generateBrackets(2));
        System.out.println(generateBrackets(3));
    	
    //Task3
        int na = 3;
        int nb = 4;

        System.out.println("Task3");
        System.out.println(binarySystem(na));
        System.out.println(binarySystem(nb));
    	
    //Task4
        String str1 = "aaa";
        String str2 = "klmabzyxw";

        System.out.println("Task4");
        System.out.println(alphabeticRow(str1));
        System.out.println(alphabeticRow(str2));
        
    //Task5
        System.out.println("Task5");
        String result1 = countAndSort("aaabbcdd");
        String result2 = countAndSort("vvvvaajaaaaa");
        
        System.out.println(result1);
        System.out.println(result2);
        
    //Task6
        System.out.println("Task6");
   	    String sr1 = "eight";
        String sr2 = "five hundred sixty seven";
        String sr3 = "thirty one";

        System.out.println(convertToNum(sr1)); // Output: 8
        System.out.println(convertToNum(sr2)); // Output: 567
        System.out.println(convertToNum(sr3)); // Output: 31  
	
    //Task7
        System.out.println("Task7");
        String s1 = "123412324";
        String s2 = "111111";
        String s3 = "77897898";

        System.out.println(uniqueSubstring(s1)); // Output: "1234"
        System.out.println(uniqueSubstring(s2)); // Output: "1"
        System.out.println(uniqueSubstring(s3)); // Output: "789"
	
   //Task8
        System.out.println("Task8");
        int[][] grid1 = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        int[][] grid2 = {
                {2, 7, 3},
                {1, 4, 8},
                {4, 5, 9}
        };

        System.out.println(shortestWay(grid1)); // Output: 7
        System.out.println(shortestWay(grid2)); // Output: 21
	
   //Task9
        System.out.println("Task9");
     	String stri1 = "t3o the5m 1One all6 r4ule ri2ng";
        String stri2 = "re6sponsibility Wit1h gr5eat power3 4comes g2reat";

        System.out.println(numericOrder(stri1)); // Output: " One ring to rule them all"
        System.out.println(numericOrder(stri2)); // Output: " With great power comes great responsibility"
	
  //Task10
        System.out.println("Task10");
        int num1 = 519;
        int num2 = 723;
        int num3 = 491;
        int num4 = 3912;
        int num5 = 6274;
        int num6 = 71259;

        System.out.println(switchNums(num1, num2)); // Output: 953
        System.out.println(switchNums(num3, num4)); // Output: 9942
        System.out.println(switchNums(num5, num6)); // Output: 77659
} 
    //Task1
    public static String nonRepeatable(String str) {
    	StringBuilder result = new StringBuilder();
    	for (int i = 0; i < str.length(); i++) {
        	char currentChar = str.charAt(i);
        	if (result.indexOf(String.valueOf(currentChar)) == -1) {
            		result.append(currentChar);
        		}
    		}
    	return result.toString();
	}



    //Task2
    public static List<String> generateBrackets(int n) {
	    List<String> result = new ArrayList<>();
	    generateBracketsHelper(result, "", 0, 0, n);
	    return result;
	}
    private static void generateBracketsHelper(List<String> result, String current, int openCount, int closeCount, int max) {
	    if (current.length() == max * 2) {
		result.add(current);
		return;
	    }
	    if (openCount < max)
		generateBracketsHelper(result, current + "(", openCount + 1, closeCount, max);
	    if (closeCount < openCount)
		generateBracketsHelper(result, current + ")", openCount, closeCount + 1, max);
	}
	
    //Task3
    public static List<String> binarySystem(int n) {
        List<String> result = new ArrayList<>();
        generateCombinations("", n, result);
        return result;
    }

    private static void generateCombinations(String current, int n, List<String> result) {
        if (current.length() == n) {
            result.add(current);
        } else {
            if (current.isEmpty() || current.charAt(current.length() - 1) != '0') {
                generateCombinations(current + "0", n, result);
            }
            generateCombinations(current + "1", n, result);
        }
    }

    //Task4
    public static String alphabeticRow(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
    
        String longestIncreasingSequence = "";
        String longestDecreasingSequence = "";
        String currentIncreasingSequence = String.valueOf(str.charAt(0));
        String currentDecreasingSequence = String.valueOf(str.charAt(0));
    
        for (int i = 1; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            char previousChar = str.charAt(i - 1);
    
            if (currentChar - 1 == previousChar) {
                currentIncreasingSequence += currentChar;
            } else {
                if (currentIncreasingSequence.length() > longestIncreasingSequence.length()) {
                    longestIncreasingSequence = currentIncreasingSequence;
                }
                currentIncreasingSequence = String.valueOf(currentChar);
            }
    
            if (currentChar + 1 == previousChar) {
                currentDecreasingSequence += currentChar;
            } else {
                if (currentDecreasingSequence.length() > longestDecreasingSequence.length()) {
                    longestDecreasingSequence = currentDecreasingSequence;
                }
                currentDecreasingSequence = String.valueOf(currentChar);
            }
        }
    
        if (currentIncreasingSequence.length() > longestIncreasingSequence.length()) {
            longestIncreasingSequence = currentIncreasingSequence;
        }
    
        if (currentDecreasingSequence.length() > longestDecreasingSequence.length()) {
            longestDecreasingSequence = currentDecreasingSequence;
        }
    
        return longestIncreasingSequence.length() > longestDecreasingSequence.length() ? longestIncreasingSequence : longestDecreasingSequence;
    }
    
	
    //Task5

    public static String countAndSort(String s) {
        char prevChar = '\0';  // Previous character
        int count = 0;  // Count of the current character

        StringBuilder result = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c != prevChar) {
                if (count > 0) {
                    result.append(prevChar).append(count);
                }
                prevChar = c;
                count = 1;
            } else {
                count++;
            }
        }

        // Append the last character and its count
        if (count > 0) {
            result.append(prevChar).append(count);
        }
        String orderedResult = orderResultByCount(result.toString());
        return orderedResult.toString();
    }
    public static String orderResultByCount(String result) {
        // Create a list to store character-count pairs
        List<String> charCountPairs = new ArrayList<>();

        // Split the result into character-count pairs
        int i = 0;
        while (i < result.length()) {
            char currentChar = result.charAt(i);
            i++;
            StringBuilder countBuilder = new StringBuilder();
            while (i < result.length() && Character.isDigit(result.charAt(i))) {
                countBuilder.append(result.charAt(i));
                i++;
            }
            charCountPairs.add(currentChar + countBuilder.toString());
        }

        // Sort the list based on count (from least to greatest)
        Collections.sort(charCountPairs, Comparator.comparingInt(pair -> Integer.parseInt(pair.substring(1))));

        // Construct the ordered result string
        StringBuilder orderedResult = new StringBuilder();
        for (String charCountPair : charCountPairs) {
            orderedResult.append(charCountPair);
        }

        return orderedResult.toString();
    }
			
	//Task6
    public static int convertToNum(String s) {
        Map<String, Integer> wordsToNums = new HashMap<>();
        wordsToNums.put("one", 1);
        wordsToNums.put("two", 2);
        wordsToNums.put("three", 3);
        wordsToNums.put("four", 4);
        wordsToNums.put("five", 5);
        wordsToNums.put("six", 6);
        wordsToNums.put("seven", 7);
        wordsToNums.put("eight", 8);
        wordsToNums.put("nine", 9);
        wordsToNums.put("ten", 10);
        wordsToNums.put("eleven", 11);
        wordsToNums.put("twelve", 12);
        wordsToNums.put("thirteen", 13);
        wordsToNums.put("fourteen", 14);
        wordsToNums.put("fifteen", 15);
        wordsToNums.put("sixteen", 16);
        wordsToNums.put("seventeen", 17);
        wordsToNums.put("eighteen", 18);
        wordsToNums.put("nineteen", 19);
        wordsToNums.put("twenty", 20);
        wordsToNums.put("thirty", 30);
        wordsToNums.put("forty", 40);
        wordsToNums.put("fifty", 50);
        wordsToNums.put("sixty", 60);
        wordsToNums.put("seventy", 70);
        wordsToNums.put("eighty", 80);
        wordsToNums.put("ninety", 90);
        wordsToNums.put("hundred", 100);
        
        String[] words = s.split(" ");
        int currentNum = 0;
        int previousNum = 0;

        for (String word : words) {
            if (word.equals("and")) {
                continue;
            }
            if (wordsToNums.containsKey(word)) {
                int num = wordsToNums.get(word);
                if (num == 100) {
                    previousNum *= 100;
                    currentNum = previousNum;
                } else if (num == 10) {
                    previousNum += num;
                } else {
                    currentNum += num;
                    previousNum = currentNum;
                }
            }
            
        }

        return currentNum;
    }	
    
	//Task7
	public static String uniqueSubstring(String str) {
	    if (str.isEmpty()) {
		return "";
	    }

	    String longestSubstring = "";
	    int maxLength = 0;
	    int[] charIndex = new int[256];

	    for (int i = 0; i < 256; i++) {
		charIndex[i] = -1;
	    }

	    int start = 0;
	    for (int i = 0; i < str.length(); i++) {
		if (charIndex[str.charAt(i)] >= start) {
		    start = charIndex[str.charAt(i)] + 1;
		}
		charIndex[str.charAt(i)] = i;

		if (i - start + 1 > maxLength) {
		    maxLength = i - start + 1;
		    longestSubstring = str.substring(start, i + 1);
		}
	    }
	    return longestSubstring;
	}
	
	//Task8
	public static int shortestWay(int[][] grid) {
	    int rows = grid.length;
	    int cols = grid[0].length;

	    // Initialize the DP array with the same dimensions as the grid
	    int[][] dp = new int[rows][cols];

	    // Initialize the first cell of the DP array
	    dp[0][0] = grid[0][0];

	    // Fill the first row of the DP array
	    for (int j = 1; j < cols; j++) {
		dp[0][j] = dp[0][j - 1] + grid[0][j];
	    }

	    // Fill the first column of the DP array
	    for (int i = 1; i < rows; i++) {
		dp[i][0] = dp[i - 1][0] + grid[i][0];
	    }

	    // Fill the rest of the DP array
	    for (int i = 1; i < rows; i++) {
		for (int j = 1; j < cols; j++) {
		    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
		}
	    }

	    // Return the minimum cost to reach the bottom-right cell
	    return dp[rows - 1][cols - 1];
	}
		
	//Task9
    public static String numericOrder(String str) {
        String[] wordsArr = str.split(" ");
        String[] orderedWords = new String[wordsArr.length];

        for (String word : wordsArr) {
            int num = Integer.parseInt(word.replaceAll("[^0-9]", ""));
            if (num > 0) {
                orderedWords[num - 1] = word.replaceAll("[0-9]", "");
            }
        }

        return String.join(" ", Arrays.copyOfRange(orderedWords, 0, wordsArr.length));
    }

		
	//Task10
    public static int switchNums(int num1, int num2) {
        String strNum1 = String.valueOf(num1);
        String strNum2 = String.valueOf(num2);

        // Convert num2 to a char array for easy manipulation
        char[] num2Digits = strNum2.toCharArray();

        // Iterate through the digits of num2
        for (int i = 0; i < num2Digits.length; i++) {
            char currentDigit2 = num2Digits[i];
            char maxDigit = currentDigit2;

            // Initialize a flag to check if num1digit is bigger than remaining digits in num1
            boolean num1DigitIsGreaterThanRemaining = false;

            // Iterate through the digits of num1 to find a digit greater than currentDigit2
            for (int j = 0; j < strNum1.length(); j++) {
                char num1Digit = strNum1.charAt(j);

                if (num1Digit > currentDigit2) {
                    num1DigitIsGreaterThanRemaining = true;

                    // Check if num1digit is bigger than remaining digits in num1
                    for (int k = j + 1; k < strNum1.length(); k++) {
                        char nextNum1Digit = strNum1.charAt(k);
                        if (num1Digit < nextNum1Digit) {
                            num1DigitIsGreaterThanRemaining = false;
                            break;
                        }
                    }

                    if (num1DigitIsGreaterThanRemaining) {
                        maxDigit = num1Digit;
                        // Remove the used digit from num1
                        strNum1 = strNum1.substring(0, j) + strNum1.substring(j + 1);
                        break;
                    }
                }
            }

            // If a greater digit was found, replace the digit in num2
            if (maxDigit != currentDigit2) {
                num2Digits[i] = maxDigit;
            }
        }

        // Convert the modified num2 digits back to an integer and return
        return Integer.parseInt(new String(num2Digits));
    }    
}
