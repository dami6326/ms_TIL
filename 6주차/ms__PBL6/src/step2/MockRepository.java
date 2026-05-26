package step2;

import role.Role;
import java.util.*;

public class MockRepository implements Repository {

    @Override
    public void save(Role member) {
        System.out.println("[Mock] 저장된 척만 함");
    }

    @Override
    public List<Role> findAll() {
        System.out.println("[Mock] 항상 빈 리스트 반환");
        return new ArrayList<>();
    }

    @Override
    public Role findByName(String name) {
        System.out.println("[Mock] 항상 null 반환");
        return null;
    }

    @Override
    public boolean isDuplicate(String name) {
        return false; // 무조건 등록 가능
    }
}
