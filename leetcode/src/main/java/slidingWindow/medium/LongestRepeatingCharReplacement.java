package slidingWindow.medium;

public class LongestRepeatingCharReplacement {

    //OPTIMAL APPROACH--------------------------------------------------------------------------------------------------

    public int characterReplacement(String s, int k) {

        int[] freq = new int[26];
        int maxFreq = 0;
        int maxWindow = 0;
        int l = 0;
        int r = 0;

        while(r < s.length()){
            freq[s.charAt(r) - 'A'] ++;//updating frequency of current character:

            maxFreq = Math.max(maxFreq , freq[s.charAt(r) - 'A']);//update maxFrequency:


            int windowLength = r - l + 1;//calc window length:
            if(windowLength - maxFreq > k){//if windowLength - maxFreq > k:
                freq[s.charAt(l) - 'A']--;//Decrease Frequency:
                l++;//Shrink the window Size:
            }

            windowLength = r - l + 1;//update Window Length:
            maxWindow = Math.max(maxWindow , windowLength);//Store MAXWINDOW SIZE:
            r++;
        }

        return maxWindow;
    }



}
