package collection;

public class MyVector implements Cloneable {
    protected int size;
    protected Object[] data;
    protected final int INITIAL_CAPACITY = 100;

    public MyVector() {
        data = new Object[INITIAL_CAPACITY];
        size = 0;
    }

    //ensure data capacity is large enough
    protected void ensureCapacity(int minCapacity) {
        if (minCapacity <= data.length - size) {
            return;
        }
        Object[] temp = new Object[size + minCapacity];
        for (int i = 0; i < size; i++) {
            temp[i] = data[i];
        }
        data = temp;
    }

    protected void append(Object element) {
        ensureCapacity(size + 1);
        data[size] = element;
        size++;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            data[i] = null;
        }
        size = 0;
    }

    public int indexOf(Object element) {
        for (int i = 0; i < size; i++) {
            if (element.equals(data[i])) {
                return i;
            }
        }
        return -1;
    }

    protected boolean contains(Object element) {
        return indexOf(element) != -1;
    }

    public Object elementAt(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return data[index];
    }


    public boolean insertAt(int index, Object element) {
        if (index < 0 || index >= size) {
            return false;
        }
        if (size == data.length) {
            ensureCapacity(size + 1);
        }
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = element;
        return true;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Object removeAt(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        Object temp = data[index];
        while (index < size - 1) {
            data[index] = data[index + 1];
            index++;
        }
        data[size--] = null;
        return temp;
    }

    public boolean remove(Object element) {
        return removeAt(indexOf(element)) != null;
    }

    public boolean replace(int index, Object element) {
        if (index < 0 || index >= size) {
            return false;
        }
        data[index] = element;
        return true;
    }

    protected int size() {
        return size;
    }

    public MyVector clone() {
        MyVector vCopy = new MyVector();
        vCopy.ensureCapacity(this.size);
        for (int i = 0; i < size; i++) {
            vCopy.data[i] = this.data[i];
        }
        vCopy.size = this.size;
        return vCopy;
    }

    public void removeRange(int fromIndex, int toIndex) {
        if (fromIndex >= toIndex) {
            return;
        }
        if (fromIndex < 0) {
            fromIndex = 0;
        }
        if (toIndex >= size) {
            toIndex = size;
        }
        int num = toIndex - fromIndex;
        for (int i = fromIndex; i < size - 1; i++) {
            data[i] = data[i + num];
        }
        for (int j = size - num; j < size; j++) {
            data[j] = null;
        }
        size = size - num;
    }

    public String toString() {
        String str = "\n";

        str += "size " + size + "\n";
        str += "capacity = " + data.length + "\n";
        for (int i = 0; i < size; i++) {
            str += i + " : " + data[i] + "\n";
            if ((i + 1) % 5 == 0) {
                str += "\n";
            }
        }
        return str;
    }

    public void reverse() {
        Object temp;
        for (int i = 0; i < size / 2; i++) {
            temp = data[i];
            data[i] = data[size - 1 - i];
            data[size - 1 - i] = temp;
        }
    }

    protected void merge(MyVector vector2) {
        for (int i = 0; i < vector2.size; i++) {
            append(vector2.data[i]);
        }
    }
}
