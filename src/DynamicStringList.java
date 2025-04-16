public class DynamicStringList implements StringList{
    private String[] data;
    private int size;

    public DynamicStringList() {
        data = new String[10];
        size = 0;
    }

    public String get(int index){
        checkIndex(index);
        return data[index];
    }

    public void set(int index, String value){
        checkIndex(index);
        data[index] = value;
    }

    public void add(String value) {
        if (size == data.length) {
            resize();
        }
        data[size] = value;
        size++;
    }

    public String remove(int index) {
        checkIndex(index);
        String removed = data[index];
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        data[size - 1] = null;
        size--;
        return removed;
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return data.length;
    }

    private void resize() {
        String[] newData = new String[data.length * 2];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
    }
}
