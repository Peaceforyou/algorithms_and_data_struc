public class Main {
    public static void main(String[] args) {
        //task is to find the index of given number in the sorted array

        int[] numbers = {1,3,5,7,9,11,13};
        System.out.println(search(numbers, 7));

    }

        private static int search(int[] numbers, int target) {
            int left = 0;
            int right = numbers.length - 1;

            while (left <= right) {
                int mid = left + (right - left) / 2;

                if (numbers[mid] == target) {
                    return mid;
                }
                if (numbers[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return -1;
        }
    }
