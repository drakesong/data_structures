public class SortedArrayMap implements Map {
//Created by Professor Justin Li

    class Definition {
        String key;
        String value;
        public Definition(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    private int size;
    private Definition[] array;

    public SortedArrayMap() {
        this.size = 0;
        this.array = new Definition[10];
    }

    public int size() {
        return this.size;
    }

    public void put(String key, String value) {
        int index = this.binarySearch(key, true);
        if (index < this.size && this.array[index].key.equals(key)) {
            return;
        }
        this.add(index, new Definition(key, value));
    }

    private void add(int index, Definition new_element) {
        if (this.size == this.array.length) {
            Definition[] new_array = new Definition[2 * this.array.length];
            for (int i = 0; i < this.array.length; i++) {
                new_array[i] = this.array[i];
            }
            this.array = new_array;
        }
        this.array[this.size] = new_element;
        for (int i = this.size; i > index; i--) {
            this.array[i] = this.array[i - 1];
        }
        this.array[index] = new_element;
        this.size++;
    }

    private int binarySearch(String key, boolean insertion) {
        int lo = 0;
        int hi = this.size - 1;
        int mid;
        while (lo <= hi) {
            mid = (lo + hi) / 2;
            int compare = key.compareTo(this.array[mid].key);
            if (compare < 0) {
                hi = mid - 1;
            } else if (compare == 0) {
                return mid;
            } else if (compare > 0) {
                lo = mid + 1;
            }
        }
        if (insertion) {
            return lo;
        } else {
            return -1;
        }
    }

    public void print() {
        for (int i = 0; i < this.size; i++) {
            System.out.println(this.array[i].key);
        }
        System.out.println();
    }

    public String get(String key) {
        int index = this.binarySearch(key, false);
        if (index == -1) {
            return null;
        } else {
            return this.array[index].value;
        }
    }

    public static void main(String[] args) {
        SortedArrayMap map = new SortedArrayMap();
        String[] keys = {"7", "9", "6", "0", "4", "2", "1"};
        String[] values = {"seven", "nine", "six", "zero", "four", "two", "one"};
        for (int i = 0; i < keys.length; i++) {
            map.put(keys[i], values[i]);
            map.print();
            System.out.println();
        }
        for (int i = 0; i < keys.length; i++) {
            System.out.print(keys[i]);
            System.out.print(" ");
            System.out.println(map.get(keys[i]));
        }
    }
}
