package collection;

public class MySet extends MyVector implements Cloneable {
    public int cardinality() {
        return size();

    }

    public MySet complement(MySet SetD) {
        MySet SetC = new MySet();
        MySet setD = SetD;
        for (int i = 0; i < cardinality(); i++) {
            Object ele = elementAt(i);
            if (!SetD.contains(ele)) {
                SetC.insert(ele);
            }
        }
        return SetC;
    }

    public boolean insert(Object element) {
        if (contains(element)) {
            return false;
        } else {
            super.append(element);
            return true;
        }
    }

    public MySet intersection(MySet SetD) {
        MySet SetC = new MySet();
        MySet setD = SetD;
        for (int i = 0; i < cardinality(); i++) {
            if (SetD.contains(elementAt(i))) {
                SetC.insert(elementAt(i));
            }
        }
        return SetC;
    }

    public boolean subsetOf(MySet SetD) {
        for (int i = 0; i < cardinality(); i++) {
            if (!SetD.contains(elementAt(i))) {
                return false;
            }
        }
        return true;
    }

    public MySet union(MySet SetD) {
        MySet SetF = SetD.clone();
        for (int i = 0; i < cardinality(); i++) {
            SetF.insert(elementAt(i));
        }
        return SetF;
    }

    public MySet symmetricDifference(MySet SetD) {
        MySet SetC = this.complement(SetD);
        MySet SetE = SetD.complement(this);
        return SetC.union(SetE);
    }

    public MySet powerSet() {
        MySet set = new MySet();
        int setSize = this.cardinality();
        for (int i = 0; i < (1 << setSize); i++) {
            MySet tempSet = new MySet();
            for (int j = 0; j < setSize; j++) {
                if ((i & (1 << j)) > 0) {
                    tempSet.insert(elementAt(j));
                }
            }
            set.insert(tempSet);
        }

        return set;
    }

    @Override
    public MySet clone() {
        MySet vecCopy = new MySet();
        for (int i = 0; i < size(); ++i) {
            vecCopy.data[i] = this.data[i];
        }
        vecCopy.size = this.size;
        return vecCopy;
    }

    @Override
    public String toString() {
        String str = "{";
        for (int i = 0; i < size; i++) {
            String comma = i == size - 1 ? "" : ", ";
            str += data[i] + comma;
        }
        str += "}";
        return str;
    }
}
