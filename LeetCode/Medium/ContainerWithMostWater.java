package DATA_STRUCTURE.LeetCode.Medium;

public class ContainerWithMostWater {
    // Success
    public static int maxArea(int[] height) {
        // for (int i = 0; i < height.length; i++) {
        // for (int j = height.length - 1; j >= i; j--) {
        // if (height[i] < height[j]) {
        // area *= (j - i) * height[i];
        // } else {
        // area *= (j - i) * height[j];
        // }
        // if (area > maxarea) {
        // maxarea = area;
        // }
        // area = 1;
        // }
        // }
        int area = 1;
        int maxarea = -Integer.MAX_VALUE;
        int i = 0;
        int j = height.length - 1;
        while (i < j) {
            if (height[i] < height[j]) {
                area *= (j - i) * height[i];
                i++;
            } else {
                area *= (j - i) * height[j];
                j--;
            }
            if (area > maxarea) {
                maxarea = area;
            }
            area = 1;
        }
        return maxarea;
    }

    public static void main(String[] args) {
        int height[] = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        System.out.println(maxArea(height));
    }
}
