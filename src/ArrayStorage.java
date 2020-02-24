import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        int storageSize = size();
        Arrays.fill(storage, 0, storageSize, null);
    }

    void save(Resume r) {
        int storageSize = size();
        storage[storageSize] = r;
    }

    Resume get(String uuid) {
        int storageSize = size();
        for (int i = 0; i < storageSize; i++) {
            if (storage[i].toString().equals(uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        int storageSize = size();
        int k = -1;
        for (int i = 0; i < storageSize; i++) {
            if (storage[i].toString().equals(uuid)) {
                k = i;
                break;
            }
        }
        if (k >= 0) {
            for (int j = k; j < storageSize; j++) {
                storage[j] = storage[j + 1];
            }
            storage[storageSize] = null;
        } else System.out.println("Неверный uuid.");
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        int storageSize = size();
        Resume[] resumes = new Resume[storageSize];
        for (int i = 0; i < storageSize; i++) {
            resumes[i] = storage[i];
        }
        return resumes;
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
