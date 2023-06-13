package ModelsRepo;

import java.util.List;

public interface IRepository<T>{
    void load();
    void save();
    List<T> toList();
    void add(T ...objeto);
    void delete(int id);

    void modify(T nuevoObjeto);
}
