package ModelsRepo;

import Models.Administrator;
import Models.Buyer;
import Models.User;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class AdministratorRepo implements IRepository<Administrator> {

    private final File file = new File("src/main/java/org/example/Files/administrators.json");
    private ObjectMapper mapper = new ObjectMapper();
    private ArrayList<Administrator> admsList;


    @Override
    public void load() {

    }

    @Override
    public void save() {

    }

    @Override
    public List<Administrator> toList() {
        return null;
    }

    @Override
    public void add(Administrator... objeto) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void modify(Administrator nuevoObjeto) {

    }
}
