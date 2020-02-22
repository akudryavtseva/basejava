import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        Arrays.fill(storage, null);
    }

    void save(Resume r) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                storage[i] = r;
                break;
            }
        }
    }

    Resume get(String uuid) {
        int k = 0;
        for (int i = 0; i < size(); i++) {
            if (storage[i].toString().equals(uuid)) {
                k = i;
                break;
            } else k = -1;
        }

        if (k != -1) {
            return storage[k];
        } else return null;
    }

    void delete(String uuid) {
        int k = 0;
        for (int i = 0; i < size(); i++) {
            if (storage[i].toString().equals(uuid)) {
                k = i;
                break;
            } else {
                k = -1;
            }
        }
        if (k != -1) {
            for (int j = k; j < size(); j++) {
                storage[j] = storage[j + 1];
                storage[j + 1] = null;
            }
        } else System.out.println("Неверный uuid.");
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] newStorage = new Resume[size()];
        for (int i = 0; i < size(); i++) {
            newStorage[i] = storage[i];
        }
        return newStorage;
    }

    int size() {
        int s = 0;
        for (Resume element : storage) {
            if (element != null) {
                s++;
            }
        }
        return s;
    }
}
