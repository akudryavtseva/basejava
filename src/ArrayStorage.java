import java.util.ArrayList;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    public ArrayList<Resume> listResume = new ArrayList<>();

    void clear() {
        listResume.clear();
    }

    void save(Resume r) {
        listResume.add(r);
    }

    Resume get(String uuid) {
        Resume[] resumes = listResume.toArray(new Resume[0]);
        for (Resume r : resumes) {
            if (r.toString().equals(uuid)) {
                return r;
            }
        }
        return null;
    }

    void delete(String uuid) {
        Resume u = this.get(uuid);
        listResume.remove(u);
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return listResume.toArray(new Resume[0]);
    }

    int size() {
        return listResume.size();
    }
}
